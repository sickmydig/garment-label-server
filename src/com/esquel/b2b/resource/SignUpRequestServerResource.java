/** 
 * SignUpRequestServerResource.java
 *
 * Copyright (c) 2008-2014 Joy Aether Limited. All rights reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * 
 * This unpublished material is proprietary to Joy Aether Limited.
 * All rights reserved. The methods and
 * techniques described herein are considered trade secrets
 * and/or confidential. Reproduction or distribution, in whole
 * or in part, is forbidden except by express written permission
 * of Joy Aether Limited.
 */
package com.esquel.b2b.resource;

import static com.google.common.base.Preconditions.checkNotNull;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;

import com.esquel.b2b.schema.Company;
import com.esquel.b2b.schema.SignUpRequest;
import com.esquel.b2b.schema.User;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.joyaether.datastore.exception.DatastoreException;
import com.joyaether.datastore.exception.NotAllowedException;
import com.joyaether.datastore.exception.ResourceNotFoundException;
import com.joyaether.datastore.resource.DataObjectServerResource;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.ModelAttributes;
import com.joyaether.datastore.schema.Query;
import com.joyaether.datastore.schema.Schema;

public class SignUpRequestServerResource extends DataObjectServerResource<SignUpRequest, String> {
	
	/** Error messages. */
	private static final String ERROR_INVALID_PARAMETER = "Parameter '%s' is invalid";
	private static final String ERROR_USER_QUOTA_REACHED = "The maximum number of users allowable for the company is reached";
	
	/**
	 * A validator to validate the credential of the sign-up request
	 */
	private class IdentityValidator extends EmailValidator {
		
		private static final long serialVersionUID = -2338559410262749765L;
		
		/** The {@link Company} this validator to validate against */
		private final Company company;

		protected IdentityValidator(Company company) {
			super(false);
			this.company = company;
		}
		
		@Override
		protected boolean isValidDomain(String domain) {
			boolean result = super.isValidDomain(domain);
			if (result) {
				if (company.isEnforceDomain() && company.getDomain() != null) {
					return company.getDomain().equalsIgnoreCase(domain);
				}
			}
			return result;
		}
		
	}
	
	@Override
	protected void onBeforeCreate(Object object) throws DatastoreException {
		if (object instanceof SignUpRequest) {
			SignUpRequest request = (SignUpRequest) object;
			String email = request.getAdministratorEmail();
			checkNotNull(email, String.format(ERROR_INVALID_PARAMETER, SignUpRequest.ADMIN_EMAIL_FIELD_NAME));
			
			try {
				Query query = new Query();
				query.fieldIsEqualTo(User.EMAIL_FIELD_NAME, email);
				List<User> users = Model.find(getConnectionSource(), User.class, query);
				Company company = users != null && !users.isEmpty() ? users.get(0).getCompany() : null;
				
				if (company != null) {
					IdentityValidator validator = new IdentityValidator(company);
					if (!validator.isValid(request.getIdentity())) {
						throw new NotAllowedException(String.format(ERROR_INVALID_PARAMETER, SignUpRequest.ID_FIELD_NAME));						
					}
					request.setCompany(company);
					request.setStatus(SignUpRequest.Status.PENDING);
				} else {
					throw new ResourceNotFoundException(Company.class.getSimpleName());
				}
			} catch (SQLException ex) {
				throw new DatastoreException(ex);
			}
		}
	}
	
	@Override
	protected void onBeforeModify(Object object) throws DatastoreException {
		if (object instanceof SignUpRequest) {
			SignUpRequest request = (SignUpRequest) object;
			
			try {
				SignUpRequest beforeUpdateRequest = Model.find(getConnectionSource(), SignUpRequest.class, request.getIdentity());
				if (beforeUpdateRequest != null 
						&& request.getStatus() != beforeUpdateRequest.getStatus() 
						&& request.getStatus() == SignUpRequest.Status.APPROVED) {
					
					// Make sure the number of users quota is not exceeded
					ModelAttributes attrs = Schema.getAttributes(User.class);
					Dao<User, String> dao = DaoManager.createDao(getConnectionSource(), User.class);
					QueryBuilder<User, String> qb = dao.queryBuilder();
					qb.where().eq(attrs.getColumnName(User.COMPANY_FIELD_NAME), beforeUpdateRequest.getCompany().getIdentity());
					long numberOfExistingUsers = qb.countOf();
					
					beforeUpdateRequest.getCompany().refresh();
					if (numberOfExistingUsers >= beforeUpdateRequest.getCompany().getUserQuota()) {
						throw new NotAllowedException(ERROR_USER_QUOTA_REACHED);
					}
					
					// We need to create a new user
					User usr = request.toUser();
					usr.create(getConnectionSource());
				}
			} catch (SQLException ex) {
				throw new DatastoreException(ex);
			}
		}
	}
	
	@Override
	protected String getId() {
		String id = (String) getRequest().getAttributes().get(SignUpRequest.ID_FIELD_NAME);
		return id;
	}
	
	@Override
	protected Class<SignUpRequest> getResourceType() {
		return SignUpRequest.class;
	}
	
}

