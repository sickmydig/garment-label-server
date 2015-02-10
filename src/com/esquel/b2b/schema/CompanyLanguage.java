/** 
 * CompanyLanguages.java
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

@DatabaseTable(tableName = "company_languages")
public class CompanyLanguage extends Model<CompanyLanguage, String> implements Identity<String> {
	
	public static final String ID_FIELD_NAME = "company_language_id";
	public static final String LANGUAGE_CODE_FIELD_NAME = "language_code";
	public static final String DISPLAY_NAME_FIELD_NAME = "display_name";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	
	public static final String COMPANY_FIELD_NAME = "company";
		
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
			columnName = COMPANY_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(COMPANY_FIELD_NAME)
	@Expose
	private Company company;
	
	@DatabaseField(
			columnName = LANGUAGE_CODE_FIELD_NAME,
			canBeNull = false)
	@SerializedName(LANGUAGE_CODE_FIELD_NAME)
	@Expose
	private String languageCode;
	
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
			columnName = DISPLAY_NAME_FIELD_NAME,
			canBeNull = false)
	@SerializedName(DISPLAY_NAME_FIELD_NAME)
	@Expose
	private String displayName;
	
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
	
	CompanyLanguage() {
		
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

