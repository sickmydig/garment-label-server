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

@DatabaseTable(tableName = "company_folders")
public class CompanyFolder extends Model<CompanyFolder, String> implements Identity<String> {

	public static final String ID_FIELD_NAME = "company_folder_id";
	public static final String FOLDER_NAME_FIELD_NAME = "folder_name";
	public static final String MODIFIED_BY_FIELD_NAME = "modified_by";
	public static final String CREATED_BY_FIELD_NAME = "created_by";
	public static final String PARENT_FOLDER_FIELD_NAME = "parent_folder";
	public static final String COMPANY_FIELD_NAME = "company";
	public static final String CHILDREN_FOLDERS_FIELD_NAME = "children_folders";
	
	@DatabaseField(
			columnName = ID_FIELD_NAME,
			canBeNull = false, 
			generatedId = true,
			allowGeneratedIdInsert = true, 
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private String id;
	
	@DatabaseField(columnName = FOLDER_NAME_FIELD_NAME)
	@SerializedName(FOLDER_NAME_FIELD_NAME)
	@Expose
	private String folderName;
	
	@DatabaseField(columnName = CREATED_BY_FIELD_NAME)
	@SerializedName(CREATED_BY_FIELD_NAME)
	@Expose
	private String createdBy;
	
	@DatabaseField(columnName = MODIFIED_BY_FIELD_NAME)
	@SerializedName(MODIFIED_BY_FIELD_NAME)
	@Expose
	private String modifiedBy;
	
	@DatabaseField(
			columnName = PARENT_FOLDER_FIELD_NAME + "_id",
			foreign = true)
	@SerializedName(PARENT_FOLDER_FIELD_NAME)
	@Expose
	private CompanyFolder parentFolder;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(CHILDREN_FOLDERS_FIELD_NAME)
	@Expose
	private ForeignCollection<CompanyFolder> childrenFolders;

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

	CompanyFolder() {
		
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
