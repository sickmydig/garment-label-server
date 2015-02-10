package com.esquel.b2b.schema;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "uvw_b2bProductInfo")
public class ProductInfo extends Model<ProductInfo, Long> implements Identity<Long> {

	public static final String MATERIAL_HEADER_ID_FIELD_NAME = "material_header_id";
	public static final String PRODUCT_NUMBER_FIELD_NAME = "product_number";
	public static final String CUSTOMER_PRODUCT_NUMBER_FIELD_NAME = "customer_product_number";
	public static final String SUB_BRAND_FIELD_NAME = "sub_brand";
	public static final String BRAND_NAME_FIELD_NAME = "brand_name";
	public static final String SALES_FIELD_NAME = "sales";
	public static final String SALES_NAME_FIELD_NAME = "sales_name";
	public static final String SAMPLE_AGPO_FIELD_NAME = "sample_agpo";
	public static final String FACTORY_NAME_FIELD_NAME = "factory_name";
	public static final String PRODUCT_GROUP_FIELD_NAME = "product_group";
	public static final String PRICE_FIELD_NAME = "price";
	public static final String CURRENCY_NAME_FIELD_NAME = "currency_name";
	public static final String MINIMUM_ORDER_QUANTITY_FIELD_NAME = "minimum_order_quantity";
	public static final String UNIT_NAME_FIELD_NAME = "unit_name";
	
	@DatabaseField(
			columnName = "MaterialHdrID", 
			canBeNull = false,
			id = true)
	@SerializedName(MATERIAL_HEADER_ID_FIELD_NAME)
	@Expose
	private Long materialHeaderID;
	
	@DatabaseField(
			columnName = "ProductNO", 
			canBeNull = true)
	@SerializedName(PRODUCT_NUMBER_FIELD_NAME)
	@Expose
	private String productNumber;
	
	@DatabaseField(
			columnName = "CustormerProductNo", 
			canBeNull = true)
	@SerializedName(CUSTOMER_PRODUCT_NUMBER_FIELD_NAME)
	@Expose
	private String customerProductNumber;
	
	@DatabaseField(
			columnName = "SubBrandID",
			canBeNull = false,
			foreign = true)
	@SerializedName(SUB_BRAND_FIELD_NAME)
	@Expose
	private SubBrand subBrand;
	
	@DatabaseField(
			columnName = "BrandName", 
			canBeNull = true)
	@SerializedName(BRAND_NAME_FIELD_NAME)
	@Expose
	private String brandName;
	
	@DatabaseField(
			columnName = "SalesID", 
			canBeNull = false,
			foreign = true)
	@SerializedName(SALES_FIELD_NAME)
	@Expose
	private Sale sales;
	
	@DatabaseField(
			columnName = "SalesName", 
			canBeNull = true)
	@SerializedName(SALES_NAME_FIELD_NAME)
	@Expose
	private String salesName;
	
	@DatabaseField(
			columnName = "SampleAgpo", 
			canBeNull = true)
	@SerializedName(SAMPLE_AGPO_FIELD_NAME)
	@Expose
	private String sampleAgpo;
	
	@DatabaseField(
			columnName = "FactoryName", 
			canBeNull = true)
	@SerializedName(FACTORY_NAME_FIELD_NAME)
	@Expose
	private String factoryName;
	
	@DatabaseField(
			columnName = "ProductGroup", 
			canBeNull = true)
	@SerializedName(PRODUCT_GROUP_FIELD_NAME)
	@Expose
	private String productGroup;
	
	@DatabaseField(
			columnName = "Price", 
			canBeNull = true)
	@SerializedName(PRICE_FIELD_NAME)
	@Expose
	private Double price;
	
	@DatabaseField(
			columnName = "CurrencyName", 
			canBeNull = true)
	@SerializedName(CURRENCY_NAME_FIELD_NAME)
	@Expose
	private String currencyName;
	
	@DatabaseField(
			columnName = "MOQ", 
			canBeNull = true)
	@SerializedName(MINIMUM_ORDER_QUANTITY_FIELD_NAME)
	@Expose
	private String minimunOrderQuantity;
	
	@DatabaseField(
			columnName = "UnitName", 
			canBeNull = true)
	@SerializedName(UNIT_NAME_FIELD_NAME)
	@Expose
	private String unitName;

	public ProductInfo() {
		// Must have an no-arg constructor
	}
	
	@Override
	public Long getIdentity() {
		return materialHeaderID;
	}

	@Override
	public String getIdentityAttribute() {
		return MATERIAL_HEADER_ID_FIELD_NAME;
	}
	
	public String getCustomerProductNumber() {
		return customerProductNumber;
	}
	
	public String getProductGroup() {
		return productGroup;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public String getProductNumber() {
		return productNumber;
	}
	
	public String getBrandName() {
		return brandName;
	}
}