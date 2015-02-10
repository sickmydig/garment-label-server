/** 
 * ProductVariantValueServerResource.java
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
import java.util.Map;

import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;

import com.esquel.b2b.DatastoreApplication;
import com.esquel.b2b.DatastoreApplication.Store;
import com.esquel.b2b.schema.ProductVariantValue;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import com.j256.ormlite.support.ConnectionSource;
import com.joyaether.datastore.representation.ExceptionRepresentation;
import com.joyaether.datastore.representation.GsonRepresentation;
import com.joyaether.datastore.resource.SqlServerResource;
import com.joyaether.datastore.serialization.BlobDeserializer;

/**
 * Returns the possible values of a variant of a label product in EAP
 */
public class ProductVariantValueServerResource extends SqlServerResource {
	
	/** Error message */
	private static final String ERROR_MESSAGE = "%s cannot be null";
	
	@Get("json")
	public Representation handleGet() {
		Representation result = null;
		
		try {
			String eapCode = getQueryValue(ProductVariantValue.EAP_CODE_FIELD_NAME);
			String attributeName = getQueryValue(ProductVariantValue.VARIANT_FIELD_NAME);
			
			checkNotNull(eapCode, String.format(ERROR_MESSAGE, ProductVariantValue.EAP_CODE_FIELD_NAME));
			checkNotNull(eapCode, String.format(ERROR_MESSAGE, ProductVariantValue.VARIANT_FIELD_NAME));
			
			List<ProductVariantValue> values = ProductVariantValue.get(eapCode, attributeName, getConnectionSource());
			JsonArray array = new JsonArray();
			if (values != null) {				
				for (ProductVariantValue value : values) {
					array.add(new JsonPrimitive(value.getValue()));
				}
			}
			result = new GsonRepresentation(array);
		} catch (Exception ex) {
			Status status = getApplication().getStatusService().getStatus(ex, this);
			setStatus(status);
			result = new ExceptionRepresentation(ex);
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
	protected Map<Class<?>, BlobDeserializer<?>> getBlobDeserializers() {
		// We do not support deserialization of BLOB data
		return null;
	}

	

}
