/** 
 * OrderNumber.java
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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

/**
 * Represents an unique order number in B2B system
 */
@DatabaseTable(tableName = "order_numbers")
public class OrderNumber extends Model<OrderNumber, Long> implements Identity<Long> {
	
	// Constants for formatting an order number
	public static final String PREFIX = "BN";
	public static final int LENGTH = 8;
	
	// For query
	public static final String ID_FIELD_NAME = "order_number_id";
	public static final String ORDER_FIELD_NAME = "order";
	
	@DatabaseField(columnName = ID_FIELD_NAME, canBeNull = false, generatedId = true)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long id;
	
	@DatabaseField(
			columnName = ORDER_FIELD_NAME + "_id",
			canBeNull = false,
			foreign = true)
	@SerializedName(ORDER_FIELD_NAME)
	@Expose
	private Order order;
	
	OrderNumber() {
		// Persisted classes must have an no-arg constructor
	}
	
	/**
	 * Creates a new instance of {@link OrderNumber} for a given {@code order}
	 * 
	 * @param order the order to create an order number
	 */
	public OrderNumber(Order order) {
		this.order = order;
	}

	@Override
	public Long getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
	
	/**
	 * Specifies the order number of this order
	 * 
	 * @param orderNumber the order number of this order
	 */
	public String getFormattedOrderNumber() {
		if (id != null) {
			String format = OrderNumber.PREFIX + "%0" + OrderNumber.LENGTH + "d";
			return String.format(format, id); 
		}
		return null;
	}

}
