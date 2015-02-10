package com.esquel.b2b.schema;

import java.sql.SQLException;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Query;

@DatabaseTable(tableName = "dtBrandCustomer")
public class VendorBrand extends Model<VendorBrand, Long> implements Identity<Long> {

	public static final String BRAND_CUSTOMER_ID = "brand_customer_id";
	public static final String CUSTOMER_ID_FIELD_NAME = "customer_id";
	public static final String SUB_BRAND_ID_FIELD_NAME = "sub_brand_id";
	
	public static final String BRAND_ID_FIELD_NAME = "brand_id";
	public static final String BRAND_NAME_FIELD_NAME = "brand_name";
	public static final String SALE_NAME_FIELD_NAME = "sale_name";
	public static final String CONTACT_PERSON_FIELD_NAME = "contact_person";
	public static final String TELEPHONE_FIELD_NAME = "telephone";
	
	@DatabaseField(
			columnName = "BrandCustomerID", 
			canBeNull = true,
			id = true)
	@SerializedName(BRAND_CUSTOMER_ID)
	private Long brandCustomerID;
	
	@DatabaseField(
			columnName = "BrandID", 
			canBeNull = false,
			useGetSet = true)
	@SerializedName(BRAND_ID_FIELD_NAME)
	@Expose
	private Long brandId;
    
	@DatabaseField(
			columnName = "BrandName", 
			canBeNull = false,
			useGetSet = true)
	@SerializedName(BRAND_NAME_FIELD_NAME)
	private String brandName;
	
	@DatabaseField(
			columnName = "ContactPerson", 
			canBeNull = false,
			useGetSet = true)
	@SerializedName(CONTACT_PERSON_FIELD_NAME)
	private String contactPerson;
	
	@DatabaseField(
			columnName = "Telphone", 
			canBeNull = false,
			useGetSet = true)
	@SerializedName(TELEPHONE_FIELD_NAME)
	@Expose
	private String telephone;
	
	@SerializedName(CUSTOMER_ID_FIELD_NAME)
	@Expose
	private Long customerId;
	
	@SerializedName(SALE_NAME_FIELD_NAME)
	@Expose
	private String saleName;
	
	public void setSale(Long saleId) throws SQLException {
		if (getDao() != null) {
			Sale sale = Model.find(getDao().getConnectionSource(), Sale.class, saleId);
			if (sale != null) {
				saleName = sale.getSalesName();
			}
		}
	}
	
	public void setCustomer(Long customerId) {
		this.customerId = customerId;
	}
	
	public Long getBrandId() {
		return brandId;
	}
	
	public void setBrandId(Long brandId) throws SQLException {
		this.brandId = brandId;
		if (getDao() != null) {
			Query q = new Query();
			q.fieldIsEqualTo(SubBrand.BRAND_FIELD_NAME, brandId);
			CloseableWrappedIterable<SubBrand> iterables = Model.fetch(getDao().getConnectionSource(), SubBrand.class, q);
			CloseableIterator<SubBrand > iterator = iterables.closeableIterator();
			if (iterator != null) {
				if (iterator.hasNext()) {
					SubBrand sub = iterator.next();
					contactPerson = sub.getBrandName();
					telephone = sub.getTelephone();
				}				
			}
		}
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getSaleName() {
		return saleName;
	}
	
	@Override
	public Long getIdentity() {
		return brandCustomerID;
	}

	@Override
	public String getIdentityAttribute() {
		return BRAND_CUSTOMER_ID;
	}
}
