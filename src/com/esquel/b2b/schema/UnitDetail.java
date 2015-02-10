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

@DatabaseTable(tableName = "")
public class UnitDetail extends Model<UnitDetail, Long> implements Identity<Long> {

	public static final String UNIT_DETAIL_ID_FIELD_NAME = "unit_detail_id";
	
	public static final String ID_FIELD_NAME = "iden";
	public static final String UNIT_MASTER_ID_FIELD_NAME = "unit_master_id";
	public static final String UNIT_NAME_FIELD_NAME = "unit_name";
	public static final String CONVERT_VALUE_FIELD_NAME = "convert_value";
	public static final String ORACLE_UNIT_CODE_FIELD_NAME = "oracle_unit_code";
	public static final String ORACLE_UNIT_NAME_FIELD_NAME = "oracle_unit_name";
	public static final String B_ORACLE_USE_FIELD_NAME = "b_oracle_use";
	public static final String B_EAP_MATERIAL_USE_FIELD_NAME = "b_eap_material_use";
	public static final String B_EAP_PRODUCT_USE_FIELD_NAME = "b_eap_product_use";
	public static final String IS_VALID_FIELD_NAME = "is_valid";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	
	@DatabaseField(
			columnName = "UnitDetailID", 
			canBeNull = false,
			id = true)
	@SerializedName(UNIT_DETAIL_ID_FIELD_NAME)
	@Expose
	private Long unitDetailID;
	
	@DatabaseField(
			columnName = "Iden", 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "UnitMasterID", 
			canBeNull = false)
	@SerializedName(UNIT_MASTER_ID_FIELD_NAME)
	@Expose
	private Long unitMasterID;
	
	@DatabaseField(
			columnName = "UnitName", 
			canBeNull = false)
	@SerializedName(UNIT_NAME_FIELD_NAME)
	@Expose
	private String unitName;
	
	@DatabaseField(
			columnName = "ConvertValue", 
			canBeNull = false)
	@SerializedName(CONVERT_VALUE_FIELD_NAME)
	@Expose
	private Double convertValue;
	
	@DatabaseField(
			columnName = "OracleUnitCode", 
			canBeNull = true)
	@SerializedName(ORACLE_UNIT_CODE_FIELD_NAME)
	@Expose
	private String oracleUnitCode;
	
	@DatabaseField(
			columnName = "OracleUnitName", 
			canBeNull = true)
	@SerializedName(ORACLE_UNIT_NAME_FIELD_NAME)
	@Expose
	private String oracleUnitName;
	
	@DatabaseField(
			columnName = "bOracleUse", 
			canBeNull = false)
	@SerializedName(B_ORACLE_USE_FIELD_NAME)
	@Expose
	private boolean bOracleUse;
	
	@DatabaseField(
			columnName = "bEAPMaterialUse", 
			canBeNull = false)
	@SerializedName(B_EAP_MATERIAL_USE_FIELD_NAME)
	@Expose
	private boolean bEapMaterialUse;
	
	@DatabaseField(
			columnName = "bEAPProductUse", 
			canBeNull = false)
	@SerializedName(B_EAP_PRODUCT_USE_FIELD_NAME)
	@Expose
	private boolean bEapProductUse;
	
	@DatabaseField(
			columnName = "IsValid", 
			canBeNull = false)
	@SerializedName(IS_VALID_FIELD_NAME)
	@Expose
	private boolean isValid;
	
	@DatabaseField(
			columnName = "Remark", 
			canBeNull = false)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
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

	public UnitDetail() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Long getIdentity() {
		return unitDetailID;
	}

	@Override
	public String getIdentityAttribute() {
		return UNIT_DETAIL_ID_FIELD_NAME;
	}
}
