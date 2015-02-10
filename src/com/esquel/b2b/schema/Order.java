/** 
 * Order.java
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

@DatabaseTable(tableName = "orders")
public class Order extends Model<Order, String> implements Identity<String> {
	
	public static final String ORDER_ID_FIELD_NAME = "order_id";
	
	public static final String VENDER_COMPANY_FIELD_NAME = "vendor_company";
	public static final String BRAND_COMPANY_FIELD_NAME = "brand_company";
	public static final String STATUS_FIELD_NAME = "status";
	public static final String PO_NUMBER_FIELD_NAME = "po_number";
	public static final String EXPECTED_DELIVERY_FIELD_NAME = "expected_delivery";
	public static final String CURRENCY_FIELD_NAME = "currency";
	public static final String CURRENCY_ID_FIELD_NAME = "currency_id";
	public static final String SOLD_TO_CUSTOMER_FIELD_NAME = "sold_to_customer";
	public static final String SOLD_TO_CUSTOMER_ID_FIELD_NAME = "sold_to_customer_id";
	public static final String PAYMENT_TERM_ID_FIELD_NAME = "payment_term_id";
	public static final String SEASON_ID_FIELD_NAME = "season_id";
	public static final String REQUEST_PI_FIELD_NAME = "request_pi";
	public static final String GARMENT_STYLE_FIELD_NAME = "garment_style";
	public static final String REQUEST_EMAIL_FIELD_NAME = "request_email";
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";
	public static final String EAPMIS_ORDER_FIELD_NAME = "eapmis_order_id";
	public static final String SOLD_TO_TELEPHONE_FIELD_NAME = "sold_to_telephone";
	public static final String SOLD_TO_ATTENTION_FIELD_NAME = "sold_to_attention";
	public static final String CONSIGNED_TO_CUSTOMER_NAME_FIELD_NAME = "consigned_to_customer_name";
	public static final String CONSIGNED_TO_ADDRESS_FIELD_NAME = "consigned_to_address";
	public static final String CONSIGNED_TO_TELEPHONE_FIELD_NAME = "consigned_to_telephone";
	public static final String CONSIGNED_TO_ATTENTION_FIELD_NAME = "consigned_to_attention";
	public static final String ORDER_ACCEPTANCE_DATE_FIELD_NAME = "order_acceptance_date";
	public static final String DELIVERY_DATE_FIELD_NAME = "delivery_date";
	public static final String READ_FIELD_NAME = "read";
	public static final String SEND_TO_EAPMIS_FIELD_NAME = "send_to_eapmis";
	public static final String B2B_ORDER_NUMBER_FIELD_NAME = "b2b_order_number";
	public static final String B2B_ORDER_NUMBERS_FIELD_NAME = "b2b_order_numbers";
	
	public static final String ORDER_ITEMS_FIELD_NAME = "order_items";
	public static final String ORDER_MESSAGES_FIELD_NAME = "order_messages";
	
	@DatabaseField(
			columnName = ORDER_ID_FIELD_NAME, 
			canBeNull = false, 
			generatedId = true,
			allowGeneratedIdInsert = true, 			
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class,
			useGetSet = true)
	@SerializedName(ORDER_ID_FIELD_NAME)
	@Expose
	private String id;
	
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
			columnName = VENDER_COMPANY_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(VENDER_COMPANY_FIELD_NAME)
	@Expose
	private Company vendorCompany;
	
	@DatabaseField(
			columnName = BRAND_COMPANY_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(BRAND_COMPANY_FIELD_NAME)
	@Expose
	private Company brandCompany;
	
	@DatabaseField(
			columnName = STATUS_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(STATUS_FIELD_NAME)
	@Expose
	private Long status;
	
	@DatabaseField(
			columnName = PO_NUMBER_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(PO_NUMBER_FIELD_NAME)
	@Expose
	private String poNumber;
	
	@DatabaseField(
			columnName = EXPECTED_DELIVERY_FIELD_NAME, 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(EXPECTED_DELIVERY_FIELD_NAME)
	@Expose
	private Date expectedDelivery;
	
	@DatabaseField(
			columnName = CURRENCY_FIELD_NAME, 
			canBeNull = true,
			useGetSet = true)
	@SerializedName(CURRENCY_ID_FIELD_NAME)
	@Expose(serialize = false)
	private Long currencyID;
	
	@SerializedName(CURRENCY_FIELD_NAME)
	@Expose(deserialize = false)
	private Currency currency;
	
	@DatabaseField(
			columnName = SOLD_TO_CUSTOMER_ID_FIELD_NAME, 
			canBeNull = true,
			useGetSet = true)
	@SerializedName(SOLD_TO_CUSTOMER_ID_FIELD_NAME)
	@Expose(serialize = false)
	private Long soldToCustomerID;
	
	@SerializedName(SOLD_TO_CUSTOMER_FIELD_NAME)
	@Expose(deserialize = false)
	private Customer soldToCustomer;
	
	@DatabaseField(
			columnName = PAYMENT_TERM_ID_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(PAYMENT_TERM_ID_FIELD_NAME)
	@Expose
	private Long paymentTermID;
	
	@DatabaseField(
			columnName = SEASON_ID_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(SEASON_ID_FIELD_NAME)
	@Expose
	private Long seasonID;
	
	@DatabaseField(
			columnName = REQUEST_PI_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(REQUEST_PI_FIELD_NAME)
	@Expose
	private boolean requestPI;
	
	@DatabaseField(
			columnName = GARMENT_STYLE_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(GARMENT_STYLE_FIELD_NAME)
	@Expose
	private String garmentStyle;
	
	@DatabaseField(
			columnName = REQUEST_EMAIL_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(REQUEST_EMAIL_FIELD_NAME)
	@Expose
	private String requestEmail;
	
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
			columnName = EAPMIS_ORDER_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(EAPMIS_ORDER_FIELD_NAME)
	@Expose
	private Long eapmisOrderID;
	
	@DatabaseField(
			columnName = "sold_to_tel", 
			canBeNull = true)
	@SerializedName(SOLD_TO_TELEPHONE_FIELD_NAME)
	@Expose
	private String soldToTelephone;
	
	@DatabaseField(
			columnName = "sold_to_attn", 
			canBeNull = true)
	@SerializedName(SOLD_TO_ATTENTION_FIELD_NAME)
	@Expose
	private String soldToAttention;
	
	@DatabaseField(
			columnName = CONSIGNED_TO_CUSTOMER_NAME_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(CONSIGNED_TO_CUSTOMER_NAME_FIELD_NAME)
	@Expose
	private String consignedToCustomerName;
	
	@DatabaseField(
			columnName = "consigned_to_addr", 
			canBeNull = true)
	@SerializedName(CONSIGNED_TO_ADDRESS_FIELD_NAME)
	@Expose
	private String consignedToAddress;
	
	@DatabaseField(
			columnName = "consigned_to_tel", 
			canBeNull = true)
	@SerializedName(CONSIGNED_TO_TELEPHONE_FIELD_NAME)
	@Expose
	private String consignedToTelephone;
	
	@DatabaseField(
			columnName = "consigned_to_attn", 
			canBeNull = true)
	@SerializedName(CONSIGNED_TO_ATTENTION_FIELD_NAME)
	@Expose
	private String consignedToAttention;
	
	@DatabaseField(
			columnName = ORDER_ACCEPTANCE_DATE_FIELD_NAME, 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(ORDER_ACCEPTANCE_DATE_FIELD_NAME)
	@Expose
	private Date orderAcceptanceDate;
	
	@DatabaseField(
			columnName = DELIVERY_DATE_FIELD_NAME, 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(DELIVERY_DATE_FIELD_NAME)
	@Expose
	private Date deliveryDate;
	
	@DatabaseField(
			columnName = READ_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(READ_FIELD_NAME)
	@Expose
	private boolean read;
	
	@DatabaseField(
			columnName = SEND_TO_EAPMIS_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(SEND_TO_EAPMIS_FIELD_NAME)
	@Expose
	private boolean sendToEapmis;
	
	@SerializedName(B2B_ORDER_NUMBER_FIELD_NAME)
	@Expose
	private String b2bOrderNumber;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(B2B_ORDER_NUMBERS_FIELD_NAME)
	private ForeignCollection<OrderNumber> orderNumbers;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(ORDER_ITEMS_FIELD_NAME)
	@Expose
	private ForeignCollection<OrderItem> orderItems;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(ORDER_MESSAGES_FIELD_NAME)
	@Expose
	private ForeignCollection<OrderMessage> orderMessages;
	
	public Order() {
		// Must provide an no-arg constructor
	}
	
	@Override
	public String getIdentity() {
		return getId();
	}

	@Override
	public String getIdentityAttribute() {
		return ORDER_ID_FIELD_NAME;
	}
	
	/**
	 * Returns the identity of this {@link Order}
	 * 
	 * @return the identity of this object
	 */
	public String getId() {
		return id;
	}

	/**
	 * Specifies a new identity of this {@link Order}
	 * 
	 * @param id a new identity of this {@link Order}
	 * @throws SQLException thrown if there was problem accessing the B2B database
	 */
	public void setId(String id) throws SQLException {
		this.id = id;
	}
	
	public Company getVendorCompany() {
		return vendorCompany;
	}
	
	public Company getBrandCompany() {
		return brandCompany;
	}
	
	/**
	 * Returns the identifier of the {@link Currency} used in this order
	 * @return the identifier of the {@link Currency} used in this order
	 */
	public Long getCurrencyID() {
		return currencyID;
	}

	/**
	 * Specifies the identifier of the {@link Currency} used in this order
	 * 
	 * @param currencyId the new identifier of the {@link Currency} used in this order
	 * @throws SQLException thrown if there was error retrieving the {@link Currency} from EAP
	 */
	public void setCurrencyID(Long currencyID) throws SQLException {
		this.currencyID = currencyID;
		
		if (currencyID != null && Application.getCurrent() instanceof DatastoreApplication) {
			Datastore store = ((DatastoreApplication) Application.getCurrent()).getDatastore(Store.EAP);
			currency = Model.find(store.getConnectionSource(), Currency.class, currencyID);
		}
	}
	
	public Long getSoldToCustomerID() {
		return soldToCustomerID;
	}

	public void setSoldToCustomerID(Long soldToCustomerID) throws SQLException {
		this.soldToCustomerID = soldToCustomerID;
		
		if (soldToCustomerID != null && Application.getCurrent() instanceof DatastoreApplication) {
			Datastore store = ((DatastoreApplication) Application.getCurrent()).getDatastore(Store.EAP);
			soldToCustomer = Model.find(store.getConnectionSource(), Customer.class, soldToCustomerID);
		}
	}

	public ForeignCollection<OrderItem> getOrderItems() {
		return orderItems;
	}
	
	public ForeignCollection<OrderMessage> getOrderMessages() {
		return orderMessages;
	}	
}
