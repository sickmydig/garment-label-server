/** 
 * CustomerLogo.java
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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

/**
 * A data model for a customer but only de-serialize the logo field from database
 */
@DatabaseTable(tableName = "dtCustomerLogo")
public class CustomerLogo extends Model<CustomerLogo, Long> implements Identity<Long> {
	
	// For query
	public static final String CUSTOMER_ID_FIELD_NAME = "customer_id";
	public static final String LOGO_FIELD_NAME = "logo";
	
	@DatabaseField(
			columnName = "CustomerID",
			id = true)
	@SerializedName(CUSTOMER_ID_FIELD_NAME)
	@Expose
	private Long customerId;

	@DatabaseField(
			columnName = "logo",
			dataType = DataType.BYTE_ARRAY)
	@SerializedName(LOGO_FIELD_NAME)
	private byte[] logo;
	
	public CustomerLogo() {
		// Must have an no-arg constructor
	}

	@Override
	public Long getIdentity() {
		return customerId;
	}

	@Override
	public String getIdentityAttribute() {
		return CUSTOMER_ID_FIELD_NAME;
	}
	
	/**
	 * Returns the logo image as a byte array
	 * 
	 * @return the logo image as a byte array
	 */
	public byte[] getLogo() {
		return logo;
	}

}
