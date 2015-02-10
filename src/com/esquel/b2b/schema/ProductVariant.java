/** 
 * ProductVariant.java
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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "UVW_B2BPrdouctVariantStruct")
public class ProductVariant extends Model<ProductVariant, Long> implements Identity<Long> {

	// For query
	public static final String ID_FIELD_NAME = "material_header_id";
	public static final String EAP_CODE_FIELD_NAME = "eap_code";
	public static final String VARIANT_FIELD_NAME = "variant";
	
	@DatabaseField(
			columnName = "MaterialHdrID",
			id = true,
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long materialHeaderId;
	
	@DatabaseField(columnName = "ProductNo")
	@SerializedName(EAP_CODE_FIELD_NAME)
	@Expose
	private String eapCode;
	
	@DatabaseField(columnName = "Variant")
	@SerializedName(VARIANT_FIELD_NAME)
	@Expose
	private String variant;
	
	ProductVariant() {
		// Must have an no-arg constructor
	}
	
	@Override
	public Long getIdentity() {
		return materialHeaderId;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}

}
