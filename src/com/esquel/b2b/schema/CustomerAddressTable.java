package com.esquel.b2b.schema;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "dtCustomerAddress")
public class CustomerAddressTable extends Model<CustomerAddressTable, Long> implements Identity<Long> {

	public static final String MAIL_BOX_FIELD_NAME = "mail_box";
	public static final String IS_ACTIVE_FIELD_NAME = "is_active";
	public static final String CONTACT_PERSON_FIELD_NAME = "contact_person";
	public static final String TELEPHONE_FIELD_NAME = "telephone";
	public static final String CUSTOMER_ADDRESS_NAME_FIELD_NAME = "customer_address_name";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String EEL_ADDRESS_ID_FIELD_NAME = "eel_address_id";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String CUSTOMER_FIELD_NAME = "customer";
	public static final String ADDRESS_FIELD_NAME = "address";
	public static final String CITY_FIELD_NAME = "city";
	public static final String PROVINCE_FIELD_NAME = "province";
	public static final String COUNTRY_FIELD_NAME = "country";
	public static final String ADDRESS_TYPE_ID_FIELD_NAME = "address_type_id";
	public static final String CUSTOMER_ADDRESS_ID_FIELD_NAME = "customer_address_id";
	public static final String IDEN_FIELD_NAME = "iden";
	
	@DatabaseField(
			columnName = "MailBox", 
			canBeNull = true)
	@SerializedName(MAIL_BOX_FIELD_NAME)
	@Expose
	private String mailBox;

	@DatabaseField(
			columnName = "IsActive", 
			canBeNull = false)
	@SerializedName(IS_ACTIVE_FIELD_NAME)
	@Expose
	private boolean isActive;

	@DatabaseField(
			columnName = "ContactPerson", 
			canBeNull = true)
	@SerializedName(CONTACT_PERSON_FIELD_NAME)
	@Expose
	private String contactPerson;
	
	@DatabaseField(
			columnName = "Telphone", 
			canBeNull = true)
	@SerializedName(TELEPHONE_FIELD_NAME)
	@Expose
	private String telephone;
	
	@DatabaseField(
			columnName = "CustomerAddressName", 
			canBeNull = true)
	@SerializedName(CUSTOMER_ADDRESS_NAME_FIELD_NAME)
	@Expose
	private String customerAddressName;
	
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
	
	@DatabaseField(
			columnName = "EelAddressID", 
			canBeNull = true)
	@SerializedName(EEL_ADDRESS_ID_FIELD_NAME)
	@Expose
	private String eelAddressID;
	
	@DatabaseField(
			columnName = "Remark", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
	@DatabaseField(
			columnName = "CustomerID", 
			canBeNull = false, 
			foreign = true)
	@SerializedName(CUSTOMER_FIELD_NAME)
	@Expose
	private Customer customer;
	
	@DatabaseField(
			columnName = "Address", 
			canBeNull = true)
	@SerializedName(ADDRESS_FIELD_NAME)
	@Expose
	private String address;
	
	@DatabaseField(
			columnName = "City", 
			canBeNull = true)
	@SerializedName(CITY_FIELD_NAME)
	@Expose
	private String city;
	
	@DatabaseField(
			columnName = "Province", 
			canBeNull = true)
	@SerializedName(PROVINCE_FIELD_NAME)
	@Expose
	private String province;
	
	@DatabaseField(
			columnName = "Country", 
			canBeNull = true)
	@SerializedName(COUNTRY_FIELD_NAME)
	@Expose
	private String country;
	
	@DatabaseField(
			columnName = "AddressTypeID", 
			canBeNull = false)
	@SerializedName(ADDRESS_TYPE_ID_FIELD_NAME)
	@Expose
	private Integer addressTypeID;
	
	@DatabaseField(
			columnName = "CustomerAddressID", 
			canBeNull = false, 
			       id = true)
	@SerializedName(CUSTOMER_ADDRESS_ID_FIELD_NAME)
	@Expose
	private Long customerAddressID;
	
	@DatabaseField(
			columnName = IDEN_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(IDEN_FIELD_NAME)
	@Expose
	private Integer iden;
	
	CustomerAddressTable() {
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
