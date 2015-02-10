/** 
 * Customer.java
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

/**
 * A data model that represent a customer in the EAP system
 */
@DatabaseTable(tableName = "dtCustomerList")
public class Customer extends Model<Customer, Long> implements Identity<Long> {
	public static final String ADDRESSES_FIELD_NAME = "addresses";
	public static final String MAIL_BOX_FIELD_NAME = "mail_box";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String IS_ACTIVE_FIELD_NAME = "is_active";
	public static final String CONTACT_PERSON_FIELD_NAME = "contact_person";
	public static final String TELEPHONE_FIELD_NAME = "telephone";
	public static final String CUSTOMER_ID_FIELD_NAME = "customer_id";
	public static final String PAYMENT_TERM_LIST_FIELD_NAME = "payment_term_list";
	public static final String QUOTATION_MODE_ID_FIELD_NAME = "quotation_model_id";
	public static final String DELIVERY_AREAS_ID_FIELD_NAME = "delivery_areas_id";
	public static final String INVOICE_MODE_ID_FIELD_NAME = "invoice_model_id";
	public static final String CURRENCY_ID_FIELD_NAME = "currency_id";
	public static final String B_ALLOW_SHIP_FIELD_NAME = "b_allow_ship";
	public static final String CUSTOMER_CODE_FIELD_NAME = "customer_code";
	public static final String ORDER_REGION_ID_FIELD_NAME = "order_region_id";
	public static final String DISCOUT_FIELD_NAME = "discount";
	public static final String VAT_CUSTOMER_NAME_FIELD_NAME = "vat_customer_name";
	public static final String BANK_ACCOUNT_FIELD_NAME = "bank_account";
	public static final String VAT_ADD_FIELD_NAME = "vat_add";
	public static final String TFN_FIELD_NAME = "tfn";
	public static final String INV_REMARK_FIELD_NAME = "inv_remark";
	public static final String INV_TYPE_FIELD_NAME = "inv_type";
	public static final String REQUEST_FIELD_NAME = "request";
	public static final String LAST_INVOICE_FIELD_NAME = "last_invoice";
	public static final String AVAILABLE_AMOUNT_FIELD_NAME = "availeble_amount";
	public static final String OVERDUE_AMOUNT_FIELD_NAME = "overdue_amount";
	public static final String IS_NEED_PI_FIELD_NAME = "is_need_pi";
	public static final String EEL_ADDRESS_ID_FIELD_NAME = "eel_address_id";
	public static final String EEL_CUSTOMER_ID_FIELD_NAME = "eel_customer_id";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String DISTRICT_FIELD_NAME = "distict";
	public static final String HK_BACK_FIELD_NAME = "hk_back";
	public static final String TOHK_FIELD_NAME = "tohk";
	public static final String FAX_FIELD_NAME = "fax";
	public static final String ENGLISH_NAME_FIELD_NAME = "english_name";
	public static final String CUSTOMER_NAME_FIELD_NAME = "customer_name";
	public static final String ID_FIELD_NAME = "iden";
	public static final String BILL_TO_BULK_ORDERS_FIELD_NAME = "bill_to_bulk_orders";
	public static final String SHIP_TO_BULK_ORDERS_FIELD_NAME = "ship_to_bulk_orders";
	public static final String BRAND_CUSTOMERS_FIELD_NAME = "brand_customers";
	public static final String CUSTOMER_ADDRESSES_FIELD_NAME = "customer_addresses";
	public static final String CUSTOMER_PRODUCTS_FIELD_NAME = "customer_products";
	
	@DatabaseField(
			columnName = "MailBox", 
			canBeNull = true)
	@SerializedName(MAIL_BOX_FIELD_NAME)
	@Expose
	private String mailBox;

	@DatabaseField(
			columnName = "PaymentTermList", 
			canBeNull = true)
	@SerializedName(PAYMENT_TERM_LIST_FIELD_NAME)
	@Expose
	private String paymentTermList;
	
	@DatabaseField(
			columnName = "QuotationModeID", 
			canBeNull = true)
	@SerializedName(QUOTATION_MODE_ID_FIELD_NAME)
	@Expose
	private Integer quotationModeId;
	
	@DatabaseField(
			columnName = "DeliveryAreasID", 
			canBeNull = true)
	@SerializedName(DELIVERY_AREAS_ID_FIELD_NAME)
	@Expose
	private Integer deliveryAreasID;
	
	@DatabaseField(
			columnName = "InvoiceModeID", 
			canBeNull = true)
	@SerializedName(INVOICE_MODE_ID_FIELD_NAME)
	@Expose
	private Integer invoiceModeId;
	
	@DatabaseField(
			columnName = "CurrencyID", 
			canBeNull = true)
	@SerializedName(CURRENCY_ID_FIELD_NAME)
	@Expose
	private Integer currencyID;
	
	@DatabaseField(
			columnName = "bAllowShip", 
			canBeNull = true)
	@SerializedName(B_ALLOW_SHIP_FIELD_NAME)
	@Expose
	private boolean bAllowShip;
	
	@DatabaseField(
			columnName = "CustomerCode", 
			canBeNull = true)
	@SerializedName(CUSTOMER_CODE_FIELD_NAME)
	@Expose
	private String customerCode;
	
	@DatabaseField(
			columnName = "OrderRegionID", 
			canBeNull = true)
	@SerializedName(ORDER_REGION_ID_FIELD_NAME)
	@Expose
	private Integer orderRegionID;
	
	@DatabaseField(
			columnName = "IsActive", 
			canBeNull = false)
	@SerializedName(IS_ACTIVE_FIELD_NAME)
	@Expose
	private boolean isActive;

	@DatabaseField(
			columnName = "Discount", 
			canBeNull = true)
	@SerializedName(DISCOUT_FIELD_NAME)
	@Expose
	private Integer discount;
	
	@DatabaseField(
			columnName = "VATCustomerName", 
			canBeNull = true)
	@SerializedName(VAT_CUSTOMER_NAME_FIELD_NAME)
	@Expose
	private String VATCustomerName;
	
	@DatabaseField(
			columnName = "BankAccount", 
			canBeNull = true)
	@SerializedName(BANK_ACCOUNT_FIELD_NAME)
	@Expose
	private String bankAccount;
	
	@DatabaseField(
			columnName = "VATAdd", 
			canBeNull = true)
	@SerializedName(VAT_ADD_FIELD_NAME)
	@Expose
	private String VATAdd;
	
	@DatabaseField(
			columnName = "TFN", 
			canBeNull = true)
	@SerializedName(TFN_FIELD_NAME)
	@Expose
	private String tfn;
	
	@DatabaseField(
			columnName = "InvRemark", 
			canBeNull = true)
	@SerializedName(INV_REMARK_FIELD_NAME)
	@Expose
	private String invRemark;
	
	@DatabaseField(
			columnName = "InvType", 
			canBeNull = true)
	@SerializedName(INV_TYPE_FIELD_NAME)
	@Expose
	private String invType;
	
	@DatabaseField(
			columnName = "Request", 
			canBeNull = true)
	@SerializedName(REQUEST_FIELD_NAME)
	@Expose
	private String request;
	
	@DatabaseField(
			columnName = "LastInvoice", 
			canBeNull = true)
	@SerializedName(LAST_INVOICE_FIELD_NAME)
	@Expose
	private String lastInvoice;
	
	@DatabaseField(
			columnName = "AvailableAmount", 
			canBeNull = true)
	@SerializedName(AVAILABLE_AMOUNT_FIELD_NAME)
	@Expose
	private Integer availableAmount;
	
	@DatabaseField(
			columnName = "OverdueAmount", 
			canBeNull = true)
	@SerializedName(OVERDUE_AMOUNT_FIELD_NAME)
	@Expose
	private Integer overdueAmount;
	
	@DatabaseField(
			columnName = "IsNeedPI", 
			canBeNull = true)
	@SerializedName(IS_NEED_PI_FIELD_NAME)
	@Expose
	private boolean isNeedPI;
	
	@DatabaseField(
			columnName = "EelAddressID", 
			canBeNull = true)
	@SerializedName(EEL_ADDRESS_ID_FIELD_NAME)
	@Expose
	private String eelAddressID;
	
	@DatabaseField(
			columnName = "EelCustomerID", 
			canBeNull = true)
	@SerializedName(EEL_CUSTOMER_ID_FIELD_NAME)
	@Expose
	private String eelCustomerID;
	
	@DatabaseField(
			columnName = "Remark", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
	@DatabaseField(
			columnName = "District", 
			canBeNull = true)
	@SerializedName(DISTRICT_FIELD_NAME)
	@Expose
	private String district;
	
	@DatabaseField(
			columnName = "Hkback", 
			canBeNull = true)
	@SerializedName(HK_BACK_FIELD_NAME)
	@Expose
	private String hkBack;
	
	@DatabaseField(
			columnName = "Tohk", 
			canBeNull = true)
	@SerializedName(TOHK_FIELD_NAME)
	@Expose
	private String tohk;
	
	@DatabaseField(
			columnName = "Fax", 
			canBeNull = true)
	@SerializedName(FAX_FIELD_NAME)
	@Expose
	private String fax;
	
	@DatabaseField(
			columnName = "EnglishName", 
			canBeNull = true)
	@SerializedName(ENGLISH_NAME_FIELD_NAME)
	@Expose
	private String englishName;

	@DatabaseField(
			columnName = "ContactPerson", 
			canBeNull = true,
			useGetSet = true)
	@SerializedName(CONTACT_PERSON_FIELD_NAME)
	@Expose
	private String contactPerson;
	
	@DatabaseField(
			columnName = "Telphone", 
			canBeNull = true,
			useGetSet = true)
	@SerializedName(TELEPHONE_FIELD_NAME)
	@Expose
	private String telephone;
	
	@DatabaseField(
			columnName = "CustomerName", 
			canBeNull = true, 
			useGetSet = true)
	@SerializedName(CUSTOMER_NAME_FIELD_NAME)
	@Expose
	private String customerName;
	
	@DatabaseField(
			columnName = "LastModifyTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFY_TIME_FIELD_NAME)
	@Expose
	private Date lastModifyTime;
	
	@DatabaseField(
			columnName = "LastModifyBy", 
			canBeNull = true)
	@SerializedName(LAST_MODIFY_BY_FIELD_NAME)
	@Expose
	private String lastModifyBy;
	
	@DatabaseField(
			columnName = "LastModifyTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATE_TIME_FIELD_NAME)
	@Expose
	private Date createTime;
	
	@DatabaseField(
			columnName = "CreateBy", 
			canBeNull = true)
	@SerializedName(CREATE_BY_FIELD_NAME)
	@Expose
	private String createBy;
	
	@ForeignCollectionField(eager = false, foreignFieldName = "billToCustomer")
	@SerializedName(BILL_TO_BULK_ORDERS_FIELD_NAME)
	@Expose
	private ForeignCollection<BulkOrder> billToBulkOrders;
	
	@ForeignCollectionField(eager = false, foreignFieldName = "shipToCustomer")
	@SerializedName(SHIP_TO_BULK_ORDERS_FIELD_NAME)
	@Expose
	private ForeignCollection<BulkOrder> shipToBulkOrders;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(BRAND_CUSTOMERS_FIELD_NAME)
	@Expose
	private ForeignCollection<BrandCustomer> brandCustomers;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(ADDRESSES_FIELD_NAME)
	@Expose
	private ForeignCollection<CustomerAddressTable> addresses;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(CUSTOMER_ADDRESSES_FIELD_NAME)
	@Expose
	private ForeignCollection<CustomerAddress> customerAddresses;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(CUSTOMER_PRODUCTS_FIELD_NAME)
	@Expose
	private ForeignCollection<CustomerProduct> customerProducts;
	
	@DatabaseField(
			columnName = "CustomerID",
			id = true)
	@SerializedName(CUSTOMER_ID_FIELD_NAME)
	@Expose
	private Long customerId;

	@DatabaseField(
			columnName = ID_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	public Customer() {
		// Must have an no-arg constructor
	}
	
	@Override
	public Long getIdentity() {
		return customerId;
	}

	@Override
	public String getIdentityAttribute() {
		return CUSTOMER_ID_FIELD_NAME;
	}
	
	/**
	 * Returns the {@link Date} the customer was last modified in EAP
	 * 
	 * @return the {@link Date} the customer was last modified in EAP
	 */
	public Date getLastModified() {
		return lastModifyTime;
	}
	
	/** 
	 * Returns the name of this customer
	 * 
	 * @return the name of this customer
	 */
	public String getCustomerName() {
		return customerName;
	}
	
	/** 
	 * Set the name of this customer
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/** 
	 * Returns the contact of this customer
	 * 
	 * @return the contact of this customer
	 */
	public String getContactPerson() {
		return contactPerson;
	}
	
	/**
	 * Returns a boolean that indicates whether or not this customer is active
	 * 
	 * @return {@code true} if this customer is active, {@code false} otherwise
	 */
	public boolean isActive() {
		return isActive;
	}

	/** 
	 * Set the contact of this customer
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/** 
	 * Returns the telephone number of this customer
	 * 
	 * @return the telephone number of this customer
	 */
	public String getTelephone() {
		return telephone;
	}

	/** 
	 * Set the telephone number of this customer
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public ForeignCollection<BrandCustomer> getBrandCustomers() {
		return brandCustomers;
	}
	
	/**
	 * Converts this {@link Customer} into a {@link Company}
	 * 
	 * @return a {@link Company} representation of this customer
	 */
	public Company toCompany() {
		Company result = new Company();
		
		result.setType(Company.Type.VENDOR);
		result.setCustomerId(getIdentity());
		result.setCompanyName(getCustomerName());
		result.setUserQuota(Company.DEFAULT_USER_QUOTA);
		result.setStatus(isActive ? Company.Status.ACTIVE : Company.Status.INACTIVE);
		
		return result;
	}
}

