/** 
 * Products.java
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

@DatabaseTable(tableName = "products")
public class Product extends Model<Product, String> implements Identity<String> {
	
	public static final String ID_FIELD_NAME = "product_id";
	
	public static final String COMPANY_FIELD_NAME = "company";
	public static final String ENABLED_FIELD_NAME = "enabled";
	public static final String SAMPLE_URL_FIELD_NAME = "sample_url";
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";	
	public static final String MATERIAL_HEADER_ID_FIELD_NAME = "material_header_id";	
	public static final String LAST_SUB_CODE_FIELD_NAME = "last_sub_code";
	public static final String GROUP_COUNT_FIELD_NAME = "group_count";
	
	public static final String PRODUCT_ATTACHMENTS_FIELD_NAME = "product_attachments";
	public static final String PRODUCT_LINK_FILES_FIELD_NAME = "product_link_files";
	public static final String PRODUCT_TAGS_FIELD_NAME = "product_tags";
	public static final String PRODUCT_TEMPLATES_FIELD_NAME = "product_templates";
	public static final String SUB_PRODUCTS_FIELD_NAME = "sub_products";
	
	
	
	
	@DatabaseField(
			columnName = ID_FIELD_NAME, 
			canBeNull = false, 
			generatedId = true, 
			allowGeneratedIdInsert = true, 
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private String id;
	
	
	@DatabaseField(
			columnName = COMPANY_FIELD_NAME + "_id", 
			canBeNull = true,
			foreign = true)
	@SerializedName(COMPANY_FIELD_NAME)
	@Expose
	private Company company;
	
	
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
	
	
	@DatabaseField(
			columnName = ENABLED_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(ENABLED_FIELD_NAME)
	@Expose
	private boolean enabled;
	
	
	@DatabaseField(
			columnName = SAMPLE_URL_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(SAMPLE_URL_FIELD_NAME)
	@Expose
	private String url;
	
	
	@DatabaseField(
			columnName = CREATED_BY_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(CREATED_BY_FIELD_NAME)
	@Expose
	private String createdBy;
	
	
	@DatabaseField(
			columnName = MODIFIED_BY_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(MODIFIED_BY_FIELD_NAME)
	@Expose
	private String modifiedBy;
	
	
	@DatabaseField(
			columnName = "MaterialHdrID", 
			canBeNull = true)
	@SerializedName(MATERIAL_HEADER_ID_FIELD_NAME)
	@Expose
	private Long materialHeaderID;
	
	
	@DatabaseField(
			columnName = LAST_SUB_CODE_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(LAST_SUB_CODE_FIELD_NAME)
	@Expose
	private Long lastSubCode;
	
	
	@DatabaseField(
			columnName = GROUP_COUNT_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(GROUP_COUNT_FIELD_NAME)
	@Expose
	private Long groupCount;
	
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_ATTACHMENTS_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductAttachment> productAttachments;
	
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_LINK_FILES_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductLinkFile> productLinkFiles;
	
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_TAGS_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductTag> productTags;
	
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_TEMPLATES_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductTemplate> productTemplates;
	
	
	@ForeignCollectionField(eager = false)
	@SerializedName(SUB_PRODUCTS_FIELD_NAME)
	@Expose
	private ForeignCollection<SubProduct> subProducts;
	
	
	
	
	
	public Product() {
		
	}
	
	
	@Override
	public String getIdentity() {
		return id;
	}
	

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}

	
	public Company getCompany() {
		return company;
	}
	
	
	public ForeignCollection<ProductAttachment> getProductAttachments() {
		return productAttachments;
	}
	
	
	public ForeignCollection<ProductLinkFile> getProductLinkFiles() {
		return productLinkFiles;
	}
	
	public ForeignCollection<ProductTag> getProductTags() {
		return productTags;
	}
	
	
	public ForeignCollection<ProductTemplate> getProductTemplates() {
		return productTemplates;
	}
	
	
	public ForeignCollection<SubProduct> getSubProducts() {
		return subProducts;
	}
}
