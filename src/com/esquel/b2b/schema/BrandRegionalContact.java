package com.esquel.b2b.schema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "uvw_b2bBrandRegionalContacts")
public class BrandRegionalContact extends Model<BrandRegionalContact, Long> implements Identity<Long> {
	
	public static final String SUB_BRAND_CONTACT_ID_FIELD_NAME = "sub_brand_contact_id";
	public static final String SUB_BRAND_FIELD_NAME = "sub_brand";
	public static final String BRAND_NAME_FIELD_NAME = "brand_name";
	public static final String REGIONAL_ADDRESS_FIELD_NAME = "regional_address";
	public static final String REGIONAL_CONTACT_PERSON_FIELD_NAME = "regional_contact_person";
	public static final String REGIONAL_TELEPHONE_FIELD_NAME = "regional_telephone";
	public static final String REGIONAL_MAIL_BOX_FIELD_NAME = "regional_mail_box";
	
	
	@DatabaseField(
			columnName = "SubBrandContactID", 
			canBeNull = false,
			id = true)
	@SerializedName(SUB_BRAND_CONTACT_ID_FIELD_NAME)
	@Expose
	private Long subBrandContactID;
	
	@DatabaseField(
			columnName = "SubBrandID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(SUB_BRAND_FIELD_NAME)
	@Expose
	private SubBrand subBrand;

	@DatabaseField(
			columnName = "BrandName", 
			canBeNull = false)
	@SerializedName(BRAND_NAME_FIELD_NAME)
	@Expose
	private String brandName;
	
	@DatabaseField(
			columnName = "RegionalAddress", 
			canBeNull = true)
	@SerializedName(REGIONAL_ADDRESS_FIELD_NAME)
	@Expose
	private String regionalAddress;
	
	@DatabaseField(
			columnName = "RegionalContactPerson", 
			canBeNull = true)
	@SerializedName(REGIONAL_CONTACT_PERSON_FIELD_NAME)
	@Expose
	private String regionalContactPerson;
	
	@DatabaseField(
			columnName = "RegionalTelphone", 
			canBeNull = true)
	@SerializedName(REGIONAL_TELEPHONE_FIELD_NAME)
	@Expose
	private String regionalTelephone;
	
	@DatabaseField(
			columnName = "RegionalMailBox", 
			canBeNull = true)
	@SerializedName(REGIONAL_MAIL_BOX_FIELD_NAME)
	@Expose
	private String regionalMailBox;
	
	public BrandRegionalContact() {
	}
	
	@Override
	public Long getIdentity() {
		return subBrandContactID;
	}

	@Override
	public String getIdentityAttribute() {
		return SUB_BRAND_CONTACT_ID_FIELD_NAME;
	}
}