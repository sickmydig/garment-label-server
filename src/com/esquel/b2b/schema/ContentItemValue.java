/** 
 * MasterContentDetails.java
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

@DatabaseTable(tableName = "content_item_values")
public class ContentItemValue extends Model<ContentItemValue, String> implements Identity<String> {
	
	public static final String ID_FIELD_NAME = "content_item_value_id";
	public static final String SEG_NO_FIELD_NAME = "seq_no";
	public static final String TEXT_VALUE_FIELD_NAME = "text_value";
	public static final String VALUE_URL_FIELD_NAME = "value_url";
	public static final String IS_DEFAULT_FIELD_NAME = "is_default";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	
	public static final String LANGUAGES_FIELD_NAME = "company_language";
	public static final String CATEGORY_FIELD_NAME = "company_variable_category";
	public static final String CONTENT_ITEMS_CONTENT_FIELD_NAME = "content_item";
	
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
			columnName = LANGUAGES_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(LANGUAGES_FIELD_NAME)
	@Expose
	private CompanyLanguage companyLanguage;

	@DatabaseField(
			columnName = CATEGORY_FIELD_NAME + "_id", 
			canBeNull = true,
			foreign = true)
	@SerializedName(CATEGORY_FIELD_NAME)
	@Expose
	private CompanyVariableCategory category;
	
	@DatabaseField(
			columnName = CONTENT_ITEMS_CONTENT_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(CONTENT_ITEMS_CONTENT_FIELD_NAME)
	@Expose
	private ContentItem contentItem;
	
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
	
	@DatabaseField(
			columnName = MODIFIED_BY_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(MODIFIED_BY_FIELD_NAME)
	@Expose
	private String modifiedBy;

	@DatabaseField(
			columnName = CREATED_BY_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(CREATED_BY_FIELD_NAME)
	@Expose
	private String createdBy;
	
	@DatabaseField(
			columnName = SEG_NO_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(SEG_NO_FIELD_NAME)
	@Expose
	private Integer seqNo;
	
	@DatabaseField(
			columnName = TEXT_VALUE_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(TEXT_VALUE_FIELD_NAME)
	@Expose
	private String textValue;
	
	@DatabaseField(
			columnName = VALUE_URL_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(VALUE_URL_FIELD_NAME)
	@Expose
	private String url;
	
	@DatabaseField(
			columnName = IS_DEFAULT_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(IS_DEFAULT_FIELD_NAME)
	@Expose
	private boolean isDefault;
	
	ContentItemValue() {
		
	}
	
	@Override
	public String getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
}
