package com.esquel.b2b.schema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "uvw_B2BCustomerAddress")
public class CustomerAddress extends Model<CustomerAddress, Long> implements Identity<Long> {
	
	public static final String CUSTOMER_FIELD_NAME = "customer";
	public static final String CUSTOMER_NAME_FIELD_NAME = "customer_name";
	public static final String CUSTOMER_ADDRESS_ID_FIELD_NAME = "customer_address_id";
	public static final String COMPANY_NAME_FIELD_NAME = "campany_name";
	public static final String ADDRESS_FIELD_NAME = "address";
	public static final String CONTACT_PERSON_FIELD_NAME = "contact_person";
	public static final String TELEPHONE_FIELD_NAME = "telephone";
	public static final String MAIL_BOX_FIELD_NAME = "mail_box";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String IS_ACTIVE_FIELD_NAME = "active";
	public static final String ADDRESS_TYPE_FIELD_NAME = "address_type";
	public static final String ADDRESS_TYPE_ID_FIELD_NAME = "address_type_id";
	
	@DatabaseField(
			columnName = "CustomerID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(CUSTOMER_FIELD_NAME)
	@Expose
	private Customer customer;
	
	@DatabaseField(
			columnName = "CustomerName", 
			canBeNull = false)
	@SerializedName(CUSTOMER_NAME_FIELD_NAME)
	@Expose
	private String customerName;
	
	@DatabaseField(
			columnName = "CustomerAddressID", 
			canBeNull = false,
			id = true)
	@SerializedName(CUSTOMER_ADDRESS_ID_FIELD_NAME)
	@Expose
	private Long customerAddressID;
	
	@DatabaseField(
			columnName = "CompanyName", 
			canBeNull = true)
	@SerializedName(COMPANY_NAME_FIELD_NAME)
	@Expose
	private String companyName;
	
	@DatabaseField(
			columnName = "Address", 
			canBeNull = true)
	@SerializedName(ADDRESS_FIELD_NAME)
	@Expose
	private String address;
	
	@DatabaseField(
			columnName = "ContactPerson", 
			canBeNull = true)
	@SerializedName(CONTACT_PERSON_FIELD_NAME)
	@Expose
	private String contactPerosn;
	
	@DatabaseField(
			columnName = "Telphone", 
			canBeNull = true)
	@SerializedName(TELEPHONE_FIELD_NAME)
	@Expose
	private String telephone;
	
	@DatabaseField(
			columnName = "MailBox", 
			canBeNull = true)
	@SerializedName(MAIL_BOX_FIELD_NAME)
	@Expose
	private String mailBox;
	
	@DatabaseField(
			columnName = "Remark", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
	@DatabaseField(
			columnName = "IsActive", 
			canBeNull = false)
	@SerializedName(IS_ACTIVE_FIELD_NAME)
	@Expose
	private boolean isActive;
	
	@DatabaseField(
			columnName = "AddressType", 
			canBeNull = false)
	@SerializedName(ADDRESS_TYPE_FIELD_NAME)
	@Expose
	private String addressType;
	
	@DatabaseField(
			columnName = "AddressTypeID", 
			canBeNull = false)
	@SerializedName(ADDRESS_TYPE_ID_FIELD_NAME)
	@Expose
	private Long addressTypeID;
	
	public CustomerAddress() {
	}
	
	@Override
	public Long getIdentity() {
		return customerAddressID;
	}

	@Override
	public String getIdentityAttribute() {
		return CUSTOMER_ADDRESS_ID_FIELD_NAME;
	}
}