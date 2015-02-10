package com.esquel.b2b.schema;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "order_item_sub_products")
public class OrderItemSubProduct extends Model<OrderItemSubProduct, String> implements Identity<String> {

	public static final String ID_FIELD_NAME = "order_item_sub_product_id";
	
	public static final String ORDER_ITEM_FIELD_NAME = "order_item";
	public static final String SUB_PRODUCT_FIELD_NAME = "sub_product";
	
	
	
	
	@DatabaseField(
			columnName = "order_item_sub_products", 
			canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private String id;
	
	@DatabaseField(
			columnName = ORDER_ITEM_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(ORDER_ITEM_FIELD_NAME)
	@Expose
	private OrderItem orderItem;
	
	@DatabaseField(
			columnName = SUB_PRODUCT_FIELD_NAME + "_id", 
			canBeNull = true,
			foreign = true)
	@SerializedName(SUB_PRODUCT_FIELD_NAME)
	@Expose
	private SubProduct subProduct;
	
	@DatabaseField(
			columnName = CREATED_DATE_FIELD_NAME, 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATED_DATE_FIELD_NAME)
	@Expose
	private Date createdDate;

	@DatabaseField(
			columnName = LAST_MODIFIED_DATE_FIELD_NAME, 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFIED_DATE_FIELD_NAME)
	@Expose
	private Date lastModifiedDate;
	
	
	
	
	public OrderItemSubProduct() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
}
