/** 
 * ProductTag.java
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

@DatabaseTable(tableName = "product_tags")
public class ProductTag extends Model<ProductTag, String> implements Identity<String> {
	
	public static final String ID_FIELD_NAME = "tag_id";
	
	public static final String PRODUCT_FIELD_NAME = "product";
	public static final String COMPANY_VARIABLE_FIELD_NAME = "company_variable";
	public static final String SEQUENCE_NUMBER_FIELD_NAME = "seq_no";
	public static final String TAG_NAME_FIELD_NAME = "tag_name";
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";
	public static final String TAG_VALUE_FIELD_NAME = "tag_value";
	public static final String GROUP_ID_FIELD_NAME = "group_id";
	
	public static final String PRODUCT_TAG_CONTENT_VALUES_FIELD_NAME = "product_tag_content_values";
	
	
	
	
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
			canBeNull = false,
			foreign = true)
	@SerializedName(PRODUCT_FIELD_NAME)
	@Expose
	private Product product;
	
	@DatabaseField(
			columnName = COMPANY_VARIABLE_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(COMPANY_VARIABLE_FIELD_NAME)
	@Expose
	private CompanyVariable companyVariable;
	
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
			columnName = SEQUENCE_NUMBER_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(SEQUENCE_NUMBER_FIELD_NAME)
	@Expose
	private Long seqNO;
	
	@DatabaseField(
			columnName = TAG_NAME_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(TAG_NAME_FIELD_NAME)
	@Expose
	private String tagName;
	
	@DatabaseField(
			columnName = TAG_VALUE_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(TAG_VALUE_FIELD_NAME)
	@Expose
	private String tagValue;
	
	@DatabaseField(
			columnName = CREATED_BY_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(CREATED_BY_FIELD_NAME)
	@Expose
	private String createdBy;
	
	@DatabaseField(
			columnName = MODIFIED_BY_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(MODIFIED_BY_FIELD_NAME)
	@Expose
	private String modifiedBy;
	
	@DatabaseField(
			columnName = GROUP_ID_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(GROUP_ID_FIELD_NAME)
	@Expose
	private Long groupID;

	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_TAG_CONTENT_VALUES_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductTagContentValue> productTagContentValues;
	
	
	
	
	public ProductTag() {
		
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
	
	public CompanyVariable getCompanyVariable() {
		return companyVariable;
	}
}
