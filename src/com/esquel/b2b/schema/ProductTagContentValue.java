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
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "product_tag_content_values")
public class ProductTagContentValue extends Model<ProductTagContentValue, String> implements Identity<String> {
	
	public static final String ID_FIELD_NAME = "tag_reference_id";
	
	public static final String PRODUCT_TAG_FIELD_NAME = "product_tag";
	public static final String CONTENT_ITEM_VALUE_FIELD_NAME = "content_item_value";
	
	
	
	
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
			columnName = PRODUCT_TAG_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(PRODUCT_TAG_FIELD_NAME)
	@Expose
	private ProductTag productTag;
	
	@DatabaseField(
			columnName = CONTENT_ITEM_VALUE_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(CONTENT_ITEM_VALUE_FIELD_NAME)
	@Expose
	private ContentItemValue contentItemValue;
	
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
	
	
	
	
	public ProductTagContentValue() {
		
	}
	
	@Override
	public String getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
	
	public ProductTag getProductTag() {
		return productTag;
	}
	
	public ContentItemValue getContentItemValue() {
		return contentItemValue;
	}
}
