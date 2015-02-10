/** 
 * CompanyListServerResource.java
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

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.esquel.b2b.DatastoreApplication;
import com.esquel.b2b.DatastoreApplication.Store;
import com.esquel.b2b.schema.BrandCustomer;
import com.esquel.b2b.schema.Company;
import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.j256.ormlite.support.ConnectionSource;
import com.joyaether.datastore.Datastore;
import com.joyaether.datastore.exception.InvalidParameterException;
import com.joyaether.datastore.exception.ResourceNotFoundException;
import com.joyaether.datastore.resource.ReadonlyDataObjectServerResource;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Query;

public class CompanyListServerResource extends ReadonlyDataObjectServerResource<Company, String> {
	
	/**
	 * Returns the unique identifier of the company that caller wish to query for related companies
	 * 
	 * @return the unique identifier of the company, {@code null} if no identifier is supplied
	 */
	protected String getCompanyId() {
		String id = getAttribute(Company.ID_FIELD_NAME);
		if (id == null) {
			id = getQuery().getFirstValue(Company.ID_FIELD_NAME, true);
		}
		return id;
	}
	
	/**
	 * Returns a connection source to the given {@link Store}
	 * 
	 * @param store the store to return the connection source
	 * @return the connection source to the given store, {@code null} if the store is not defined or if the containing application is not a {@link DatastoreApplication}
	 * @throws SQLException thrown if there was problem connecting to the database
	 */
	protected ConnectionSource getConnectionSource(Store store) throws SQLException {
		if (getApplication() instanceof DatastoreApplication) {
			Datastore datastore = ((DatastoreApplication) getApplication()).getDatastore(store);
			if (datastore != null) {				
				return datastore.getConnectionSource();
			}
		}
		return null;
	}
	
	@Override
	protected Query parseRequest(boolean isCountQuery) throws SQLException, MalformedURLException {
		Query query = super.parseRequest(isCountQuery);
		
		// Caller must supply a company identifier
		String companyId = getCompanyId();
		if (companyId == null) {
			throw new MalformedURLException(ERROR_SQL_SYNTAX);
		}
		
		// Remove the company ID in query. This API is to return the related
		// companies, not the company identified by the identifier.
		if (query != null && query.getArguments().containsKey(Company.ID_FIELD_NAME)) {
			query.getArguments().remove(Company.ID_FIELD_NAME);
		}
		
		// We manually construct a query that queries related companies
		Company company = Model.find(getConnectionSource(), Company.class, companyId);
		if (company == null) {
			throw new ResourceNotFoundException(companyId);
		}
		
		Query q = new Query();
		CloseableWrappedIterable<BrandCustomer> brandCustomers = null;
		List<Long> companies = null;
		
		switch (Company.Type.valueOf(company.getCompanyType())) {
		case EAP:
			// For a EAP company, we basically return all companies in the
			// system. In such case, we don't need to apply additional filter
			break;
		case VENDOR:
			// For a vendor, we want to return itself, as well as the brands that it works for
			q.fieldIsEqualTo(BrandCustomer.CUSTOMER_FIELD_NAME, company.getVendorId());
			brandCustomers = Model.fetch(getConnectionSource(Store.EAP), BrandCustomer.class, q);
			if (brandCustomers != null) {
				try {
					for (BrandCustomer brandCustomer : brandCustomers) {
						Long brandId = brandCustomer.getBrand() == null ? null : brandCustomer.getBrand().getIdentity();
						if (brandId != null) {
							if (companies == null) {
								companies = new ArrayList<Long>();
							}
							
							if (!companies.contains(brandId)) {
								companies.add(brandId);
							}
						}
					}
					
					if (companies != null) {
						query.fieldIsIn(Company.EAPMIS_BRAND_ID_FIELD_NAME, companies);
					} else {
						// There is no brand that this vendor works for, we should apply a filter that returns nothing
						query.fieldIsNull(Company.ID_FIELD_NAME);
					}
				} finally {
					brandCustomers.close();
				}
			}
			break;
		case BRAND:
			// For a brand, we want to return itself, as well as the its vendors
			q.fieldIsEqualTo(BrandCustomer.SUB_BRAND_FIELD_NAME, company.getBrandId());
			brandCustomers = Model.fetch(getConnectionSource(Store.EAP), BrandCustomer.class, q);
			if (brandCustomers != null) {
				try {
					for (BrandCustomer brandCustomer : brandCustomers) {
						Long customerId = brandCustomer.getCustomer() == null ? null : brandCustomer.getCustomer().getIdentity();
						if (customerId != null) {
							if (companies == null) {
								companies = new ArrayList<Long>();
							}
							
							if (!companies.contains(customerId)) {
								companies.add(customerId);
							}
						}
					}
					
					if (companies != null) {
						query.fieldIsIn(Company.EAPMIS_VENDOR_ID_FIELD_NAME, companies);
					} else {
						// There is no brand that this vendor works for, we should apply a filter that returns nothing
						query.fieldIsNull(Company.ID_FIELD_NAME);
					}
				} finally {
					brandCustomers.close();
				}
			}
			break;
		default:
			throw new InvalidParameterException(Company.COMPANY_TYPE_FIELD_NAME);
		}
		
		return query;
	}

	@Override
	protected Class<Company> getResourceType() {
		return Company.class;
	}

	@Override
	protected String getId() {
		// We always return {@code null} because we are querying related companies for a company 
		return null;
	}

}
