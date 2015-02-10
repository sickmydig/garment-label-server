/** 
 * CustomerProductServerResource.java
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

import com.esquel.b2b.DatastoreApplication;
import com.esquel.b2b.DatastoreApplication.Store;
import com.esquel.b2b.schema.CustomerProduct;
import com.j256.ormlite.support.ConnectionSource;
import com.joyaether.datastore.resource.ReadonlyDataObjectServerResource;
import com.joyaether.datastore.schema.Query;

/**
 * Provide read access to the products an EAP customer can order 
 */
public class CustomerProductServerResource extends ReadonlyDataObjectServerResource<CustomerProduct, Long> {
	
	/** Error messages. */
	private static final String ERROR_MISSING_PARAMETER = "Parameter '%s' is missing";
	
	/**
	 * Returns the identifier of the customer to return the products s/he can order in EAP system 
	 * 
	 * @return the identifier of a customer
	 */
	protected Long getCustomerId() {
		String id = getAttribute(CustomerProduct.CUSTOMER_FIELD_NAME);
		if (id == null) {
			id = getQueryValue(CustomerProduct.CUSTOMER_FIELD_NAME);
		}
		return id == null ? null : Long.parseLong(id);
	}
	
	@Override
	protected Query parseRequest(boolean isCountQuery) throws SQLException, MalformedURLException {
		Query result = super.parseRequest(isCountQuery);
		
		if (result != null && !result.getArguments().containsKey(CustomerProduct.CUSTOMER_FIELD_NAME)) {
			Long customerId = getCustomerId();
			if (customerId != null) {				
				result.fieldIsEqualTo(CustomerProduct.CUSTOMER_FIELD_NAME, customerId);
			} else {
				throw new MalformedURLException(String.format(ERROR_MISSING_PARAMETER, CustomerProduct.CUSTOMER_FIELD_NAME));
			}
		}
		
		return result;
	}
	
	@Override
	protected ConnectionSource getConnectionSource() throws SQLException {
		if (getApplication() instanceof DatastoreApplication) {
			return ((DatastoreApplication) getApplication()).getDatastore(Store.EAP).getConnectionSource();
		}
		return null;
	}

	@Override
	protected Class<CustomerProduct> getResourceType() {
		return CustomerProduct.class;
	}

	@Override
	protected Long getId() {
		// We always return {@code null} because there is no real ID field in the data model
		return null;
	}

}
