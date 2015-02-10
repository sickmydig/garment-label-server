/** 
 * SubBrand.java
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

@DatabaseTable(tableName = "dtSubBrandList")
public class SubBrand extends Model<SubBrand, Long> implements Identity<Long> {

	public static final String SUB_BRAND_ID_FIELD_NAME = "sub_brand_id";
	
	public static final String ID_FIELD_NAME = "iden";
	public static final String BRAND_FIELD_NAME = "brand";
	public static final String ORACLE_BRAND_ID_FIELD_NAME = "oracle_brand_id";
	public static final String BRAND_NAME_FIELD_NAME = "brand_name";
	public static final String REMARK_FIELD_NAME = "remark";
	public static final String MARKET_FIELD_NAME = "market";
	public static final String CREATE_BY_FIELD_NAME = "create_by";
	public static final String CREATE_TIME_FIELD_NAME = "create_time";
	public static final String LAST_MODIFY_BY_FIELD_NAME = "last_modify_by";
	public static final String LAST_MODIFY_TIME_FIELD_NAME = "last_modify_time";
	public static final String SALE_FIELD_NAME = "sale";
	public static final String SALES_TEAM_FIELD_NAME = "sales_team";
	public static final String MARKET_ID_FIELD_NAME = "market_id";
	public static final String SUB_MARKET_ID_FIELD_NAME = "sub_market_id";
	public static final String FOLLOWER_ID_FIELD_NAME = "follewer_id";
	public static final String IS_ACTIVE_FIELD_NAME = "is_active";
	public static final String CONTACT_PERSON_FIELD_NAME = "contact_person";
	public static final String TELEPHONE_FIELD_NAME = "telephone";
	public static final String MAIL_BOX_FIELD_NAME = "mail_box";
	public static final String ADDRESS_FIELD_NAME = "address";
	
	public static final String BRAND_CUSTOMERS_FIELD_NAME = "brand_customers";
	public static final String BRAND_REGIONAL_CONTACTS_FIELD_NAME = "brand_regional_contacts";
	public static final String BULK_ORDERS_FIELD_NAME = "bulk_orders";
	public static final String CUSTOMER_PRODUCTS_FIELD_NAME = "customer_products";
	public static final String PRODUCT_INFOS_FIELD_NAME = "product_infos";
	public static final String PRODUCT_SUB_CODE_INFOS_FIELD_NAME = "product_sub_code_infos";
	public static final String SUB_BRAND_CONTACTS_FIELD_NAME = "sub_brand_contacts";
		
	
	@DatabaseField(
			columnName = "SubBrandID", 
			canBeNull = false, 
			id = true)
	@SerializedName(SUB_BRAND_ID_FIELD_NAME)
	@Expose
	private Long subBrandID;
	
	@DatabaseField(
			columnName = ID_FIELD_NAME, 
			canBeNull = false)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private Long iden;
	
	@DatabaseField(
			columnName = "BrandID", 
			canBeNull = true, 
			foreign = true)
	@SerializedName(BRAND_FIELD_NAME)
	@Expose
	private Brand brand;
	
	@DatabaseField(
			columnName = "OracleBrandID", 
			canBeNull = true)
	@SerializedName(ORACLE_BRAND_ID_FIELD_NAME)
	@Expose
	private String oracleBrandID;
	
	@DatabaseField(
			columnName = "BrandName", 
			canBeNull = true)
	@SerializedName(BRAND_NAME_FIELD_NAME)
	@Expose
	private String brandName;
	
	@DatabaseField(
			columnName = "Remark", 
			canBeNull = true)
	@SerializedName(REMARK_FIELD_NAME)
	@Expose
	private String remark;
	
	@DatabaseField(
			columnName = "Market", 
			canBeNull = true)
	@SerializedName(MARKET_FIELD_NAME)
	@Expose
	private String market;
	
	@DatabaseField(
			columnName = "CreateBy", 
			canBeNull = true)
	@SerializedName(CREATE_BY_FIELD_NAME)
	@Expose
	private String createBy;
	
	@DatabaseField(
			columnName = "LastModifyTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(CREATE_TIME_FIELD_NAME)
	@Expose
	private Date createTime;
	
	@DatabaseField(
			columnName = "LastModifyBy", 
			canBeNull = true)
	@SerializedName(LAST_MODIFY_BY_FIELD_NAME)
	@Expose
	private String lastModifyBy;
	
	@DatabaseField(
			columnName = "LastModifyTime", 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_MODIFY_TIME_FIELD_NAME)
	@Expose
	private Date lastModifyTime;
	
	@DatabaseField(
			columnName = "SalesID", 
			canBeNull = true,
			foreign = true)
	@SerializedName(SALE_FIELD_NAME)
	@Expose
	private Sale sale;
	
	@DatabaseField(
			columnName = "SalesTeamID", 
			canBeNull = true,
			foreign = true)
	@SerializedName(SALES_TEAM_FIELD_NAME)
	@Expose
	private SalesTeam salesTeam;
	
	@DatabaseField(
			columnName = "MarketID", 
			canBeNull = true)
	@SerializedName(MARKET_ID_FIELD_NAME)
	@Expose
	private Long marketID;
	
	@DatabaseField(
			columnName = "SubMarketID", 
			canBeNull = true)
	@SerializedName(SUB_MARKET_ID_FIELD_NAME)
	@Expose
	private Long subMarketID;
	
	@DatabaseField(
			columnName = "FollowerID", 
			canBeNull = true)
	@SerializedName(FOLLOWER_ID_FIELD_NAME)
	@Expose
	private Long followerID;
	
	@DatabaseField(
			columnName = "IsActive", 
			canBeNull = false)
	@SerializedName(IS_ACTIVE_FIELD_NAME)
	@Expose
	private boolean isActive;

	@DatabaseField(
			columnName = "ContactPerson", 
			canBeNull = true)
	@SerializedName(CONTACT_PERSON_FIELD_NAME)
	@Expose
	private String contactPerson;
	
	@DatabaseField(
			columnName = "Telphone", 
			canBeNull = true)
	@SerializedName(TELEPHONE_FIELD_NAME)
	@Expose
	private String telephone;
	
	@DatabaseField(
			columnName = "MailBox", 
			canBeNull = true)
	@SerializedName(MAIL_BOX_FIELD_NAME)
	@Expose
	private String mailBox;
	
	@DatabaseField(
			columnName = "Address", 
			canBeNull = true)
	@SerializedName(ADDRESS_FIELD_NAME)
	@Expose
	private String address;
		
	@ForeignCollectionField(eager = false)
	@SerializedName(BRAND_CUSTOMERS_FIELD_NAME)
	@Expose
	private ForeignCollection<BrandCustomer> brandCustomers;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(BRAND_REGIONAL_CONTACTS_FIELD_NAME)
	@Expose
	private ForeignCollection<BrandRegionalContact> brandRegionalContacts;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(BULK_ORDERS_FIELD_NAME)
	@Expose
	private ForeignCollection<BulkOrder> bulkOrders;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(CUSTOMER_PRODUCTS_FIELD_NAME)
	@Expose
	private ForeignCollection<CustomerProduct> customerProducts;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_INFOS_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductInfo> productInfos;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(PRODUCT_SUB_CODE_INFOS_FIELD_NAME)
	@Expose
	private ForeignCollection<ProductSubCodeInfo> productSubCodeInfos;
	
	@ForeignCollectionField(eager = false)
	@SerializedName(SUB_BRAND_CONTACTS_FIELD_NAME)
	@Expose
	private ForeignCollection<SubBrandContact> subBrandContacts;
	
	
	public SubBrand() {
		// Must havea no-arg constructor
	}
	
	@Override
	public Long getIdentity() {
		return subBrandID;
	}

	@Override
	public String getIdentityAttribute() {
		return SUB_BRAND_ID_FIELD_NAME;
	}
	
	/**
	 * Returns a boolean that indicates whether or not this sub brand is active
	 * 
	 * @return {@code true} if this sub-brand is active, {@code false} otherwise
	 */
	public boolean isActive() {
		return isActive;
	}
	
	/**
	 * Converts this {@link Customer} into a {@link Company}
	 * 
	 * @return a {@link Company} representation of this customer
	 */
	public Company toCompany() {
		Company result = new Company();
		
		result.setType(Company.Type.BRAND);
		result.setSubBrandId(getIdentity());
		result.setCompanyName(getBrandName());
		result.setUserQuota(Company.DEFAULT_USER_QUOTA);
		result.setStatus(isActive ? Company.Status.ACTIVE : Company.Status.INACTIVE);
		
		return result;
	}
	
	/**
	 * Returns the {@link Date} this sub-brand was last modified in EAP 
	 * 
	 * @return the {@link Date} this sub-brand was last modified
	 */
	public Date getLastModified() {
		return lastModifyTime;
	}
	
	public String getBrandName() {
		return brandName;
	}

	public String getTelephone() {
		return telephone;
	}
	
	public ForeignCollection<BrandCustomer> getBrandCustomers() {
		return brandCustomers;
	}
	
	public ForeignCollection<ProductInfo> getProductInfos() {
		return productInfos;
	}
	
	public ForeignCollection<SubBrandContact> getSubBrandContacts() {
		return subBrandContacts;
	}
}
