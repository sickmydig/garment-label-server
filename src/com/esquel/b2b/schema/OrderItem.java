/** 
 * OrderItem.java
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

import java.sql.SQLException;
import java.util.Date;

import org.restlet.Application;

import com.esquel.b2b.DatastoreApplication;
import com.esquel.b2b.DatastoreApplication.Store;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.Datastore;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "order_items")
public class OrderItem extends Model<OrderItem, String> implements Identity<String> {
	
	public static final String ORDER_ITEM_ID_FIELD_NAME = "order_item_id";	
	
	public static final String ORDER_FIELD_NAME = "order";
	public static final String IS_DYNAMIC_FIELD_NAME = "is_dynamic";
	public static final String LAYOUT_CONFIRMED_FIELD_NAME = "layout_confirmed";	
	public static final String REMARK_FIELD_NAME = "remark";	
	public static final String DESCRIPTION_FIELD_NAME = "description";
	public static final String QUANTITY_FIELD_NAME = "quantity";
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";	
	public static final String EAP_CODE_FIELD_NAME = "eap_code";
	public static final String ATTRIBUTE_SIZE_FIELD_NAME = "attribute_size";
	public static final String ATTRIBUTE_COLOR_FIELD_NAME = "attribute_color";
	public static final String ATTRIBUTE_COO_FIELD_NAME = "attribute_coo";
	public static final String ATTRIBUTE_CONTENTS_FIELD_NAME = "attribute_contents";
	public static final String ATTRIBUTE_STYLE_NUMBER_FIELD_NAME = "attribute_style_number";
	public static final String ATTRIBUTE_OTHERS_FIELD_NAME = "attribute_others";
	public static final String ATTRIBUTE_SIZE_NEW_FIELD_NAME = "attribute_size_new";
	public static final String ATTRIBUTE_COLOR_NEW_FIELD_NAME = "attribute_color_new";
	public static final String ATTRIBUTE_COO_NEW_FIELD_NAME = "attribute_coo_new";
	public static final String ATTRIBUTE_CONTENTS_NEW_FIELD_NAME = "attribute_contents_new";
	public static final String ATTRIBUTE_STYLE_NUMBER_NEW_FIELD_NAME = "attribute_style_number_new";
	public static final String ATTRIBUTE_OTHERS_NEW_FIELD_NAME = "attribute_others_new";
	public static final String BRAND_PRODUCT_NUMBER_FIELD_NAME = "brand_product_number";
	public static final String STANDARD_PRICE_FIELD_NAME = "standard_price";
	public static final String AMOUNT_FIELD_NAME = "amount";
	public static final String CUSTOMER_CODE_FIELD_NAME = "customer_code";
	public static final String PRODUCT_GROUP_FIELD_NAME = "product_group";
	public static final String CURRENCY_ID_FIELD_NAME = "currency_id";
	public static final String CURRENCY_FIELD_NAME = "currency";
	public static final String UNIT_ID_FIELD_NAME = "unit_id";
	public static final String UNIT_FIELD_NAME = "unit";
	
	public static final String ORDER_ITEM_ATTACHMENTS_FIELD_NAME = "order_item_attachments";
	public static final String ORDER_ITEM_SUB_PRODUCTS_FIELD_NAME = "order_item_sub_products";
	
	@DatabaseField(
			columnName = ORDER_ITEM_ID_FIELD_NAME, 
			canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(ORDER_ITEM_ID_FIELD_NAME)
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
			columnName = IS_DYNAMIC_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(IS_DYNAMIC_FIELD_NAME)
	@Expose
	private boolean isDynamic;
	
	
	@DatabaseField(
			columnName = LAYOUT_CONFIRMED_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(LAYOUT_CONFIRMED_FIELD_NAME)
	@Expose
	private boolean layoutConfirmed;
	
	
	@DatabaseField(
			columnName = "remarks", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
	
	@DatabaseField(
			columnName = DESCRIPTION_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(DESCRIPTION_FIELD_NAME)
	@Expose
	private String description;
	
		
	@DatabaseField(
			columnName = "qty", 
			canBeNull = true)
	@SerializedName(QUANTITY_FIELD_NAME)
	@Expose
	private Long quantity;
	
	
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
	
	
	@DatabaseField(columnName = EAP_CODE_FIELD_NAME)
	@SerializedName(EAP_CODE_FIELD_NAME)
	@Expose
	private String eapCode;
	
	
	@DatabaseField(
			columnName = "attr_size", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_SIZE_FIELD_NAME)
	@Expose
	private String attributeSize;
	
	
	@DatabaseField(
			columnName = "attr_color", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_COLOR_FIELD_NAME)
	@Expose
	private String attributeColor;
	
	
	@DatabaseField(
			columnName = "attr_coo", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_COO_FIELD_NAME)
	@Expose
	private String attributeCoo;
	
	
	@DatabaseField(
			columnName = "attr_contents", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_CONTENTS_FIELD_NAME)
	@Expose
	private String attributeContents;
	
	
	@DatabaseField(
			columnName = "attr_style_number", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_STYLE_NUMBER_FIELD_NAME)
	@Expose
	private String attributeStyleNumber;
	
	
	@DatabaseField(
			columnName = "attr_others", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_OTHERS_FIELD_NAME)
	@Expose
	private String attributeOthers;
	
	
	@DatabaseField(
			columnName = "attr_size_new", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_SIZE_NEW_FIELD_NAME)
	@Expose
	private boolean attributeSizeNew;
	
	
	@DatabaseField(
			columnName = "attr_color_new", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_COLOR_NEW_FIELD_NAME)
	@Expose
	private boolean attributeColorNew;
	
	
	@DatabaseField(
			columnName = "attr_coo_new", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_COO_NEW_FIELD_NAME)
	@Expose
	private boolean attributeCooNew;
	
	
	@DatabaseField(
			columnName = "attr_contents_new", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_CONTENTS_NEW_FIELD_NAME)
	@Expose
	private boolean attributeContentsNew;
	
	
	@DatabaseField(
			columnName = "attr_style_number_new", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_STYLE_NUMBER_NEW_FIELD_NAME)
	@Expose
	private boolean attributeStyleNumberNew;
	
	
	@DatabaseField(
			columnName = "attr_others_new", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_OTHERS_NEW_FIELD_NAME)
	@Expose
	private boolean attributeOthersNew;
	
	
	@DatabaseField(
			columnName = "brand_product_no", 
			canBeNull = true)
	@SerializedName(BRAND_PRODUCT_NUMBER_FIELD_NAME)
	@Expose
	private String brandProductNumber;
	
	
	@DatabaseField(
			columnName = STANDARD_PRICE_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(STANDARD_PRICE_FIELD_NAME)
	@Expose
	private Double standardPrice;
	
	
	@DatabaseField(
			columnName = AMOUNT_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(AMOUNT_FIELD_NAME)
	@Expose
	private Double amount;
	
	
	@DatabaseField(
			columnName = CUSTOMER_CODE_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(CUSTOMER_CODE_FIELD_NAME)
	@Expose
	private String customerCode;
	
	
	@DatabaseField(
			columnName = PRODUCT_GROUP_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(PRODUCT_GROUP_FIELD_NAME)
	@Expose
	private String productGroup;
	
	
	@DatabaseField(
			columnName = CURRENCY_ID_FIELD_NAME, 
			canBeNull = true,
			useGetSet = true)
	@SerializedName(CURRENCY_ID_FIELD_NAME)
	@Expose(serialize = false)
	private Long currencyID;
	
	
	@SerializedName(CURRENCY_FIELD_NAME)
	@Expose(deserialize = false)
	private Currency currency;
	
	
	@DatabaseField(
			columnName = UNIT_ID_FIELD_NAME, 
			canBeNull = true,
			useGetSet = true)
	@SerializedName(UNIT_ID_FIELD_NAME)
	@Expose(serialize = false)
	private Long unitID;
	
	
	@SerializedName(UNIT_FIELD_NAME)
	@Expose(deserialize = false)
	private UnitDetail unit;
	
	
	@ForeignCollectionField(eager = false)
	@SerializedName(ORDER_ITEM_ATTACHMENTS_FIELD_NAME)
	@Expose
	private ForeignCollection<OrderItemAttachment> orderItemAttachments;
	
	
	@ForeignCollectionField(eager = false)
	@SerializedName(ORDER_ITEM_SUB_PRODUCTS_FIELD_NAME)
	@Expose
	private ForeignCollection<OrderItemSubProduct> orderItemSubProducts;
	
	
	public OrderItem() {
		
	}
	
	
	/**
	 * Specifies the new identifier of the item
	 * 
	 * @param id the new identifier of the item
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	
	@Override
	public String getIdentity() {
		return id;
	}
	

	@Override
	public String getIdentityAttribute() {
		return ORDER_ITEM_ID_FIELD_NAME;
	}
	

	/**
	 * Returns the {@link Order} this item is for
	 * 
	 * @return the {@link Order} this item is for
	 */
	public Order getOrder() {
		return order;
	}
	
	
	/**
	 * Specifies the new {@link Order} this item is associated with
	 * 
	 * @param order the new {@link Order} this item is associated with
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	public Long getCurrencyID() {
		return currencyID;
	}

	
	public void setCurrencyID(Long currencyID) throws SQLException {
		this.currencyID = currencyID;
		
		if (currencyID != null && Application.getCurrent() instanceof DatastoreApplication) {
			Datastore store = ((DatastoreApplication) Application.getCurrent()).getDatastore(Store.EAP);
			currency = Model.find(store.getConnectionSource(), Currency.class, currencyID);
		}
	}
	
	
	public Long getUnitID() {
		return unitID;
	}

	
	public void setUnitID(Long unitID) throws SQLException {
		this.unitID = unitID;
		
		if (unitID != null && Application.getCurrent() instanceof DatastoreApplication) {
			Datastore store = ((DatastoreApplication) Application.getCurrent()).getDatastore(Store.EAP);
			unit = Model.find(store.getConnectionSource(), UnitDetail.class, unitID);
		}
	}
	
	
	public ForeignCollection<OrderItemAttachment> getOrderItemAttachments() {
		return orderItemAttachments;
	}
	
	
	public ForeignCollection<OrderItemSubProduct> getOrderItemSubProducts() {
		return orderItemSubProducts;
	}
}

