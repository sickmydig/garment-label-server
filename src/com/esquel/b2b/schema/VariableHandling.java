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

@DatabaseTable(tableName = "variable_handlings")
public class VariableHandling extends Model<VariableHandling, String> implements Identity<String> {
	
	public static final String ID_FIELD_NAME = "variable_handling_id";
	public static final String DESCRIPTION_FIELD_NAME = "description";
	public static final String NAME_FIELD_NAME = "name";
	public static final String COMPANY_VARIABLE_FIELD_NAME = "company_variables";

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
			columnName = NAME_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(NAME_FIELD_NAME)
	@Expose
	private String name;
	
	@DatabaseField(
			columnName = DESCRIPTION_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(DESCRIPTION_FIELD_NAME)
	@Expose
	private String description;
	
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
	
	@ForeignCollectionField(eager = false)
	@SerializedName(COMPANY_VARIABLE_FIELD_NAME)
	@Expose
	private ForeignCollection<CompanyVariable> companyVariables;
	
	public ForeignCollection<CompanyVariable> getCompanyVariables() {
		return companyVariables;
	}

	VariableHandling() {
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
