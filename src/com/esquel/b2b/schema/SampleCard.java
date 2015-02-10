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

@DatabaseTable(tableName = "dtSampleCards")
public class SampleCard extends Model<SampleCard, Long> implements Identity<Long> {

	public static final String SAMPLE_CARD_ID_FIELD_NAME = "sample_card_id";
	public static final String SAMPLE_CARD_NO_FIELD_NAME = "sample_card_no";
	public static final String CUSTOMER_FIELD_NAME = "customer";
	public static final String CONSTACT_PERSON_FIELD_NAME = "contact_person";
	public static final String SALE_FIELD_NAME = "sale";
	public static final String SUBMIT_DATE_FIELD_NAME = "submit_date";
	public static final String SUB_BRAND_LIST_FIELD_NAME = "sub_brand_list";
	public static final String CUSTORMER_PRODUCT_NO_FIELD_NAME = "custormer_product_no";
	public static final String AGPONO_FIELD_NAME = "agpono";
	public static final String MASTERIAL_CODE_FIELD_NAME = "material_code";
	public static final String MATERIAL_CLASS_ID_FIELD_NAME = "material_class_id";
	public static final String MATERIAL_CLASS_NAME_FIELD_NAME = "material_class_name";
	public static final String PRICE_FIELD_NAME = "price";
	public static final String SIZE_FIELD_NAME = "size";
	public static final String MOQ_FIELD_NAME = "moq";
	public static final String MOQ_UNIT_ID_FIELD_NAME = "moq_unit_id";
	public static final String LEAD_TIME_FIELD_NAME = "lead_time";
	public static final String LEAD_TIME_FIELD_2_NAME = "lead_time_2";
	public static final String LT_UNIT_FIELD_NAME = "lt_unit";
	public static final String LT_QUANTITY_FIELD_NAME = "lt_quantity";
	public static final String REMARKS_FIELD_NAME = "remarks";
	public static final String SEASON_ID_FIELD_NAME = "season_id";
	public static final String CAP_VERSION_FIELD_NAME = "cap_version";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	public static final String SAMPLE_SUB_PRODUCT_ID_FIELD_NAME = "sample_sub_product_id";
	public static final String UPDATE_SAMPLE_READY_FIELD_NAME = "update_sample_ready";
	public static final String SAMPLE_OPTION_FIELD_NAME = "sample_option";
	public static final String COLOR_FIELD_NAME = "color";
	public static final String IS_ACTIVE_FIELD_NAME = "is_active";
	public static final String SUB_BRAND_NAME_FIELD_NAME = "sub_brand_name";
	
	public static final String ID_FIELD_NAME = "iden";
	
	@DatabaseField(
			columnName = "SampleCardID", 
			canBeNull = false,
			id = true)
	@SerializedName(SAMPLE_CARD_ID_FIELD_NAME)
	@Expose
	private Long sampleCardID;
	
	@DatabaseField(
			columnName = "SampleCardNo", 
			canBeNull = false)
	@SerializedName(SAMPLE_CARD_NO_FIELD_NAME)
	@Expose
	private String sampleCardNo;
	
	@DatabaseField(
			columnName = "ContactPerson", 
			canBeNull = false)
	@SerializedName(CONSTACT_PERSON_FIELD_NAME)
	@Expose
	private String contactPerson;
	
	@DatabaseField(
			columnName = "SubmitDate", 
			canBeNull = false)
	@SerializedName(SUBMIT_DATE_FIELD_NAME)
	@Expose
	private String submitDate;
	
	@DatabaseField(
			columnName = "CustormerProductNo", 
			canBeNull = false)
	@SerializedName(CUSTORMER_PRODUCT_NO_FIELD_NAME)
	@Expose
	private String custormerProductNo;
	
	@DatabaseField(
			columnName = "AGPONO", 
			canBeNull = false)
	@SerializedName(AGPONO_FIELD_NAME)
	@Expose
	private String aGPONO;
	
	@DatabaseField(
			columnName = "MaterialCode", 
			canBeNull = false)
	@SerializedName(MASTERIAL_CODE_FIELD_NAME)
	@Expose
	private int materialCode;
	
	@DatabaseField(
			columnName = "MaterialClassID", 
			canBeNull = false)
	@SerializedName(MATERIAL_CLASS_ID_FIELD_NAME)
	@Expose
	private int materialClassID;
	
	@DatabaseField(
			columnName = "MaterialClassName", 
			canBeNull = false)
	@SerializedName(MATERIAL_CLASS_NAME_FIELD_NAME)
	@Expose
	private String materialClassName;
	
	@DatabaseField(
			columnName = "Price", 
			canBeNull = false)
	@SerializedName(PRICE_FIELD_NAME)
	@Expose
	private String price;
	
	@DatabaseField(
			columnName = "Size", 
			canBeNull = false)
	@SerializedName(SIZE_FIELD_NAME)
	@Expose
	private String size;
	
	@DatabaseField(
			columnName = "MOQ", 
			canBeNull = false)
	@SerializedName(MOQ_FIELD_NAME)
	@Expose
	private String mOQ;
	
	@DatabaseField(
			columnName = "MOQUnitID", 
			canBeNull = false)
	@SerializedName(MOQ_UNIT_ID_FIELD_NAME)
	@Expose
	private int mOQUnitID;
	
	@DatabaseField(
			columnName = "LeadTime", 
			canBeNull = false)
	@SerializedName(LEAD_TIME_FIELD_NAME)
	@Expose
	private int leadTime;
	
	@DatabaseField(
			columnName = "LeadTime2", 
			canBeNull = false)
	@SerializedName(LEAD_TIME_FIELD_2_NAME)
	@Expose
	private int leadTime2;
	
	@DatabaseField(
			columnName = "LTUnit", 
			canBeNull = false)
	@SerializedName(LT_UNIT_FIELD_NAME)
	@Expose
	private int lTUnit;
	
	@DatabaseField(
			columnName = "LTQuantity", 
			canBeNull = false)
	@SerializedName(LT_QUANTITY_FIELD_NAME)
	@Expose
	private String lTQuantity;
	
	@DatabaseField(
			columnName = "Remarks", 
			canBeNull = false)
	@SerializedName(REMARKS_FIELD_NAME)
	@Expose
	private String remarks;
	
	@DatabaseField(
			columnName = "SeassonID", 
			canBeNull = false)
	@SerializedName(SEASON_ID_FIELD_NAME)
	@Expose
	private int seasonID;
	
	@DatabaseField(
			columnName = "CAP_Version", 
			canBeNull = false)
	@SerializedName(CAP_VERSION_FIELD_NAME)
	@Expose
	private String cAPVersion;
	
	@DatabaseField(
			columnName = "CreateBy", 
			canBeNull = false)
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
			canBeNull = false)
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
			columnName = "SampleSubProductID", 
			canBeNull = false)
	@SerializedName(SAMPLE_SUB_PRODUCT_ID_FIELD_NAME)
	@Expose
	private int sampleSubProductID;
	
	@DatabaseField(
			columnName = "UpdateSampleReady", 
			canBeNull = false)
	@SerializedName(UPDATE_SAMPLE_READY_FIELD_NAME)
	@Expose
	private boolean updateSampleReady;
	
	@DatabaseField(
			columnName = "SampleOption", 
			canBeNull = false)
	@SerializedName(SAMPLE_OPTION_FIELD_NAME)
	@Expose
	private String sampleOption;
	
	@DatabaseField(
			columnName = "Color", 
			canBeNull = false)
	@SerializedName(COLOR_FIELD_NAME)
	@Expose
	private String color;
	
	@DatabaseField(
			columnName = "IsActive", 
			canBeNull = false)
	@SerializedName(IS_ACTIVE_FIELD_NAME)
	@Expose
	private boolean isActive;
	
	@DatabaseField(
			columnName = "SubBrandName", 
			canBeNull = false)
	@SerializedName(SUB_BRAND_NAME_FIELD_NAME)
	@Expose
	private String subBrandName;
	
	@DatabaseField(
			columnName = ID_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	/**
	 *  =============================================================================
	 *  ==============================FOREIGN_KEY====================================
	 *  =============================================================================
	 */
	
	@DatabaseField(
			columnName = "SalesID", 
			canBeNull = true,
			foreign = true)
	@SerializedName(SALE_FIELD_NAME)
	@Expose
	private Sale sale;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(CUSTOMER_FIELD_NAME)
	@Expose
	private ForeignCollection<Customer> customer;
	
	@DatabaseField(
			columnName = "SubBrandID", 
			canBeNull = true,
			foreign = true)
	@SerializedName(SUB_BRAND_LIST_FIELD_NAME)
	@Expose
	private SubBrand subBrandList;
	
	@Override
	public Long getIdentity() {
		return sampleCardID;
	}

	@Override
	public String getIdentityAttribute() {
		return SAMPLE_CARD_ID_FIELD_NAME;
	}
}
