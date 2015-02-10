/** 
 * CustomerProduct.java
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

@DatabaseTable(tableName = "UVW_B2BCustomerProduct")
public class CustomerProduct extends Model<CustomerProduct, Long> implements Identity<Long> {
	
	public static final String CUSTOMER_FIELD_NAME = "customer";
	public static final String CUSTOMER_NAME_FIELD_NAME = "customer_name";
	public static final String MATERIAL_HDR_ID_FIELD_NAME = "material_header_id";
	public static final String PRODUCT_NO_FIELD_NAME = "product_number";
	public static final String SUB_BRAND_FIELD_NAME = "sub_brand";
	public static final String CUSTOMER_PRODUCT_NUMBER_FIELD_NAME = "customer_product_number";
	public static final String BRAND_NAME_FIELD_NAME = "brand_name";
	
	@DatabaseField(
			columnName = "CustomerID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(CUSTOMER_FIELD_NAME)
	@Expose
	private Customer customer;
	
	@DatabaseField(
			columnName = "CustomerName", 
			canBeNull = true)
	@SerializedName(CUSTOMER_NAME_FIELD_NAME)
	@Expose
	private String customerName;
	
	@DatabaseField(
			columnName = "MaterialHdrID", 
			canBeNull = false,
			id = true)
	@SerializedName(MATERIAL_HDR_ID_FIELD_NAME)
	@Expose
	private Long materialHdrID;
	
	@DatabaseField(
			columnName = "ProductNO", 
			canBeNull = false)
	@SerializedName(PRODUCT_NO_FIELD_NAME)
	@Expose
	private String productNo;
	
	@DatabaseField(
			columnName = "SubBrandID", 
			canBeNull = true,
			foreign = true)
	@SerializedName(SUB_BRAND_FIELD_NAME)
	@Expose
	private SubBrand subBrand;
	
	@DatabaseField(
			columnName = "CustormerProductNo", 
			canBeNull = true)
	@SerializedName(CUSTOMER_PRODUCT_NUMBER_FIELD_NAME)
	@Expose
	private String customerProductNumber;
	
	@DatabaseField(
			columnName = "BrandName", 
			canBeNull = true)
	@SerializedName(BRAND_NAME_FIELD_NAME)
	@Expose
	private String brandName;
	
	public CustomerProduct() {
		
	}
	
	@Override
	public Long getIdentity() {
		return materialHdrID;
	}

	@Override
	public String getIdentityAttribute() {
		return MATERIAL_HDR_ID_FIELD_NAME;
	}
}
