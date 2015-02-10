/** 
 * BrandVendor.java
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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

/**
 * A data model that defines the relationships between a brand and its customers
 */
@DatabaseTable(tableName = "dtBrandCustomer")
public class BrandVendor extends Model<BrandVendor, Long> implements Identity<Long> {
	
	public static final String CUSTOMER_ID_FIELD_NAME = "customer_id";
	public static final String BRAND_ID_FIELD_NAME = "brand_id";
	public static final String BRAND_CUSTOMER_ID_FIELD_NAME = "brand_customer_id";
    public static final String ID_FIELD_NAME = "iden";
    public static final String CONTACT_PERSON_FIELD_NAME = "constact_person";
    public static final String CONTACT_EMAIL_FIELD_NAME = "contact_email";
    public static final String CUSTOMER_NAME_FIELD_NAME = "customer_name";
    public static final String TELEPHONE_FIELD_NAME = "telephone";
    
    @DatabaseField(
			columnName = ID_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	private Long iden;
    
    @DatabaseField(
			columnName = "BrandCustomerID", 
			canBeNull = true,
			id = true)
	@SerializedName(BRAND_CUSTOMER_ID_FIELD_NAME)
	private Long brandCustomerID;
    
    @DatabaseField(
			columnName = "BrandID", 
			canBeNull = false)
	@SerializedName(BRAND_ID_FIELD_NAME)
	@Expose
	private Long brandId;
    
	@DatabaseField(
			columnName = "CustomerID", 
			canBeNull = false, 
			useGetSet = true)
	@SerializedName(CUSTOMER_ID_FIELD_NAME)
	@Expose
	private Long customerId;
	
	@SerializedName(CONTACT_PERSON_FIELD_NAME)
	@Expose
	private String contactPerson;
	
	@SerializedName(CONTACT_EMAIL_FIELD_NAME)
	@Expose
	private String email;
	
	@SerializedName(CUSTOMER_NAME_FIELD_NAME)
	@Expose
	private String customerName;
	
	@SerializedName(TELEPHONE_FIELD_NAME)
	@Expose
	private String telephone;
	
	BrandVendor() {
		// Must have an no-arg constructor
	}

	/**
	 * Returns the unique identifier of the customer
	 * @return the unique identifier of the customer
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * Specifies the new unique identifier of the customer
	 * 
	 * @param customerId the new unique identifier of the customer
	 * @throws SQLException thrown if there was error accessing the database
	 */
	public void setCustomerId(Long customerId) throws SQLException {
		this.customerId = customerId;
		
		if (getDao() != null) {
			Customer customer = Model.find(getDao().getConnectionSource(), Customer.class, customerId);
			if (customer != null) {
				contactPerson = customer.getContactPerson();
				customerName = customer.getCustomerName();
				telephone = customer.getTelephone();
			}
		}
	}

	@Override
	public Long getIdentity() {
		return brandCustomerID;
	}

	@Override
	public String getIdentityAttribute() {
		return BRAND_CUSTOMER_ID_FIELD_NAME;
	}

}
