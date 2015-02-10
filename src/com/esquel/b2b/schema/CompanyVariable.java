/** 
 * CompanyVariable.java
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
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName="company_variables")
public class CompanyVariable extends Model<CompanyVariable, String> implements Identity<String> {
	
	public static final String ID_FIELD_NAME = "company_variable_id";
	public static final String NAME_FIELD_NAME = "name";
	public static final String HAS_CATEGORY_FIELD_NAME = "has_category";
	public static final String DATA_TYPE_FIELD_NAME = "data_type";
	public static final String IS_MULTI_LINGO_FIELD_NAME = "is_multi_lingo";
	public static final String SEPARATOR_FIELD_NAME = "separator";
	public static final String TAG_PREFIX_FIELD_NAME = "tag_prefix";
	public static final String VARIABLE_HANDLING_ID_FIELD_NAME = "variable_handling_id";
	public static final String CATEGORIES_FIELD_NAME = "company_variable_category";
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

	@ForeignCollectionField(eager = false)
	@SerializedName(CATEGORIES_FIELD_NAME)
	@Expose
	private ForeignCollection<CompanyVariableCategory> categories;
	
	public ForeignCollection<CompanyVariableCategory> getCompanyVariableCategories() {
		return categories;
	}

	@DatabaseField(
			columnName = SEPARATOR_FIELD_NAME,
			canBeNull = true)
	@SerializedName(SEPARATOR_FIELD_NAME)
	@Expose
	private String separator;
	
	@DatabaseField(
			columnName = TAG_PREFIX_FIELD_NAME,
			canBeNull = false)
	@SerializedName(TAG_PREFIX_FIELD_NAME)
	@Expose
	private String tagPrefix;
	
	@DatabaseField(
			columnName = COMPANY_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(COMPANY_FIELD_NAME)
	@Expose
	private Company company;
	
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
			columnName = VARIABLE_HANDLING_ID_FIELD_NAME,
			canBeNull = false, 
			foreign = true, 
			useGetSet = true)
	@SerializedName(VARIABLE_HANDLING_ID_FIELD_NAME)
	@Expose
	private VariableHandling variable_handling;
	
	public VariableHandling getVariable_handling() {
		return variable_handling;
	}

	public void setVariable_handling(VariableHandling variable_handling) {
		this.variable_handling = variable_handling;
	}

	@DatabaseField(
			columnName = NAME_FIELD_NAME,
			canBeNull = false)
	@SerializedName(NAME_FIELD_NAME)
	@Expose
	private String name;
	
	@DatabaseField(
			columnName = HAS_CATEGORY_FIELD_NAME,
			canBeNull = false)
	@SerializedName(HAS_CATEGORY_FIELD_NAME)
	@Expose
	private boolean hasCategory;
		
	@DatabaseField(
			columnName = DATA_TYPE_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(DATA_TYPE_FIELD_NAME)
	@Expose
	private String dataType;
	
	@DatabaseField(
			columnName = IS_MULTI_LINGO_FIELD_NAME,
			canBeNull = false)
	@SerializedName(IS_MULTI_LINGO_FIELD_NAME)
	@Expose
	private boolean isMultLingo;
	
	CompanyVariable() {
		
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
