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

@DatabaseTable(tableName = "dtSalesTeam")
public class SalesTeam extends Model<SalesTeam, Long> implements Identity<Long> {

	public static final String SALES_TEAM_ID_FIELD_NAME = "sales_team_id";
	
	public static final String ID_FIELD_NAME = "iden";
	public static final String SALES_TEAM_FIELD_NAME = "sales_team";
	public static final String SALE_FIELD_NAME = "sale";
	public static final String MARKET_ID_FIELD_NAME = "market_id";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	public static final String REMARK_FIELD_NAME = "remark";
	
	public static final String BULK_ORDERS_FIELD_NAME = "bulk_orders";
	public static final String SUB_BRANDS_FEILD_NAME = "sub_brands";
	
	
	
	
	@DatabaseField(
			columnName = "SalesTeamID", 
			canBeNull = false,
			id = true)
	@SerializedName(SALES_TEAM_ID_FIELD_NAME)
	@Expose
	private Long salesTeamID;
	
	@DatabaseField(
			columnName = "iden", 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "SalesTeam", 
			canBeNull = false)
	@SerializedName(SALES_TEAM_FIELD_NAME)
	@Expose
	private String salesTeam;
	
	@DatabaseField(
			columnName = "SalesID", 
			canBeNull = true,
			foreign = true)
	@SerializedName(SALE_FIELD_NAME)
	@Expose
	private Sale sale;

	@DatabaseField(
			columnName = "MarketID", 
			canBeNull = false)
	@SerializedName(MARKET_ID_FIELD_NAME)
	@Expose
	private int marketID;
	
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
	private Date createTime;
	
	@DatabaseField(
			columnName = "LastModifyBy", 
			canBeNull = false)
	@SerializedName(LAST_MODIFY_BY_FIELD_NAME)
	private String lastModifyBy;
	
	@DatabaseField(
			columnName = "LastModifyTime", 
			canBeNull = false,
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFY_TIME_FIELD_NAME)
	private Date lastModifyTime;
	
	@DatabaseField(
			columnName = "Remarks", 
			canBeNull = false)
	@SerializedName(REMARK_FIELD_NAME)
	private String remark;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(BULK_ORDERS_FIELD_NAME)
	@Expose
	private ForeignCollection<BulkOrder> bulkOrders;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(SUB_BRANDS_FEILD_NAME)
	@Expose
	private ForeignCollection<SubBrand> subBrands;
	
	
	
	
	public SalesTeam() {
		
	}
	
	@Override
	public Long getIdentity() {
		return salesTeamID;
	}

	@Override
	public String getIdentityAttribute() {
		return SALES_TEAM_ID_FIELD_NAME;
	}
}
