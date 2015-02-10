package com.esquel.b2b.schema;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "uvw_B2BProductSubCodeInfo")
public class ProductSubCodeInfo extends Model<ProductSubCodeInfo, Long> implements Identity<Long> {
	
	public static final String MATERIAL_HEADER_FIELD_NAME = "material_header";
	public static final String MATERIAL_ID_FIELD_NAME = "material_id";
	public static final String PRODUCT_NUMBER_FIELD_NAME = "product_number";
	public static final String SUB_CODE_FIELD_NAME = "sub_code";
	public static final String CUSTOMER_PRODUCT_NUMBER_FIELD_NAME = "customer_product_number";
	public static final String SUB_BRAND_FIELD_NAME = "sub_brand";
	public static final String BRAND_NAME_FIELD_NAME = "brand_name";
	public static final String SALES_FIELD_NAME = "sales";
	public static final String SALES_NAME_FIELD_NAME = "sales_name";
	public static final String SAMPLE_AGPO_FIELD_NAME = "sample_agpo";
	public static final String SAMPLE_CUSTOMER_ID_FIELD_NAME = "sample_customer_id";
	public static final String FACTORY_NAME_FIELD_NAME = "factory_name";
	public static final String PRODUCT_GROUP_FIELD_NAME = "product_group";
	public static final String PRICE_FIELD_NAME = "price";
	public static final String CURRENCY_NAME_FIELD_NAME = "currency_name";
	public static final String MINIMUM_ORDER_QUANTITY_FIELD_NAME = "minimum_order_quantity";
	public static final String UNIT_NAME_FIELD_NAME = "unit_name";
	public static final String COLOR_FIELD_NAME = "color";
	public static final String SIZE_FIELD_NAME = "size";
	public static final String COO_FIELD_NAME = "coo";
	public static final String CONTENT_FIELD_NAME = "content";
	public static final String STYLE_NUMBER_FIELD_NAME = "style_number";
	public static final String OTHERS_FIELD_NAME = "others";
	public static final String ATTRIBUTE_6_FIELD_NAME = "attribute6";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String CREATE_SOURCE_FIELD_NAME = "create_source";
	public static final String SAMPLE_COMMENT_FIELD_NAME = "sample_comment";
	public static final String SAMPLE_COMMENT_TIME_FIELD_NAME = "sample_comment_time";
	public static final String ART_PRODUCT_FIELD_NAME = "art_product";
	
	@DatabaseField(
			columnName = "MaterialHdrID", 
			canBeNull = false, 
			foreign = true)
	@SerializedName(MATERIAL_HEADER_FIELD_NAME)
	@Expose
	private MaterialHdr materialHeader;

	@DatabaseField(
			columnName = "MaterialID", 
			canBeNull = false,
			id = true)
	@SerializedName(MATERIAL_ID_FIELD_NAME)
	@Expose
	private Long materialID;

	@DatabaseField(
			columnName = "ProductNO", 
			canBeNull = false)
	@SerializedName(PRODUCT_NUMBER_FIELD_NAME)
	@Expose
	private String productNumber;

	@DatabaseField(
			columnName = "SubCode", 
			canBeNull = false)
	@SerializedName(SUB_CODE_FIELD_NAME)
	@Expose
	private String subCode;

	@DatabaseField(
			columnName = "CustormerProductNo", 
			canBeNull = true)
	@SerializedName(CUSTOMER_PRODUCT_NUMBER_FIELD_NAME)
	@Expose
	private String customerProductNumber;

	@DatabaseField(
			columnName = "SubBrandID", 
			canBeNull = true, 
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
			canBeNull = true, 
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
	private String sampleAqpo;

	@DatabaseField(
			columnName = "SampleCustomerID", 
			canBeNull = true)
	@SerializedName(SAMPLE_CUSTOMER_ID_FIELD_NAME)
	@Expose
	private Long sampleCustomerID;

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
	private String minimumOrderQuantity;
	
	@DatabaseField(
			columnName = "UnitName", 
			canBeNull = true)
	@SerializedName(UNIT_NAME_FIELD_NAME)
	@Expose
	private String unitName;
	
	@DatabaseField(
			columnName = "Attribute0", 
			canBeNull = true)
	@SerializedName(COLOR_FIELD_NAME)
	@Expose
	private String color;
	
	@DatabaseField(
			columnName = "Attribute1", 
			canBeNull = true)
	@SerializedName(SIZE_FIELD_NAME)
	@Expose
	private String size;
	
	@DatabaseField(
			columnName = "Attribute2", 
			canBeNull = true)
	@SerializedName(COO_FIELD_NAME)
	@Expose
	private String coo;
	
	@DatabaseField(
			columnName = "Attribute3", 
			canBeNull = true)
	@SerializedName(CONTENT_FIELD_NAME)
	@Expose
	private String content;
	
	@DatabaseField(
			columnName = "Attribute4", 
			canBeNull = true)
	@SerializedName(STYLE_NUMBER_FIELD_NAME)
	@Expose
	private String styleNumber;
	
	@DatabaseField(
			columnName = "Attribute5", 
			canBeNull = true)
	@SerializedName(OTHERS_FIELD_NAME)
	@Expose
	private String others;
	
	@DatabaseField(
			columnName = "Attribute6", 
			canBeNull = true)
	@SerializedName(ATTRIBUTE_6_FIELD_NAME)
	@Expose
	private String attribute6;
	
	@DatabaseField(
			columnName = "CreateTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATE_TIME_FIELD_NAME)
	@Expose
	private Date createTime;
	
	@DatabaseField(
			columnName = "CreateSource", 
			canBeNull = true)
	@SerializedName(CREATE_SOURCE_FIELD_NAME)
	@Expose
	private String createSource;
	
	@DatabaseField(
			columnName = "SampleComment", 
			canBeNull = true)
	@SerializedName(SAMPLE_COMMENT_FIELD_NAME)
	@Expose
	private String sampleComment;
	
	@DatabaseField(
			columnName = "SampleCommentTime", 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(SAMPLE_COMMENT_TIME_FIELD_NAME)
	@Expose
	private Date sampleCommentTime;
	
	@DatabaseField(
			columnName = "ArtProductID", 
			canBeNull = true)
	@SerializedName(ART_PRODUCT_FIELD_NAME)
	@Expose
	private Long artProduct;
	
	public ProductSubCodeInfo() {
	}
	
	@Override
	public Long getIdentity() {
		return materialID;
	}

	@Override
	public String getIdentityAttribute() {
		return MATERIAL_ID_FIELD_NAME;
	}
}