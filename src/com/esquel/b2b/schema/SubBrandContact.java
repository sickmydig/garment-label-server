package com.esquel.b2b.schema;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "dtSubBrandContact")
public class SubBrandContact extends Model<SubBrandContact, Integer> implements Identity<Long> {

	public static final String SUB_BRAND_CONTACT_ID_FIELD_NAME = "sub_brand_contact_id";
	
	public static final String ID_FIELD_NAME = "iden";
	public static final String SUB_BRAND_FIELD_NAME = "sub_brand";
	public static final String ADDRESS_FIELD_NAME = "address";
	public static final String CONTACT_PERSON_FIELD_NAME = "contact_person";
	public static final String TELPHONE_FIELD_NAME = "tel_phone";
	public static final String MAIL_BOX_FIELD_NAME = "mail_box";
	public static final String CONTACT_TYPE_FIELD_NAME = "contact_type";
	public static final String IS_ACTIVE_FIELD_NAME = "is_active";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	
	
	
	
	@DatabaseField(
			columnName = "SubBrandContactID", 
			canBeNull = false, 
			id = true)
	@SerializedName(SUB_BRAND_CONTACT_ID_FIELD_NAME)
	@Expose
	private Long subBrandContactID;
	
	@DatabaseField(
			columnName = "iden", 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "SubBrandID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(SUB_BRAND_FIELD_NAME)
	@Expose
	private SubBrand subBrand;
	
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
	private String contactPerson;
	
	@DatabaseField(
			columnName = "Telphone", 
			canBeNull = true)
	@SerializedName(TELPHONE_FIELD_NAME)
	@Expose
	private String telphone;
	
	@DatabaseField(
			columnName = "MailBox", 
			canBeNull = true)
	@SerializedName(MAIL_BOX_FIELD_NAME)
	@Expose
	private String mailBox;
	
	@DatabaseField(
			columnName = "ContactType", 
			canBeNull = true)
	@SerializedName(CONTACT_TYPE_FIELD_NAME)
	@Expose
	private Boolean contactType;
	
	@DatabaseField(
			columnName = "IsActive", 
			canBeNull = true)
	@SerializedName(IS_ACTIVE_FIELD_NAME)
	@Expose
	private boolean isActive;
	
	@DatabaseField(
			columnName = "Remark", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
	@DatabaseField(
			columnName = "CreateBy", 
			canBeNull = true)
	@SerializedName(CREATE_BY_FIELD_NAME)
	@Expose
	private String createBy;
	
	@DatabaseField(
			columnName = "CreateTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATE_TIME_FIELD_NAME)
	@Expose
	private Date createTime;
	
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
	@SerializedName(LAST_MODIFY_TIME_FIELD_NAME)
	@Expose
	private Date lastModifyTime;
	
	
	
	
	public SubBrandContact() {
		// TODO Auto-generated constructor stub
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
