package com.esquel.b2b.schema;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "uvw_b2bProductPicture")
public class ProductPicture extends Model<ProductPicture, Long> implements Identity<Long> {
	
	public static final String MATERIAL_HEADER_ID_FIELD_NAME = "material_header_id";
	public static final String PRODUCT_NUMBER_FIELD_NAME = "product_number";
	public static final String SUB_CODE_FIELD_NAME = "sub_code";
	public static final String ART_CODE_FIELD_NAME = "art_code";
	public static final String ART_PRODUCT_FIELD_NAME = "art_product";
	public static final String PICTURE_IMAGE_FIELD_NAME = "picture_image";
	public static final String PICTURE_DESCRIPTION_FIELD_NAME = "picture_description";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	
	@DatabaseField(
			columnName = "MaterialHdrID", 
			canBeNull = false)
	@SerializedName(MATERIAL_HEADER_ID_FIELD_NAME)
	@Expose
	private Long materialHeaderID;

	@DatabaseField(
			columnName = "ProductNO", 
			canBeNull = false)
	@SerializedName(PRODUCT_NUMBER_FIELD_NAME)
	@Expose
	private String productNumber;
	
	@DatabaseField(
			columnName = "SubCode", 
			canBeNull = true)
	@SerializedName(SUB_CODE_FIELD_NAME)
	@Expose
	private String subCode;
	
	@DatabaseField(
			columnName = "ArtCode", 
			canBeNull = true)
	@SerializedName(ART_CODE_FIELD_NAME)
	@Expose
	private String artCode;
	
	@DatabaseField(
			columnName = "ArtProductID", 
			canBeNull = false)
	@SerializedName(ART_PRODUCT_FIELD_NAME)
	@Expose
	private Long artProduct;
	
	@DatabaseField(
			columnName = "PictureImage", 
			canBeNull = true,
			dataType = DataType.BYTE_ARRAY)
	@SerializedName(PICTURE_IMAGE_FIELD_NAME)
	@Expose
	private byte[] pictureImage;
	
	@DatabaseField(
			columnName = "PictureDesc", 
			canBeNull = true)
	@SerializedName(PICTURE_DESCRIPTION_FIELD_NAME)
	@Expose
	private String pictureDescription;
	
	@DatabaseField(
			columnName = "LastModifyTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFY_TIME_FIELD_NAME)
	@Expose
	private Date lastModifyTime;
	
	public ProductPicture() {
	}
	
	@Override
	public Long getIdentity() {
		return materialHeaderID;
	}

	@Override
	public String getIdentityAttribute() {
		return MATERIAL_HEADER_ID_FIELD_NAME;
	}
	
	/**
	 * Returns the {@link Date} the product image was last modified 
	 * 
	 * @return the {@link Date} the product image was last modified
	 */
	public Date getLastModified() {
		return lastModifyTime;
	}
	
	/**
	 * Returns the image of this product 
	 * 
	 * @return the image data of this product
	 */
	public byte[] getImage() {
		return pictureImage;
	}
	
	/**
	 * Returns the EAP code of the product this picture refers to 
	 * 
	 * @return the EAP code of the product this picture refers to
	 */
	public String getProductNumber() {
		return productNumber;
	}
	
	/**
	 * Returns the EAP sub-code of the product this picture refers to
	 * 
	 * @return the EAP sub-code of the product this picture refers to
	 */
	public String getSubCode() {
		return subCode;
	}
	
}