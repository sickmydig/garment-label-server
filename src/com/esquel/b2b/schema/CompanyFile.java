/** 
 * CompanyFiles.java
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
import com.joyaether.datastore.schema.BlobDatabaseField;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "company_files")
public class CompanyFile extends Model<CompanyFile, String> implements Identity<String> {

	public static final String COMPANY_FOLDER_FIELD_NAME = "company_folder";
	public static final String FILE_NAME_FIELD_NAME = "file_name";
	public static final String ID_FIELD_NAME = "company_file_id";
	public static final String FILE_URL_FIELD_NAME = "file_url";
	public static final String FILE_SIZE_FIELD_NAME = "file_size";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	public static final String COMPANY_FIELD_NAME = "company";

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
			columnName = COMPANY_FOLDER_FIELD_NAME + "_id",
			foreign = true)
	@SerializedName(COMPANY_FOLDER_FIELD_NAME)
	@Expose
	private CompanyFolder companyFolder;
	
	@DatabaseField(
			columnName = COMPANY_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(COMPANY_FIELD_NAME)
	@Expose
	private Company company;

	@DatabaseField(
			columnName = CREATED_DATE_FIELD_NAME, 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATED_DATE_FIELD_NAME)
	@Expose
	private Date createdDate;

	@DatabaseField(
			columnName = LAST_MODIFIED_DATE_FIELD_NAME, 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFIED_DATE_FIELD_NAME)
	@Expose
	private Date lastModifiedDate;

	@DatabaseField(
			columnName = FILE_URL_FIELD_NAME, 
			canBeNull = false)
	@BlobDatabaseField(baseURI = "files")
	@SerializedName(FILE_URL_FIELD_NAME)
	@Expose
	private String fileUrl;
	
	@DatabaseField(
			columnName = FILE_NAME_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(FILE_NAME_FIELD_NAME)
	@Expose
	private String fileName;

	@DatabaseField(
			columnName = FILE_SIZE_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(FILE_SIZE_FIELD_NAME)
	@Expose
	private Integer fileSize;

	@DatabaseField(
			columnName = MODIFIED_BY_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(MODIFIED_BY_FIELD_NAME)
	@Expose
	private String modifiedBy;

	@DatabaseField(
			columnName = CREATED_BY_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(CREATED_BY_FIELD_NAME)
	@Expose
	private String createdBy;

	CompanyFile() {

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
