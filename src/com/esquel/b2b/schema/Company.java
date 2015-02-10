/** 
 * Company.java
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

import java.sql.SQLException;
import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.BlobDatabaseField;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;

@DatabaseTable(tableName = "companies")
public class Company extends Model<Company, String> implements Identity<String> {
	
	/** Default values of a company. */
	public static final int DEFAULT_USER_QUOTA = 10;

	/** For queries. */
	public static final String ID_FIELD_NAME = "company_id";
	public static final String COMPANY_NAME_FIELD_NAME = "company_name";
	public static final String COMPANY_TYPE_FIELD_NAME = "company_type";
	public static final String LOGO_URL_FIELD_NAME = "logo_url";
	public static final String DOMAIN_FIELD_NAME = "domain";
	public static final String ENFORCE_DOMAIN_FIELD_NAME = "enforce_domain";
	public static final String USER_QUOTA_FIELD_NAME = "user_quota";
	public static final String STATUS_FIELD_NAME = "status";
	public static final String EAPMIS_BRAND_ID_FIELD_NAME = "eapmis_brand_id";
	public static final String EAPMIS_VENDOR_ID_FIELD_NAME = "eapmis_vendor_id";
	public static final String EAPMIS_LAST_MODIFIED_DATE = "eapmis_lastmoddate";
	
	public static final String COMPANY_FILE_FIELD_NAME = "company_files";
	public static final String COMPANY_FOLDER_FIELD_NAME = "company_folders";
	public static final String REQUESTS_FIELD_NAME = "requests";
	public static final String LANGUAGES_FIELD_NAME = "languages";
	public static final String VARIABLES_FIELD_NAME = "variables";
	public static final String PRODUCT_LINK_FILE_FIELD_NAME = "link_files";
	public static final String PRODUCT_FIELD_NAME = "products";
	public static final String ORDER_FIELD_NAME = "orders";
	public static final String USERS_FIELD_NAME = "users";
	
	/** An enum of the status of a company */
	public enum Status {
		
		ACTIVE(1),
		
		INACTIVE(0);
		
		private int value;
		
		private Status(int val) {
			value = val;
		}
		
		/**
		 * Returns the underlying value of the enumeration type
		 * 
		 * @return the underlying value of the enumeration type
		 */
		public int getValue() {
			return value;
		}
		
		/**
		 * Returns the enum constant of the specified enum type with the value
		 * 
		 * @param val the value of the constant to return
		 * @return the enum constant of the specified enum type with the specified value
		 * @throws thrown if the specified enum type has no constant with the specified value, or the specified class object does not represent an enum type
		 */
		public static Status fromString(int val) {
			for (Status b : Status.values()) {
				if (val == b.value) {
					return b;
				}
			}
			throw new IllegalArgumentException();
		}
		
	}
	
	/** An enum of different company types. */
	public enum Type {
		
		EAP("ESQUEL"),
		
		VENDOR("VENDOR"),
		
		BRAND("BRAND");
		
		private String value;
		
		private Type(String val) {
			value = val;
		}
				
		/**
		 * Returns the underlying value of the enumeration type
		 * 
		 * @return the underlying value of the enumeration type
		 */
		public String getValue() {
			return value;
		}
		
		/**
		 * Returns the enum constant of the specified enum type with the value
		 * 
		 * @param val the value of the constant to return
		 * @return the enum constant of the specified enum type with the specified value
		 * @throws thrown if the specified enum type has no constant with the specified value, or the specified class object does not represent an enum type
		 */
		public static Type fromString(String val) {
			if (val != null) {
				for (Type b : Type.values()) {
					if (val.equalsIgnoreCase(b.value)) {
						return b;
					}
				}
			}
			throw new IllegalArgumentException();
		}
		
	}

	@DatabaseField(
			columnName = ID_FIELD_NAME,
			canBeNull = false, 
			generatedId = true,
			allowGeneratedIdInsert = true, 
			persisterClass = com.esquel.b2b.persister.MsSqlUuidType.class)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private String id;
	
	@ForeignCollectionField(eager = true)
	@SerializedName(ORDER_FIELD_NAME)
	@Expose
	private ForeignCollection<Order> orders;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_FIELD_NAME)
	@Expose
	private ForeignCollection<Product> products;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_LINK_FILE_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductLinkFile> productLinkFile;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(COMPANY_FOLDER_FIELD_NAME)
	@Expose
	private ForeignCollection<CompanyFolder> companyFolder;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(COMPANY_FILE_FIELD_NAME)
	@Expose
	private ForeignCollection<CompanyFile> companyFile;

	@ForeignCollectionField(eager = false)
	@SerializedName(VARIABLES_FIELD_NAME)
	@Expose
	private ForeignCollection<CompanyVariable> variables;

	@ForeignCollectionField(eager = false)
	@SerializedName(LANGUAGES_FIELD_NAME)
	@Expose
	private ForeignCollection<CompanyLanguage> languages;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(REQUESTS_FIELD_NAME)
	@Expose
	private ForeignCollection<SignUpRequest> requests;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(USERS_FIELD_NAME)
	@Expose
	private ForeignCollection<User> users;
	
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
			columnName = COMPANY_TYPE_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(COMPANY_TYPE_FIELD_NAME)
	@Expose
	private String companyType;
	
	@DatabaseField(columnName = COMPANY_NAME_FIELD_NAME)
	@SerializedName(COMPANY_NAME_FIELD_NAME)
	@Expose
	private String companyName;

	@DatabaseField(
			columnName = LOGO_URL_FIELD_NAME, 
			canBeNull = true)
	@BlobDatabaseField(baseURI = "logos")
	@SerializedName(LOGO_URL_FIELD_NAME)
	@Expose
	private String url;

	@DatabaseField(columnName = DOMAIN_FIELD_NAME)
	@SerializedName(DOMAIN_FIELD_NAME)
	@Expose
	private String domain;
	
	@DatabaseField(columnName = ENFORCE_DOMAIN_FIELD_NAME)
	@SerializedName(ENFORCE_DOMAIN_FIELD_NAME)
	@Expose
	private boolean enforceDomain;

	@DatabaseField(
			columnName = USER_QUOTA_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(USER_QUOTA_FIELD_NAME)
	@Expose
	private int userQuota;
	
	@DatabaseField(columnName = STATUS_FIELD_NAME,
			canBeNull = false)
	@SerializedName(STATUS_FIELD_NAME)
	@Expose
	private Integer status;
	
	@DatabaseField(columnName = EAPMIS_LAST_MODIFIED_DATE)
	@SerializedName(EAPMIS_LAST_MODIFIED_DATE)
	private Date eapLastModifiedDate;

	@DatabaseField(
			columnName = EAPMIS_BRAND_ID_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(EAPMIS_BRAND_ID_FIELD_NAME)
	@Expose
	private Integer brandId;

	@DatabaseField(
			columnName = EAPMIS_VENDOR_ID_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(EAPMIS_VENDOR_ID_FIELD_NAME)
	@Expose
	private Integer vendorId;

	Company() {

	}

	@Override
	public String getIdentity() {
		return id;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
	
	/**
	 * Returns the URL to the remote resource that references the logo of this company 
	 * 
	 * @return URL to the remote resource that references the logo of this company
	 */
	public String getLogoUrl() {
		return url;
	}
	
	/**
	 * Specifies the URL to the remote resource that references the logo of this company 
	 * 
	 * @param url the new URL of the remote resource that references the logo of this company
	 */
	public void setLogoUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Returns the date this company was last modified in EAP
	 * 
	 * @return the date this company was last modified in EAP
	 */
	public Date getEapLastModifiedDate() {
		return eapLastModifiedDate;
	}
	
	/**
	 * Specifies the date the company was last modified in EAP 
	 * 
	 * @param newDate the new date the company was last modified in EAP
	 */
	public void setEapLastModifiedDate(Date newDate) {
		eapLastModifiedDate = newDate;
	}
	
	/**
	 * Returns the maximum number of users this company can have
	 * 
	 * @return the maximum number of users this company can have
	 */
	public int getUserQuota() {
		return userQuota;
	}

	/**
	 * Specifies a new quota on the maximum number of users this company can have
	 * 
	 * @param userQuota a new maximum number of users this company can have
	 */
	public void setUserQuota(int userQuota) {
		this.userQuota = userQuota;
	}

	/**
	 * Returns whether users in the given company must have username that has the same domain as this company 
	 * 
	 * @return {@code true} to enforce the domain name, {@code false} otherwise
	 */
	public boolean isEnforceDomain() {
		return enforceDomain;
	}

	/**
	 * Specifies whether users in this company must have user name that conform to the domain name of this company
	 * 
	 * @param enforceDomain {@code true} to force all credentials in this company to conform to the domain name of this company, {@code false} otherwise
	 */
	public void setEnforceDomain(boolean enforceDomain) {
		this.enforceDomain = enforceDomain;
	}
	
	/**
	 * Returns the domain name of this company
	 * 
	 * @return the domain name of this company
	 */
	public String getDomain() {
		return domain;
	}
	
	/**
	 * Specifies a new domain name for this company
	 * 
	 * @param domain the new domain name
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	/**
	 * Specifies the new status of the company 
	 * 
	 * @param status the new status
	 */
	public void setStatus(Status status) {
		if (status != null) {
			this.status = status.getValue();
		}
	}

	/**
	 * Returns the type of this company 
	 * 
	 * @return the type of this company
	 */
	public Type getType() {
		if (companyType != null) {			
			return Type.valueOf(companyType);
		}
		throw new IllegalArgumentException();
	}
	
	/**
	 * Returns the type of the company
	 * 
	 * @return the type of the company
	 */
	public String getCompanyType() {
		return companyType;
	}
	
	/**
	 * Specifies the type of this company
	 * 
	 * @param type the new type of this company
	 */
	public void setType(Type type) {
		companyType = type == null ? null : type.getValue();
	}

	/**
	 * Specifies a type of this company
	 * 
	 * @param companyType the new type of this company
	 */
	public void setCompanyType(String companyType) throws SQLException {
		this.companyType = companyType;
	}
	
	/**
	 * Returns the unique identifier of the brand
	 * 
	 * @return the unique identifier of the brand
	 */
	public Integer getBrandId() {
		return brandId;
	}

	/**
	 * Sets the unique identifier of the brand
	 * 
	 * @param brandId the new unique identifier of the brand
	 */
	public void setBrandId(Integer brandId) throws SQLException {
		this.brandId = brandId;
	}
	
	/**
	 * Specifies a new EAP sub-brand identifier
	 * 
	 * @param subBrandId an unique EAP sub-brand identifier
	 */
	public void setSubBrandId(Long subBrandId) {
		brandId = subBrandId == null ? null : subBrandId.intValue();
	}
	
	/**
	 * Specifies the new identifier of the vendor 
	 * 
	 * @param customerId the identifier of the vendor
	 */
	public void setCustomerId(Long customerId) {
		vendorId = customerId == null ? null : customerId.intValue();
	}

	/**
	 * Returns the unique identifier of the vendor
	 * 
	 * @return the unique identifier of the vendor
	 */
	public Integer getVendorId() {
		return vendorId;
	}

	/**
	 * Sets a new unique identifier of the vendor
	 * 
	 * @param vendorId the unique identifier of the vendor
	 */
	public void setVendorId(Integer vendorId) throws SQLException {
		this.vendorId = vendorId;
	}
	
	/**
	 * Specifies the new name of the {@link Company}
	 * 
	 * @param companyName the new name of the company
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
