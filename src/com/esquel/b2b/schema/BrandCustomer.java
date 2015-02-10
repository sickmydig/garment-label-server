/** 
 * BrandCustomer.java
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

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

/**
 * A data model that defines the relationships between a brand and its customers
 */
@DatabaseTable(tableName = "dtBrandCustomer")
public class BrandCustomer extends Model<BrandCustomer, Long> implements Identity<Long> {
	
	public static final String BRAND_CUSTOMER_ID_FIELD_NAME = "brand_customer_id";
	
	public static final String ID_FIELD_NAME = "iden";
	public static final String SUB_BRAND_FIELD_NAME = "sub_brand";
	public static final String CUSTOMER_FIELD_NAME = "customer";
	public static final String IS_PILOT_FIELD_NAME = "is_pilot";
	public static final String IS_VALID_FIELD_NAME = "is_valid";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
    
	
	
    
    @DatabaseField(
			columnName = "BrandCustomerID", 
			canBeNull = false,
			id = true)
	@SerializedName(BRAND_CUSTOMER_ID_FIELD_NAME)
	@Expose
	private Long brandCustomerID;
    
	@DatabaseField(
			columnName = "iden", 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "BrandID", 
			canBeNull = false, 
			foreign = true)
	@SerializedName(SUB_BRAND_FIELD_NAME)
	@Expose
	private SubBrand subBrand;
	
	@DatabaseField(columnName = "CustomerID",
		    canBeNull = false,
		      foreign = true)
	@SerializedName(CUSTOMER_FIELD_NAME)
	@Expose
	private Customer customer;
	
	@DatabaseField(
			columnName = "isPilot", 
			canBeNull = true)
	@SerializedName(IS_PILOT_FIELD_NAME)
	@Expose
	private boolean isPilot;
	
	@DatabaseField(
			columnName = "isValid", 
			canBeNull = true)
	@SerializedName(IS_VALID_FIELD_NAME)
	@Expose
	private boolean isValid;
	
	@DatabaseField(
			columnName = "Remark", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;

	@DatabaseField(
			columnName = "CreateBy", 
			canBeNull = true)
	@SerializedName(CREATE_BY_FIELD_NAME)
	@Expose
	private String createBy;
	
	@DatabaseField(
			columnName = "CreateTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATE_TIME_FIELD_NAME)
	@Expose
	private Date createTime;
	
	@DatabaseField(
			columnName = "LastModifyBy", 
			canBeNull = true)
	@SerializedName(LAST_MODIFY_BY_FIELD_NAME)
	@Expose
	private String lastModifyBy;
	
	@DatabaseField(
			columnName = "LastModifyTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFY_TIME_FIELD_NAME)
	@Expose
	private Date lastModifyTime;


	/**
	 * Creates a new instance of {@code BrandCustomer}
	 */
	public BrandCustomer() {
	}
	
	@Override
	public Long getIdentity() {
		return brandCustomerID;
	}

	@Override
	public String getIdentityAttribute() {
		return BRAND_CUSTOMER_ID_FIELD_NAME;
	}
	
	/**
	 * Returns the {@link Customer} in this brand/customer relationship
	 * 
	 * @return the {@link Customer} in this brand/customer relationship
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Returns the {@link SubBrand} in this brand/customer relationship
	 * 
	 * @return the {@link SubBrand} in this brand/customer relationship
	 */
	public SubBrand getBrand() {
		return subBrand;
	}
	
}
