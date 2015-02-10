/** 
 * ProductImage.java
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
import com.joyaether.datastore.schema.BlobDatabaseField;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

/**
 * Contains images of products in the system
 */
@DatabaseTable(tableName = "product_images")
public class ProductImage extends Model<ProductImage, String> implements Identity<String> {
	
	// For query
	public static final String ID_FIELD_NAME = "product_image_id";
	public static final String IMAGE_URL_FIELD_NAME = "image_url";
	public static final String PRODUCT_NUMBER_FIELD_NAME = "product_number";
	public static final String SUB_CODE_FIELD_NAME = "sub_code";
	public static final String EAPMIS_LAST_MODIFIED_DATE = "eapmis_lastmoddate";
	
	@DatabaseField(
			columnName = ID_FIELD_NAME,
			canBeNull = false, 
			generatedId = true,
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private String id;
	
	@DatabaseField(
			columnName = "eap_code", 
			canBeNull = false)
	@SerializedName(PRODUCT_NUMBER_FIELD_NAME)
	@Expose
	private String productNumber;
	
	@DatabaseField(
			columnName = SUB_CODE_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(SUB_CODE_FIELD_NAME)
	@Expose
	private String subCode;
	
	@DatabaseField(
			columnName = IMAGE_URL_FIELD_NAME, 
			canBeNull = true)
	@BlobDatabaseField(baseURI = "products")
	@SerializedName(IMAGE_URL_FIELD_NAME)
	@Expose
	private String url;
	
	@DatabaseField(
			columnName = CREATED_DATE_FIELD_NAME, 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATED_DATE_FIELD_NAME)
	@Expose
	private Date createdDate;

	@DatabaseField(
			columnName = LAST_MODIFIED_DATE_FIELD_NAME, 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFIED_DATE_FIELD_NAME)
	@Expose
	private Date lastModifiedDate;
	
	@DatabaseField(columnName = EAPMIS_LAST_MODIFIED_DATE)
	@SerializedName(EAPMIS_LAST_MODIFIED_DATE)
	private Date eapLastModifiedDate;
	
	ProductImage() {
		// All persist classes must have an no-arg constructor
	}
	
	/**
	 * Creates a new instance of {@link ProductImage} with the given product number and sub code
	 * 
	 * @param productNumber the EAP code of the product
	 * @param subCode the EAP sub code of the product
	 */
	public ProductImage(String productNumber, String subCode) {
		setProductNumber(productNumber);
		setSubCode(subCode);
	}

	@Override
	public String getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
	
	/**
	 * Returns the {@link Date} this product image was last modified
	 * 
	 * @return the {@link Date} this product image was last modified
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	
	/**
	 * Specifies a new URL to the remote resource that references the product image
	 * 
	 * @param url the new URL to the remote resource that references the product image
	 */
	public void setImageUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Returns the EAP code of the product this image refers to
	 * 
	 * @return the EAP code of the product this image refers to
	 */
	public String getProductNumber() {
		return productNumber;
	}
	
	/**
	 * Specifies a new EAP code of the product this image refers to
	 * 
	 * @param productNumber the EAP code of the product this image refers to
	 */
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	/**
	 * Returns the sub-code of the product this image refers to
	 *  
	 * @return the sub-code of the product this image refers to
	 */
	public String getSubCode() {
		return subCode;
	}
	
	/**
	 * Specifies a new sub-code of the product this image refers to
	 * 
	 * @param subCode the sub-code of the product this image refers to
	 */
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	
	/**
	 * Returns the date this company was last modified in EAP
	 * 
	 * @return the date this company was last modified in EAP
	 */
	public Date getEapLastModifiedDate() {
		return eapLastModifiedDate;
	}
	
	/**
	 * Specifies the date the company was last modified in EAP 
	 * 
	 * @param newDate the new date the company was last modified in EAP
	 */
	public void setEapLastModifiedDate(Date newDate) {
		eapLastModifiedDate = newDate;
	}

}
