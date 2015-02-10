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
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

/**
 * A data model that represents a brand in the EAP system
 */
@DatabaseTable(tableName = "Currency")
public class Currency extends Model<Currency, Long> implements Identity<Long> {
	
	public static final String CURRENCY_ID_FIELD_NAME = "currency_id";
	public static final String ID_FIELD_NAME = "iden";
	public static final String CURRENCY_NAME_FIELD_NAME = "currency_name";
	public static final String IS_VALID_CAP_PHASE_FIELD_NAME = "is_valid_cap_phase";
	public static final String IS_VALID_COST_FIELD_NAME = "is_valid_cost";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	
    @DatabaseField(
			columnName = "CurrencyID",
			id = true)
	@SerializedName(CURRENCY_ID_FIELD_NAME)
	@Expose
	private Long currencyID;
    
    @DatabaseField(
			columnName = "iden",
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "CurrencyName", 
			canBeNull = false)
	@SerializedName(CURRENCY_NAME_FIELD_NAME)
	@Expose
	private String currencyName;
	
	@DatabaseField(
			columnName = "isValidCAPPhase", 
			canBeNull = false)
	@SerializedName(IS_VALID_CAP_PHASE_FIELD_NAME)
	@Expose
	private boolean isValidCAPPhase;
	
	@DatabaseField(
			columnName = "isValidCost",
			canBeNull = false)
	@SerializedName(IS_VALID_COST_FIELD_NAME)
	@Expose
	private boolean isValidCost;

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
    
	public Currency() {
		
	}
	
	@Override
	public Long getIdentity() {
		return currencyID;
	}
	
	@Override
	public String getIdentityAttribute() {
		return CURRENCY_ID_FIELD_NAME;
	}
}
