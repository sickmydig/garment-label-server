/** 
 * ProductTemplates.java
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

@DatabaseTable(tableName = "product_templates")
public class ProductTemplate extends Model<ProductTemplate, String> implements Identity<String> {
	
	public static final String ID_FIELD_NAME = "template_id";
	
	public static final String PRODUCT_FIELD_NAME = "product";
	public static final String NUMBER_OF_FIBER_FIELD_NAME = "no_of_fiber";
	public static final String TEMPLATE_FILE_URL_FIELD_NAME = "template_file_url";
	public static final String IS_DEFAULT_FIELD_NAME = "is_default";	
	public static final String FILENAME_FIELD_NAME = "filename";
	public static final String CREATED_BY_FIELD_NAME = "created_by";	
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";


	
	@DatabaseField(
			columnName = ID_FIELD_NAME, 
			canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private String id;
	
	@DatabaseField(
			columnName = PRODUCT_FIELD_NAME + "_id", 
			canBeNull = true,
			foreign = true)
	@SerializedName(PRODUCT_FIELD_NAME)
	@Expose
	private Product product;
	
	@DatabaseField(
			columnName = NUMBER_OF_FIBER_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(NUMBER_OF_FIBER_FIELD_NAME)
	@Expose
	private Long numberOfFiber;
	
	@DatabaseField(
			columnName = CREATED_DATE_FIELD_NAME, 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATED_DATE_FIELD_NAME)
	@Expose
	private Date createdDate;

	@DatabaseField(
			columnName = LAST_MODIFIED_DATE_FIELD_NAME, 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFIED_DATE_FIELD_NAME)
	@Expose
	private Date lastModifiedDate;
	
	@DatabaseField(
			columnName = TEMPLATE_FILE_URL_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(TEMPLATE_FILE_URL_FIELD_NAME)
	@Expose
	private String templateFileURL;
	
	@DatabaseField(
			columnName = IS_DEFAULT_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(IS_DEFAULT_FIELD_NAME)
	@Expose
	private boolean isDefault;
	
	@DatabaseField(
			columnName = FILENAME_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(FILENAME_FIELD_NAME)
	@Expose
	private String filename;
	
	@DatabaseField(
			columnName = CREATED_BY_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(CREATED_BY_FIELD_NAME)
	@Expose
	private String createdBy;
	
	@DatabaseField(
			columnName = MODIFIED_BY_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(MODIFIED_BY_FIELD_NAME)
	@Expose
	private String modifiedBy;
	
	

	
	public ProductTemplate() {
		
	}
	
	@Override
	public String getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
	
	public Product getProduct() {
		return product;
	}
}