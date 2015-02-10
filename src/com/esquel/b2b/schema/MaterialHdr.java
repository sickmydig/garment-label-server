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

@DatabaseTable(tableName = "mmMaterialHdr")
public class MaterialHdr extends Model<MaterialHdr, Integer> implements Identity<Integer> {

	public static final String LOT_CONTROL_TYPE_FIELD_NAME = "lot_control_type";
	public static final String MOQ_FIELD_NAME = "moq";
	public static final String ALLOW_PRODUCT_FIELD_NAME = "allow_product";
	public static final String ALLOW_PURCHASE_FIELD_NAME = "allow_purchase";
	public static final String CONVERT_RATE_FIELD_NAME = "convert_rate";
	public static final String PURCHASE_UNIT_FIELD_NAME = "purchase_unit";
	public static final String STORE_UNIT_ID_FIELD_NAME = "store_unit_id";
	public static final String PRODUCT_ELEMENT_FIELD_NAME = "product_element";
	public static final String CIQ_TYPE_FIELD_NAME = "ciq_type";
	public static final String FACTORY_ID_FIELD_NAME = "factory_id";
	public static final String MATERIAL_CLASS_FIELD_NAME = "master_class";
	public static final String MATERIAL_NAME_FIELD_NAME = "material_name";
	public static final String MATERIAL_CODE_FIELD_NAME = "material_code";
	public static final String PRODUCT_FIELD_NAME = "product";
	public static final String IS_BUY_FIELD_NAME = "is_buy";
	public static final String SWITCH_WARE_HOUSE_ID_FIELD_NAME = "switch_ware_house_id";
	public static final String NEW_MATERIAL_CODE_FIELD_NAME = "new_material_code";
	public static final String THICKNESS_UNIT_ID_FIELD_NAME = "thickness_unit_id";
	public static final String SCALE_FIELD_NAME = "scale_id";
	public static final String ESCM_PURCHASE_TO_STORE_RATE_FIELD_NAME = "escm_purchase_to_store_rate";
	public static final String ESCMS_STORE_UNIT_ID_FIELD_NAME = "esccms_store_unit_id";
	public static final String PURCHASE_USER_ID_FIELD_NAME = "purchase_user_id";
	public static final String PRODUCT_COMBO_FIELD_NAME = "product_combo";
	public static final String PRODUCT_COLOR_FIELD_NAME = "product_color";
	public static final String PRODUCT_SOURCE_FIELD_NAME = "product_source";
	public static final String GMATERIAL_CLASS_ID_FIELD_NAME = "gmaterial_class_id";
	public static final String MATERIAL_TYPE_FIELD_NAME = "material_type";
	public static final String ART_MAKER_FIELD_NAME = "art_maker";
	public static final String ART_MAKER_ID_FIELD_NAME = "art_maker_id";
	public static final String AGPONO_FIELD_NAME = "agpono";
	public static final String SAMPLE_COMMENT_ID_FIELD_NAME = "sample_comment_id";
	public static final String SALES_ID_FIELD_NAME = "sales_id";
	public static final String SIZE_HOLE_CLASS_FIELD_NAME = "size_hole_class";
	public static final String THICKNESS_FIELD_NAME = "thickness";
	public static final String LWH_UNIT_ID_FIELD_NAME = "lwh_unit_id";
	public static final String HEIGHT_FIELD_NAME = "height";
	public static final String WIDTH_FIELD_NAME = "width";
	public static final String LENGTH_FIELD_NAME = "length";
	public static final String SUB_BRAND_ID_FIELD_NAME = "sub_brand_id";
	public static final String APPROVE_DATE_FIELD_NAME = "approve_date";
	public static final String SAMPLE_READY_FIELD_NAME = "sample_ready";
	public static final String SAMPLE_READY_DATE_FIELD_NAME = "sample_ready_date";
	public static final String UPLOAD_TIME_FIELD_NAME = "upload_time";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CUSTOMER_PRODUCT_NO_FIELD_NAME = "customer_product_no";
	public static final String CUSTOM_CLASS_ID_FIELD_NAME = "custom_class_id";
	public static final String PRODUCT_CLASS_ID_FIELD_NAME = "product_class_id";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String IS_VALID_FIELD_NAME = "is_valid";
	public static final String SUB_CODE_CUR_VALUE_FIELD_NAME = "sub_code_cur_value";
	public static final String OUT_WARE_HOUSE_ID_FIELD_NAME = "out_ware_house";
	public static final String DEFAULT_PURCHASE_WARE_HOUSE_ID_FIELD_NAME = "default_purchase_ware_house_id";
	public static final String SALE_INCREASE_FIELD_NAME = "sale_increase";
	public static final String MIN_SALE_QTY_FIELD_NAME = "min_sale_qty";
	public static final String PRODUCT_QTY_INCREASE_FIELD_NAME = "product_qty_increase";
	public static final String MIN_PRODUCT_QTY_FIELD_NAME = "min_product_qty";
	public static final String PURCHASE_INCREASE_FIELD_NAME = "purchase_increase";
	public static final String MIN_PURCHASE_QTY_TYPE_FIELD_NAME = "min_purchase_qty";
	public static final String MATERIAL_HDR_ID_FIELD_NAME = "material_hdr_id";
	
	public static final String PRODUCT_SUB_CODE_INFOS_FIELD_NAME = "product_sub_code_infos";
	
	@DatabaseField(
			columnName = "IsBuy", 
			canBeNull = true)
	@SerializedName(IS_BUY_FIELD_NAME)
	@Expose
	private Boolean isBuy;
	
	@DatabaseField(
			columnName = "SwitchWarehouseID", 
			canBeNull = true)
	@SerializedName(SWITCH_WARE_HOUSE_ID_FIELD_NAME)
	@Expose
	private Integer switchWareHouseId;
	
	@DatabaseField(
			columnName = "NewMateralCode", 
			canBeNull = true)
	@SerializedName(NEW_MATERIAL_CODE_FIELD_NAME)
	@Expose
	private String newMaterialCode;
	
	@DatabaseField(
			columnName = "ThicknessUnitID", 
			canBeNull = true)
	@SerializedName(THICKNESS_UNIT_ID_FIELD_NAME)
	@Expose
	private Integer thicknessUnitId;
	
	@DatabaseField(
			columnName = "Scale", 
			canBeNull = true)
	@SerializedName(SCALE_FIELD_NAME)
	@Expose
	private Integer scale;
	
	@DatabaseField(
			columnName = "ESCMPurchaseToStoreRate", 
			canBeNull = true)
	@SerializedName(ESCM_PURCHASE_TO_STORE_RATE_FIELD_NAME)
	@Expose
	private Integer escmPurchaseToStoreRate;
	
	@DatabaseField(
			columnName = "ESCMStoreUnitID", 
			canBeNull = true)
	@SerializedName(ESCMS_STORE_UNIT_ID_FIELD_NAME)
	@Expose
	private Integer escmStoreUnitId;
	
	@DatabaseField(
			columnName = "PurchaseUserID", 
			canBeNull = true)
	@SerializedName(PURCHASE_USER_ID_FIELD_NAME)
	@Expose
	private String purchaseUserId;
	
	@DatabaseField(
			columnName = "ProductCombo", 
			canBeNull = true)
	@SerializedName(PRODUCT_COMBO_FIELD_NAME)
	@Expose
	private String productCombo;
	
	@DatabaseField(
			columnName = "ProductColor", 
			canBeNull = true)
	@SerializedName(PRODUCT_COLOR_FIELD_NAME)
	@Expose
	private String productColor;
	
	@DatabaseField(
			columnName = "ProductSource", 
			canBeNull = true)
	@SerializedName(PRODUCT_SOURCE_FIELD_NAME)
	@Expose
	private String productSource;
	
	@DatabaseField(
			columnName = "GMaterialClassID", 
			canBeNull = true)
	@SerializedName(GMATERIAL_CLASS_ID_FIELD_NAME)
	@Expose
	private Integer gmaterialClassId;
	
	@DatabaseField(
			columnName = "MaterialType", 
			canBeNull = true)
	@SerializedName(MATERIAL_TYPE_FIELD_NAME)
	@Expose
	private String materialType;
	
	@DatabaseField(
			columnName = "ArtMaker", 
			canBeNull = true)
	@SerializedName(ART_MAKER_FIELD_NAME)
	@Expose
	private String artMaker;
	
	@DatabaseField(
			columnName = "AGPONO", 
			canBeNull = true)
	@SerializedName(AGPONO_FIELD_NAME)
	@Expose
	private String agpono;
	
	@DatabaseField(
			columnName = "SampleCommentID", 
			canBeNull = true)
	@SerializedName(SAMPLE_COMMENT_ID_FIELD_NAME)
	@Expose
	private Integer sampleCommentId;
	
	@DatabaseField(
			columnName = "SalesID", 
			canBeNull = true)
	@SerializedName(SALES_ID_FIELD_NAME)
	@Expose
	private Integer salesID;
	
	@DatabaseField(
			columnName = "SizeHoleClass", 
			canBeNull = true)
	@SerializedName(SIZE_HOLE_CLASS_FIELD_NAME)
	@Expose
	private String sizeHoleClass;
	
	@DatabaseField(
			columnName = "Thickness", 
			canBeNull = true)
	@SerializedName(THICKNESS_FIELD_NAME)
	@Expose
	private Float thickness;
	
	@DatabaseField(
			columnName = "LWHUnitID", 
			canBeNull = true)
	@SerializedName(LWH_UNIT_ID_FIELD_NAME)
	@Expose
	private Integer lwhUnitId;
	
	@DatabaseField(
			columnName = "Height", 
			canBeNull = true)
	@SerializedName(HEIGHT_FIELD_NAME)
	@Expose
	private Float height;
	
	@DatabaseField(
			columnName = "Width", 
			canBeNull = true)
	@SerializedName(WIDTH_FIELD_NAME)
	@Expose
	private Float width;
	
	@DatabaseField(
			columnName = "Length", 
			canBeNull = true)
	@SerializedName(LENGTH_FIELD_NAME)
	@Expose
	private Float length;
	
	@DatabaseField(
			columnName = "SubBrandID", 
			canBeNull = true)
	@SerializedName(SUB_BRAND_ID_FIELD_NAME)
	@Expose
	private Integer subBrandId;
	
	@DatabaseField(
			columnName = "ApproveDate", 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(APPROVE_DATE_FIELD_NAME)
	@Expose
	private Date approveDate;
	
	@DatabaseField(
			columnName = "SampleReadyDate", 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(SAMPLE_READY_DATE_FIELD_NAME)
	@Expose
	private Date sampleReadyDate;
	
	@DatabaseField(
			columnName = "UploadTime", 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(UPLOAD_TIME_FIELD_NAME)
	@Expose
	private Date uploadTime;
	
	@DatabaseField(
			columnName = "LastModifyTime", 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFY_TIME_FIELD_NAME)
	@Expose
	private Date lastModifyTime;
	
	@DatabaseField(
			columnName = "LastModifyBy", 
			canBeNull = true)
	@SerializedName(LAST_MODIFY_BY_FIELD_NAME)
	@Expose
	private String lastModifyBy;
	
	@DatabaseField(
			columnName = "CreateTime", 
			canBeNull = true, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATE_TIME_FIELD_NAME)
	@Expose
	private Date createTime;
	
	@DatabaseField(
			columnName = "CreateTime", 
			canBeNull = false)
	@SerializedName(LOT_CONTROL_TYPE_FIELD_NAME)
	@Expose
	private Integer lotControlType;
	
	@DatabaseField(
			columnName = "CreateBy", 
			canBeNull = true)
	@SerializedName(CREATE_BY_FIELD_NAME)
	@Expose
	private String createBy;
	
	@DatabaseField(
			columnName = "ArtMakerID", 
			canBeNull = true)
	@SerializedName(ART_MAKER_ID_FIELD_NAME)
	@Expose
	private Integer artMakerId;
	
	@DatabaseField(
			columnName = "CustormerProductNo", 
			canBeNull = true)
	@SerializedName(CUSTOMER_PRODUCT_NO_FIELD_NAME)
	@Expose
	private String customerProductNo;
	
	@DatabaseField(
			columnName = "CustomsClassID", 
			canBeNull = true)
	@SerializedName(CUSTOM_CLASS_ID_FIELD_NAME)
	@Expose
	private Integer customClassId;
	
	@DatabaseField(
			columnName = "ProductClassID", 
			canBeNull = true)
	@SerializedName(PRODUCT_CLASS_ID_FIELD_NAME)
	@Expose
	private Integer productClassId;
	
	@DatabaseField(
			columnName = "Remark", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
	@DatabaseField(
			columnName = "IsValid", 
			canBeNull = false)
	@SerializedName(IS_VALID_FIELD_NAME)
	@Expose
	private Boolean isValid;
	
	@DatabaseField(
			columnName = "SubCodeCurValue", 
			canBeNull = true)
	@SerializedName(SUB_CODE_CUR_VALUE_FIELD_NAME)
	@Expose
	private Integer subCodeCurValue;
	
	@DatabaseField(
			columnName = "OutWarehouseID", 
			canBeNull = true)
	@SerializedName(OUT_WARE_HOUSE_ID_FIELD_NAME)
	@Expose
	private Integer outWareHouseId;
	
	@DatabaseField(
			columnName = "DefaultPurchaseWarehouseID", 
			canBeNull = true)
	@SerializedName(DEFAULT_PURCHASE_WARE_HOUSE_ID_FIELD_NAME)
	@Expose
	private Integer defaultPurchaseWareHouseId;
	
	@DatabaseField(
			columnName = "SaleIncrease", 
			canBeNull = true)
	@SerializedName(SALE_INCREASE_FIELD_NAME)
	@Expose
	private Integer saleIncrease;
	
	@DatabaseField(
			columnName = "MinSaleQty", 
			canBeNull = true)
	@SerializedName(MIN_SALE_QTY_FIELD_NAME)
	@Expose
	private Integer minSaleQty;
	
	@DatabaseField(
			columnName = "ProductQtyIncrease", 
			canBeNull = true)
	@SerializedName(PRODUCT_QTY_INCREASE_FIELD_NAME)
	@Expose
	private Integer productQtyIncrease;
	
	@DatabaseField(
			columnName = "MinProductQty", 
			canBeNull = true)
	@SerializedName(MIN_PRODUCT_QTY_FIELD_NAME)
	@Expose
	private Integer minProductQty;
	
	@DatabaseField(
			columnName = "PurchaseIncrease", 
			canBeNull = true)
	@SerializedName(PURCHASE_INCREASE_FIELD_NAME)
	@Expose
	private Integer purchaseIncrease;
	
	@DatabaseField(
			columnName = "MinPurchaseQty", 
			canBeNull = true)
	@SerializedName(MIN_PURCHASE_QTY_TYPE_FIELD_NAME)
	@Expose
	private Integer minPurchaseQty;

	@DatabaseField(
			columnName = "MOQ", 
			canBeNull = true)
	@SerializedName(MOQ_FIELD_NAME)
	@Expose
	private String moq;
	
	@DatabaseField(
			columnName = "AllowProduct", 
			canBeNull = true)
	@SerializedName(ALLOW_PRODUCT_FIELD_NAME)
	@Expose
	private Boolean allowProduct;
	
	@DatabaseField(
			columnName = "AllowPurchase", 
			canBeNull = true)
	@SerializedName(ALLOW_PURCHASE_FIELD_NAME)
	@Expose
	private Boolean allowPurchase;
	
	@DatabaseField(
			columnName = "ConvertRate", 
			canBeNull = true)
	@SerializedName(CONVERT_RATE_FIELD_NAME)
	@Expose
	private Integer convertRate;
	
	@DatabaseField(
			columnName = "PurchaseUnitID", 
			canBeNull = true)
	@SerializedName(PURCHASE_UNIT_FIELD_NAME)
	@Expose
	private Integer purchaseUnitId;
	
	@DatabaseField(
			columnName = "StoreUnitID", 
			canBeNull = true)
	@SerializedName(STORE_UNIT_ID_FIELD_NAME)
	@Expose
	private Integer storeUnitId;
	
	@DatabaseField(
			columnName = "ProductElement", 
			canBeNull = true)
	@SerializedName(PRODUCT_ELEMENT_FIELD_NAME)
	@Expose
	private String productElement;
	
	@DatabaseField(
			columnName = "CIQType", 
			canBeNull = true)
	@SerializedName(CIQ_TYPE_FIELD_NAME)
	@Expose
	private Integer ciqType;
	
	@DatabaseField(
			columnName = "FactoryID", 
			canBeNull = true)
	@SerializedName(FACTORY_ID_FIELD_NAME)
	@Expose
	private Integer factoryId;
	
	@DatabaseField(columnName = "MaterialClassID",
					canBeNull = false)
	@SerializedName(MATERIAL_CLASS_FIELD_NAME)
	@Expose
	private Integer materialClassId;
	
	@DatabaseField(
			columnName = "MaterialName", 
			canBeNull = true)
	@SerializedName(MATERIAL_NAME_FIELD_NAME)
	@Expose
	private String materialName;

	@DatabaseField(
			columnName = "MaterialCode", 
			canBeNull = false)
	@SerializedName(MATERIAL_CODE_FIELD_NAME)
	@Expose
	private String materialCode;
	
	@DatabaseField(
			columnName = "MaterialHdrID", 
			canBeNull = false,
			id = true)
	@SerializedName(MATERIAL_HDR_ID_FIELD_NAME)
	@Expose
	private Long materialHdrID;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_SUB_CODE_INFOS_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductSubCodeInfo> productSubCodeInfos;
	
	public MaterialHdr() {
	}
	
	@Override
	public Integer getIdentity() {
		return null;
	}

	@Override
	public String getIdentityAttribute() {
		return null;
	}
}