/** 
 * Brand.java
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
 * A data model that represents a brand in the EAP system
 */
@DatabaseTable(tableName = "dtBrandList")
public class Brand extends Model<Brand, Long> implements Identity<Long> {
	
	public static final String BRAND_ID_FIELD_NAME = "brand_id";
	public static final String ID_FIELD_NAME = "iden";
	public static final String MARKET_ID_FIELD_NAME = "market_id";
	public static final String SALES_TEAM_ID_FIELD_NAME = "sales_team_id";
	public static final String BRAND_NAME_FIELD_NAME = "brand_name";
	public static final String SUB_MARKET_FIELD_NAME = "sub_market";
	public static final String ORACLE_BRAND_ID_FIELD_NAME = "oracle_brand_id";
	public static final String SALES_ID_FIELD_NAME = "sale_id";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	public static final String SUB_BRAND_FIELD_NAME = "sub_brands";
	
    @DatabaseField(
			columnName = "BrandID",
			id = true)
	@SerializedName(BRAND_ID_FIELD_NAME)
	@Expose
	private Long brandID;
    
    @DatabaseField(
			columnName = "iden",
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "MarketID", 
			canBeNull = false)
	@SerializedName(MARKET_ID_FIELD_NAME)
	@Expose
	private Long marketID;
	
	@DatabaseField(
			columnName = "SalesTeamID", 
			canBeNull = false)
	@SerializedName(SALES_TEAM_ID_FIELD_NAME)
	@Expose
	private Long salesTeamID;
	
	@DatabaseField(columnName = "BrandName")
	@SerializedName(BRAND_NAME_FIELD_NAME)
	@Expose
	private String brandName;

	@DatabaseField(
			columnName = "SubMarket", 
			canBeNull = true)
	@SerializedName(SUB_MARKET_FIELD_NAME)
	@Expose
	private String subMarket;
	
	@DatabaseField(
			columnName = "OracleBrandID", 
			canBeNull = true)
	@SerializedName(ORACLE_BRAND_ID_FIELD_NAME)
	@Expose
	private String oracleBrandID;
	
	@DatabaseField(
			columnName = "SalesID", 
			canBeNull = true)
	@SerializedName(SALES_ID_FIELD_NAME)
	@Expose
	private Long salesID;
	
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
	
	
		
	
	
	
	
	
	

	
	@ForeignCollectionField(eager = false)
	@SerializedName(SUB_BRAND_FIELD_NAME)
	@Expose
	private ForeignCollection<SubBrand> subBrands;
	

	
	
	
	public Brand() {
		
	}
	
	
	@Override
	public Long getIdentity() {
		return brandID;
	}
	

	@Override
	public String getIdentityAttribute() {
		return BRAND_ID_FIELD_NAME;
	}
		

	public String getName() {
		return brandName;
	}
		

	public Long getSalesID() {
		return salesID;
	}
	
	public ForeignCollection<SubBrand> getSubBrands() {
		return subBrands;
	}
}
