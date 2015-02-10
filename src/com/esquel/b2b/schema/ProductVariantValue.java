/** 
 * ProductVariantValue.java
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
package com.esquel.b2b.schema;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.joyaether.datastore.schema.StoredProcedure;
import com.joyaether.datastore.schema.StoredProcedureObject;
import com.joyaether.datastore.schema.StoredProcedureParameters;

@StoredProcedure(read = "USP_B2B_ProductVariantValues")
public class ProductVariantValue extends StoredProcedureObject<ProductVariantValue, Void> implements StoredProcedureParameters {
	
	// For query
	public static final String EAP_CODE_FIELD_NAME = "eap_code";
	public static final String VARIANT_FIELD_NAME = "variant";
	public static final String VALUE_FIELD_NAME = "value";
	
	private String eapCode;
	
	private String variant;
	
	@DatabaseField(columnName = VALUE_FIELD_NAME)
	@SerializedName(VALUE_FIELD_NAME)
	@Expose
	private String value;
	
	ProductVariantValue() {
		// Must have an no-arg constructor
	}
	
	/**
	 * Creates a new instance of {@link ProductVariantValue}
	 * 
	 * @param eapCode an identifier for a label product in EAP
	 * @param attributeName the name of the attribute to return its possible values
	 */
	private ProductVariantValue(String eapCode, String attributeName) {
		this.eapCode = eapCode;
		this.variant = attributeName;
	}
	
	/**
	 * Returns a list of possible values for a label product identified by the given EAP product identifier and the name of the attribute
	 * 
	 * @param eapCode an identifier of a label product in EAP
	 * @param attributeName the name of the attribute to return the possible values
	 * @return a list of available values for the given EAP product identifier and attribute name, {@code null} if the query could not be performed
	 * @throws SQLException thrown if there was problem accessing the database
	 */
	public static List<ProductVariantValue> get(String eapCode, String attributeName, ConnectionSource connectionSource) throws SQLException {
		if (connectionSource != null) {
			Dao<ProductVariantValue, Void> dao = DaoManager.createDao(connectionSource, ProductVariantValue.class);
			return StoredProcedureObject.fetch(new ProductVariantValue(eapCode, attributeName), dao);
		}
		return null;
	}
	
	/**
	 * Return the value in the query result 
	 * 
	 * @return the value in the query result
	 */
	public String getValue() {
		return value;
	}

	@Override
	public String[] toArguments(Type type) {
		String[] result = null;
		switch (type) {
		case READ:
			result = new String[] { eapCode, variant };
			return result;
		case UPDATE:
		case CREATE:
		default:
			return null;
		}
	}

}
