/** 
 * ProductAttachment.java
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
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "UVW_B2BCustomerPayment")
public class CustomerPayment extends Model<CustomerPayment, Long> implements Identity<Long> {
	
	public static final String CUSTOMER_ID_FIELD_NAME = "customer_id";
	public static final String CUSTOMER_NAME_FIELD_NAME = "customer_name";
	public static final String PAYMENT_TERM_FIELD_NAME = "payment_term";
	public static final String PAYMENT_TERM_NAME_FIELD_NAME = "payment_term_name";
	public static final String DEFAULT_FIELD_NAME = "default";
	
	@DatabaseField(
			columnName = "CustomerID", 
			canBeNull = false)
	@SerializedName(CUSTOMER_ID_FIELD_NAME)
	@Expose
	private Long customerID;
	
	@DatabaseField(
			columnName = "CustomerName", 
			canBeNull = true)
	@SerializedName(CUSTOMER_NAME_FIELD_NAME)
	@Expose
	private String customerName;
	
	@DatabaseField(
			columnName = "PaymentTermID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(PAYMENT_TERM_FIELD_NAME)
	@Expose
	private PaymentTerm paymentTerm;
	
	@DatabaseField(
			columnName = "PaymentTerm", 
			canBeNull = true)
	@SerializedName(PAYMENT_TERM_NAME_FIELD_NAME)
	@Expose
	private String paymentTermName;
	
	@DatabaseField(
			columnName = "IsDefault", 
			canBeNull = true)
	@SerializedName(DEFAULT_FIELD_NAME)
	@Expose
	private boolean isDefault;
	
	public CustomerPayment() {
		
	}
	
	@Override
	public Long getIdentity() {
		return customerID;
	}

	@Override
	public String getIdentityAttribute() {
		return CUSTOMER_ID_FIELD_NAME;
	}
}
