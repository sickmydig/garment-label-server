package com.esquel.b2b.schema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "uvw_b2bBrandInfo")
public class BrandInfo extends Model<BrandInfo, Long> implements Identity<Long> {
	
	public static final String SUB_BRAND_ID_FIELD_NAME = "sub_brand_id";
	public static final String BRAND_NAME_FIELD_NAME = "brand_name";
	public static final String HEAD_QUARTER_OFFICE_ADDRESS_FIELD_NAME = "head_quarter_office_address";
	public static final String HEAD_QUARTER_OFFICE_CONTACT_PERSON_FIELD_NAME = "head_quarter_office_contact_person";
	public static final String HEAD_QUARTER_OFFICE_PHONE_NUMBER_FIELD_NAME = "head_quarter_office_phone_number";
	public static final String HEAD_QUARTER_OFFICE_MAIL_BOX_FIELD_NAME = "head_quarter_office_mail_box";
	public static final String IS_ACTIVE_FIELD_NAME = "active";
	public static final String SALES_NAME_FIELD_NAME = "sales_name";
	public static final String SALES_MAIL_FIELD_NAME = "sales_mail";
	public static final String OMD_FOLLOWER_NAME_FIELD_NAME = "omd_follower_name";
	public static final String OMD_FOLLOWER_MAIL_BOX_FIELD_NAME = "omd_follower_mail_box";
	public static final String BRAND_OWNER_FIELD_NAME = "brand_owner";
	
	@DatabaseField(
			columnName = "SubBrandID", 
			canBeNull = false,
			id = true)
	@SerializedName(SUB_BRAND_ID_FIELD_NAME)
	@Expose
	private Long subBrandID;

	@DatabaseField(
			columnName = "BrandName", 
			canBeNull = false)
	@SerializedName(BRAND_NAME_FIELD_NAME)
	@Expose
	private String brandName;
	
	@DatabaseField(
			columnName = "HeadQuarterOfficeAddress", 
			canBeNull = true)
	@SerializedName(HEAD_QUARTER_OFFICE_ADDRESS_FIELD_NAME)
	@Expose
	private String headQuarterOfficeAddress;
	
	@DatabaseField(
			columnName = "HeadQuarterOfficeContactPerson", 
			canBeNull = true)
	@SerializedName(HEAD_QUARTER_OFFICE_CONTACT_PERSON_FIELD_NAME)
	@Expose
	private String headQuarterOfficeContactPerson;
	
	@DatabaseField(
			columnName = "HeadQuarterOfficePhoneNum", 
			canBeNull = true)
	@SerializedName(HEAD_QUARTER_OFFICE_PHONE_NUMBER_FIELD_NAME)
	@Expose
	private String headQuarterOfficePhoneNumber;
	
	@DatabaseField(
			columnName = "HeadQuarterOfficeMailBox", 
			canBeNull = true)
	@SerializedName(HEAD_QUARTER_OFFICE_MAIL_BOX_FIELD_NAME)
	@Expose
	private String headQuarterOfficeMailBox;
	
	@DatabaseField(
			columnName = "IsActive", 
			canBeNull = false)
	@SerializedName(IS_ACTIVE_FIELD_NAME)
	@Expose
	private boolean isActive;
	
	@DatabaseField(
			columnName = "SalesName", 
			canBeNull = true)
	@SerializedName(SALES_NAME_FIELD_NAME)
	@Expose
	private String salesName;
	
	@DatabaseField(
			columnName = "SalesMail", 
			canBeNull = true)
	@SerializedName(SALES_MAIL_FIELD_NAME)
	@Expose
	private String salesMail;

	@DatabaseField(
			columnName = "OMDFollowerName", 
			canBeNull = true)
	@SerializedName(OMD_FOLLOWER_NAME_FIELD_NAME)
	@Expose
	private String omdFollowerName;
	
	@DatabaseField(
			columnName = "OMDFollowerMailbox", 
			canBeNull = true)
	@SerializedName(OMD_FOLLOWER_MAIL_BOX_FIELD_NAME)
	@Expose
	private String omdFollowerMailBox;
	
	@DatabaseField(
			columnName = "BrandOwner", 
			canBeNull = true)
	@SerializedName(BRAND_OWNER_FIELD_NAME)
	@Expose
	private String brandOwner;
	
	public BrandInfo() {
	}
	
	@Override
	public Long getIdentity() {
		return subBrandID;
	}

	@Override
	public String getIdentityAttribute() {
		return SUB_BRAND_ID_FIELD_NAME;
	}

	/**
	 * Returns the brand name of this Info
	 * 
	 * @return the brand id of this Info
	 */
	public String getBrandName() {
		return brandName;
	}
	
	/**
	 * Returns the contact of this Info
	 * 
	 * @return the contact of this Info
	 */
	public String getHeadQuarterOfficeContactPerson() {
		return headQuarterOfficeContactPerson;
	}
	
	/**
	 * Returns the phone number of this Info
	 * 
	 * @return the phone number of this Info
	 */
	public String getHeadQuarterOfficePhoneNumber() {
		return headQuarterOfficePhoneNumber;
	}
	
	/**
	 * Returns the office address of this Info
	 * 
	 * @return the office address of this Info
	 */
	public String getHeadQuarterOfficeAddress() {
		return headQuarterOfficeAddress;
	}
	
	/**
	 * Returns the mail box of this Info
	 * 
	 * @return the mail box of this Info
	 */
	public String getHeadQuarterOfficeMailBox() {
		return headQuarterOfficeMailBox;
	}
}