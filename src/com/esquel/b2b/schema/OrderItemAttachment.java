/** 
 * ProductAttachment.java
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

@DatabaseTable(tableName = "order_item_attachments")
public class OrderItemAttachment extends Model<OrderItemAttachment, String> implements Identity<String> {
	
	public static final String ORDER_ITEM_ATTACHMENT_ID_FIELD_NAME = "order_item_attachment_id";
	
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";
	public static final String ATTACHMENT_URL_FIELD_NAME = "attachment_url";
	public static final String ORDER_ITEM_FIELD_NAME = "order_item";
	public static final String FILE_SIZE_FIELD_NAME = "file_size";
	
	@DatabaseField(
			columnName = ORDER_ITEM_ATTACHMENT_ID_FIELD_NAME, 
			canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(ORDER_ITEM_ATTACHMENT_ID_FIELD_NAME)
	@Expose
	private String id;

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
			columnName = MODIFIED_BY_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(MODIFIED_BY_FIELD_NAME)
	@Expose
	private String modifiedBy;

	@DatabaseField(
			columnName = CREATED_BY_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(CREATED_BY_FIELD_NAME)
	@Expose
	private String createdBy;
	
	@DatabaseField(
			columnName = ATTACHMENT_URL_FIELD_NAME, 
			canBeNull = true)
	@BlobDatabaseField(baseURI = "order_item_attachments")
	@SerializedName(ATTACHMENT_URL_FIELD_NAME)
	@Expose
	private String attachmentURL;
	
	@DatabaseField(
			columnName = ORDER_ITEM_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(ORDER_ITEM_FIELD_NAME)
	@Expose
	private OrderItem orderItem;
	
	@DatabaseField(
			columnName = FILE_SIZE_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(FILE_SIZE_FIELD_NAME)
	@Expose
	private Long fileSize;
	
	public OrderItemAttachment() {
		
	}
	
	@Override
	public String getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return ORDER_ITEM_ATTACHMENT_ID_FIELD_NAME;
	}
	
	public OrderItem getOrderItem() {
		return orderItem;
	}
}
