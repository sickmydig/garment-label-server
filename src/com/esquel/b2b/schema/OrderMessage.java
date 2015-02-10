/** 
 * OrderCommunications.java
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

@DatabaseTable(tableName = "order_messages")
public class OrderMessage extends Model<OrderMessage, String> implements Identity<String> {
	
	public static final String MESSAGE_ID_FIELD_NAME = "message_id";
	
	public static final String ORDER_FIELD_NAME = "order";
	public static final String SEQUENCE_NUMBER_FIELD_NAME = "sequence_number";
	public static final String TEXT_FIELD_NAME = "text_value";
	public static final String VALUE_URL_FIELD_NAME = "value_url";
	public static final String READ_FIELD_NAME = "read";
	public static final String MESSAGE_TYPE_FIELD_NAME = "message_type";
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";
	
	@DatabaseField(
			columnName = "msg_id", 
			canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(MESSAGE_ID_FIELD_NAME)
	@Expose
	private String id;

	@DatabaseField(
			columnName = ORDER_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(ORDER_FIELD_NAME)
	@Expose
	private Order order;
	
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
			columnName = "seq_no", 
			canBeNull = false)
	@SerializedName(SEQUENCE_NUMBER_FIELD_NAME)
	@Expose
	private Long sequenceNumber;
	
	@DatabaseField(
			columnName = TEXT_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(TEXT_FIELD_NAME)
	@Expose
	private String textValue;
	
	@DatabaseField(
			columnName = VALUE_URL_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(VALUE_URL_FIELD_NAME)
	@Expose
	private String valueURL;
	
	@DatabaseField(
			columnName = READ_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(READ_FIELD_NAME)
	@Expose
	private boolean read;
	
	@DatabaseField(
			columnName = MESSAGE_TYPE_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(MESSAGE_TYPE_FIELD_NAME)
	@Expose
	private MessageType messageType;
	
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

	public OrderMessage() {
		
	}
	
	@Override
	public String getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return MESSAGE_ID_FIELD_NAME;
	}

	public MessageType getMessageType() {
		return messageType;
	}
}