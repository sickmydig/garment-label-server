/** 
 * ProductVariantServerResource.java
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
import com.esquel.b2b.schema.ProductVariant;
import com.j256.ormlite.support.ConnectionSource;
import com.joyaether.datastore.resource.ReadonlyDataObjectServerResource;
import com.joyaether.datastore.schema.Query;

/**
 * Provides read access to the uvw_b2bProductVariantStruct view in EAP system.
 */
public class ProductVariantServerResource extends ReadonlyDataObjectServerResource<ProductVariant, Long> {
	
	/**
	 * Returns the unique identifier of the company that caller wish to query for related companies
	 * 
	 * @return the unique identifier of the company, {@code null} if no identifier is supplied
	 */
	protected String getEapCode() {
		String id = getAttribute(ProductVariant.EAP_CODE_FIELD_NAME);
		if (id == null) {
			id = getQuery().getFirstValue(ProductVariant.EAP_CODE_FIELD_NAME, true);
		}
		return id;
	}
	
	@Override
	protected ConnectionSource getConnectionSource() throws SQLException {
		if (getApplication() instanceof DatastoreApplication) {
			return ((DatastoreApplication) getApplication()).getDatastore(Store.EAP).getConnectionSource();
		}
		return null;
	}
	
	@Override
	protected Query parseRequest(boolean isCountQuery) throws SQLException, MalformedURLException {
		Query query = super.parseRequest(isCountQuery);
		
		// Caller must supply a EAP code
		String eapCode = getEapCode();
		if (eapCode == null) {
			throw new MalformedURLException(ERROR_SQL_SYNTAX);
		}
		
		// Add EAP code into the query
		if (query != null && !query.getArguments().containsKey(ProductVariant.EAP_CODE_FIELD_NAME)) {
			query.fieldIsEqualTo(ProductVariant.EAP_CODE_FIELD_NAME, eapCode);
		}
		
		return query;
	}

	@Override
	protected Long getId() {
		// Always return {@code null} because we do not have ID field in the view
		return null;
	}

	@Override
	protected Class<ProductVariant> getResourceType() {
		return ProductVariant.class;
	}

}
