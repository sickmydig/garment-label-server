/** 
 * BrandServerResource.java
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
import com.esquel.b2b.schema.Currency;
import com.esquel.b2b.schema.Customer;
import com.j256.ormlite.support.ConnectionSource;
import com.joyaether.datastore.resource.ReadonlyDataObjectServerResource;
import com.joyaether.datastore.schema.Query;

public class CurrencyServerResource extends ReadonlyDataObjectServerResource<Currency, Long> {
	
	@Override
	protected Query parseRequest(boolean isCountQuery) throws SQLException, MalformedURLException {
		Query query = super.parseRequest(isCountQuery);
		
		// By default, we want to return currencies a given customer can use.
		// Yet, the current database table dbo.Currency does not contain such
		// information, we merely remove customer ID from the query
		if (query.getArguments() != null) {
			if (query.getArguments().keySet().contains(Customer.CUSTOMER_ID_FIELD_NAME)) {
				query.getArguments().remove(Customer.CUSTOMER_ID_FIELD_NAME);
			}
		}
		
		return query;
	}
	
	@Override
	protected ConnectionSource getConnectionSource() throws SQLException {
		if (getApplication() instanceof DatastoreApplication) {
			return ((DatastoreApplication) getApplication()).getDatastore(Store.EAP).getConnectionSource();
		}
		return null;
	}

	@Override
	protected Class<Currency> getResourceType() {
		return Currency.class;
	}

	@Override
	protected Long getId() {
		// We always return {@code null}. We want to return currencies for a particular customer
		return null;
	}

}