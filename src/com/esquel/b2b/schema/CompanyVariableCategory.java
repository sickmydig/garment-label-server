/** 
 * CompanyVariableCategories.java
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

@DatabaseTable(tableName = "company_variable_categories")
public class CompanyVariableCategory extends Model<CompanyVariableCategory, String> implements Identity<String> {

	public static final String ID_FIELD_NAME = "company_variable_category_id";
	public static final String SEQUENCE_NO_FIELD_NAME = "seq_no";
	public static final String NAME_FIELD_NAME = "name";
	
//	public static final String MASTER_CONTENT_DETAILS_FIELD_NAME = "master_content_details";
//	public static final String SUB_PRODUCT_VALUES_FIELD_NAME = "sub_product_values";
	public static final String COMPANY_VARIABLE_FIELD_NAME = "company_variable";
	
	@DatabaseField(
			columnName = ID_FIELD_NAME, 
			canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private String id;
	
//	@ForeignCollectionField(eager = false)
//	@SerializedName(SUB_PRODUCT_VALUES_FIELD_NAME)
//	@Expose
//	private ForeignCollection<SubProductValue> values;
//	
//	public ForeignCollection<SubProductValue> getSubProductValues() {
//		return values;
//	}
//
//	@ForeignCollectionField(eager = false)
//	@SerializedName(MASTER_CONTENT_DETAILS_FIELD_NAME)
//	@Expose
//	private ForeignCollection<DCContentItemValue> masters;
//	
//	public ForeignCollection<DCContentItemValue> getMasterContentDetails() {
//		return masters;
//	}
//	
	@DatabaseField(
			columnName = COMPANY_VARIABLE_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(COMPANY_VARIABLE_FIELD_NAME)
	@Expose
	private CompanyVariable companyVariable;

	@DatabaseField(
			columnName = "seq_no", 
			canBeNull = false)
	@SerializedName(SEQUENCE_NO_FIELD_NAME)
	@Expose
	private Integer seqNo;

	@DatabaseField(
			columnName = NAME_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(NAME_FIELD_NAME)
	@Expose
	private String name;

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

	@Override
	public String getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}

	CompanyVariableCategory() {
	
	}

	public int getSeqNumber() {
		return seqNo;
	}

	public CompanyVariable getCompanyVariableID() {
		return companyVariable;
	}

	public String getName() {
		return name;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
}
