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

@DatabaseTable(tableName = "dtSalesList")
public class Sale extends Model<Sale, Long> implements Identity<Long> {

	public static final String SALES_ID_FIELD_NAME = "sales_id";
	
	public static final String ID_FIELD_NAME = "iden";
	public static final String SALES_NAME_FIELD_NAME = "sales_name";
	public static final String CHINESE_NAME_FIELD_NAME = "chinese_name";
	public static final String REMARK_FIELD_NAME = "remarks";
	public static final String EMAIL_FIELD_NAME = "email";
	public static final String OFFICE_FIELD_NAME = "office";
	public static final String PHONE_NUMBER_FIELD_NAME = "phone_number";
	public static final String MOBILE_FIELD_NAME = "mobile";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	public static final String IS_ACTIVE_FIELD_NAME = "is_active";
	
	public static final String BULK_ORDERS_FIELD_NAME = "bulk_orders";
	public static final String PRODUCT_INFOS_FIELD_NAME = "product_infos";
	public static final String PRODUCT_SUB_CODE_INFOS_FIELD_NAME = "product_sub_code_infos";
	public static final String SALES_TEAMS_FIELD_NAME = "sales_team";
	public static final String SUB_BRAND_LISTS_FIELD_NAME = "sub_brand_list";
	
	
	
	
	@DatabaseField(
			columnName = "SalesID", 
			canBeNull = true,
			id = true)
	@SerializedName(SALES_ID_FIELD_NAME)
	@Expose
	private Long salesID;
	
	@DatabaseField(
			columnName = "iden", 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "SalesName", 
			canBeNull = true)
	@SerializedName(SALES_NAME_FIELD_NAME)
	@Expose
	private String salesName;
	
	@DatabaseField(
			columnName = "ChieseName", 
			canBeNull = true)
	@SerializedName(CHINESE_NAME_FIELD_NAME)
	@Expose
	private String chineseName;
	
	@DatabaseField(
			columnName = "Remarks", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
	@DatabaseField(
			columnName = "Email", 
			canBeNull = true)
	@SerializedName(EMAIL_FIELD_NAME)
	@Expose
	private String email;
	
	@DatabaseField(
			columnName = "Office", 
			canBeNull = true)
	@SerializedName(OFFICE_FIELD_NAME)
	@Expose
	private String office;
	
	@DatabaseField(
			columnName = "PhoneNumber", 
			canBeNull = true)
	@SerializedName(PHONE_NUMBER_FIELD_NAME)
	@Expose
	private String phoneNumber;
	
	@DatabaseField(
			columnName = "Mobile", 
			canBeNull = true)
	@SerializedName(MOBILE_FIELD_NAME)
	@Expose
	private String mobile;
	
	@DatabaseField(
			columnName = "CreateBy", 
			canBeNull = true)
	@SerializedName(CREATE_BY_FIELD_NAME)
	@Expose
	private String createBy;

	@DatabaseField(
			columnName = "LastModifyTime", 
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
	
	@DatabaseField(
			columnName = "IsActive", 
			canBeNull = false)
	@SerializedName(IS_ACTIVE_FIELD_NAME)
	@Expose
	private boolean isActive;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(BULK_ORDERS_FIELD_NAME)
	@Expose
	private ForeignCollection<BulkOrder> bulkOrders;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_INFOS_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductInfo> productInfos;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_SUB_CODE_INFOS_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductSubCodeInfo> productSubCodeInfos;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(SALES_TEAMS_FIELD_NAME)
	@Expose
	private ForeignCollection<SalesTeam> salesTeams;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(SUB_BRAND_LISTS_FIELD_NAME)
	@Expose
	private ForeignCollection<SubBrand> subBrands;


	
	
	
	public Sale() {
		
	}
		
	@Override
	public Long getIdentity() {
		return salesID;
	}

	@Override
	public String getIdentityAttribute() {
		return SALES_ID_FIELD_NAME;
	}
	
	public String getSalesName() {
		return salesName;
	}
	
	public String getEmail() {
		return email;
	}

}
