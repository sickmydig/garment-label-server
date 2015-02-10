package com.esquel.b2b.schema;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "dtPaymentTerm")
public class PaymentTerm extends Model<PaymentTerm, Long> implements Identity<Long> {

	public static final String PAYMENT_TERM_ID_FIELD_NAME = "payment_term_id";
	
	public static final String ID_FIELD_NAME = "iden";
	public static final String PAYMENT_TERM_FIELD_NAME = "payment_term";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	
	@DatabaseField(
			columnName = "PaymentTermID", 
			canBeNull = false, 
			id = true)
	@SerializedName(PAYMENT_TERM_ID_FIELD_NAME)
	@Expose
	private Long paymentTermID;
	
	@DatabaseField(
			columnName = "iden", 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "PaymentTerm", 
			canBeNull = true)
	@SerializedName(PAYMENT_TERM_FIELD_NAME)
	@Expose
	private String paymentTerm;
	
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
	
	public PaymentTerm() {
		// Auto-generated constructor stub
	}
	
	@Override
	public Long getIdentity() {
		return paymentTermID;
	}

	@Override
	public String getIdentityAttribute() {
		return PAYMENT_TERM_ID_FIELD_NAME;
	}
}
