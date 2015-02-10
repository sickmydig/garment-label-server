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

import java.sql.SQLException;

import com.esquel.b2b.DatastoreApplication;
import com.esquel.b2b.DatastoreApplication.Store;
import com.esquel.b2b.schema.Brand;
import com.j256.ormlite.support.ConnectionSource;
import com.joyaether.datastore.resource.ReadonlyDataObjectServerResource;

public class BrandServerResource extends ReadonlyDataObjectServerResource<Brand, Long> {
	
	@Override
	protected ConnectionSource getConnectionSource() throws SQLException {
		if (getApplication() instanceof DatastoreApplication) {
			return ((DatastoreApplication) getApplication()).getDatastore(Store.EAP).getConnectionSource();
		}
		return null;
	}

	@Override
	protected Class<Brand> getResourceType() {
		return Brand.class;
	}

	@Override
	protected Long getId() {
		String id = (String) getRequest().getAttributes().get(Brand.BRAND_ID_FIELD_NAME);
		return id == null ? null : Long.parseLong(id);
	}

}
