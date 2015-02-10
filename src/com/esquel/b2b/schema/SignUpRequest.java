/** 
 * SignUpRequests.java
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

import org.jasypt.util.password.StrongPasswordEncryptor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.joyaether.datastore.schema.Identity;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.PasswordField;
import com.joyaether.datastore.security.Role;

@DatabaseTable(tableName = "sign_up_requests")
public class SignUpRequest extends Model<SignUpRequest, String> implements Identity<String> {
	
	public static final String ID_FIELD_NAME = "username";	
	public static final String PASSWORD_FIELD_NAME = "password";
	public static final String STATUS_FIELD_NAME = "status";
	public static final String REJECT_REASON_FIELD_NAME = "reject_reason";
	public static final String DISPLAY_NAME_FIELD_NAME = "display_name";
	public static final String PHONE_FIELD_NAME = "phone";
	public static final String EMAIL_FIELD_NAME = "email";
	public static final String ADMIN_EMAIL_FIELD_NAME = "admin_email";
		
	public static final String COMPANY_FIELD_NAME = "company";
	
	/** An enum that represents the status of a sign up request. */
	public enum Status {
		
		/** The request is pending for approval. */
		PENDING,
		
		/** The request was approved. */
		APPROVED,
		
		/** The request was rejected. */
		REJECTED;
		
		/**
		 * Returns the enum constant of the specified enum type with the value
		 * 
		 * @param val the value of the constant to return
		 * @return the enum constant of the specified enum type with the specified value
		 * @throws thrown if the specified enum type has no constant with the specified value, or the specified class object does not represent an enum type
		 */
		public static Status valueOf(int val) {
			switch(val) {
			case 0:
				return PENDING;
			case 1:
				return APPROVED;
			case 2:
				return REJECTED;
			default:
				throw new IllegalArgumentException();
			}
		}
		
	}
		
	@DatabaseField(
			columnName = ID_FIELD_NAME, 
			canBeNull = false,
			id	= true)
	@SerializedName(ID_FIELD_NAME)
	@Expose
	private String username;
	
	@DatabaseField(
			columnName = COMPANY_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(COMPANY_FIELD_NAME)
	@Expose
	private Company company;
	
	@DatabaseField(
			columnName = PHONE_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(PHONE_FIELD_NAME)
	@Expose
	private String phone;
	
	@DatabaseField(
			columnName = DISPLAY_NAME_FIELD_NAME , 
			canBeNull = true)
	@SerializedName(DISPLAY_NAME_FIELD_NAME)
	@Expose
	private String displayName;
	
	@DatabaseField(
			columnName = EMAIL_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(EMAIL_FIELD_NAME)
	@Expose
	private String email;
	
	@DatabaseField(
			columnName = ADMIN_EMAIL_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(ADMIN_EMAIL_FIELD_NAME)
	@Expose
	private String adminEmail;
	
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
			columnName = STATUS_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(STATUS_FIELD_NAME)
	@Expose
	private int status;
	
	@DatabaseField(
			columnName = REJECT_REASON_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(REJECT_REASON_FIELD_NAME)
	@Expose
	private String rejectReason;
	
	@DatabaseField(
			columnName = PASSWORD_FIELD_NAME, 
			canBeNull = false)
	@PasswordField(
			encryptorClass = StrongPasswordEncryptor.class, 
			isTemporary = false, 
			encryptDeserialize = true)
	@SerializedName(PASSWORD_FIELD_NAME)
	@Expose
	private String password;
	
	SignUpRequest() {
		
	}
	
	/**
	 * Returns the email address of the administrator
	 * 
	 * @return email address of the administrator
	 */
	public String getAdministratorEmail() {
		return adminEmail;
	}
	
	/**
	 * Specifies a new company for this sign-up request
	 * 
	 * @param company the new company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	
	/**
	 * Returns the company this request belongs to
	 * 
	 * @return the company this request belongs to
	 */
	public Company getCompany() {
		return company;
	}
	
	/**
	 * Returns the status of the request 
	 * 
	 * @return the status of the request
	 */
	public Status getStatus() {
		return Status.valueOf(status);
	}
	
	/**
	 * Set the status of the request
	 */
	public void setStatus(Status status) {
		this.status = status.ordinal();
	}
	
	/**
	 * Converts a sign-up request into a {@link User}
	 * 
	 * @return a {@link User} converted from this sign-up request
	 */
	public User toUser() {
		User user = new User(username, password);
		user.setEncryptedPassword(password);
		
		Role role = new Role();
		role.setRoleId(User.Role.USER.getValue());
		user.setRole(role);
		user.setCompany(company);
		user.setPhone(phone);
		user.setEmail(email);
		user.setDisplayName(displayName);
		user.setStatus(User.Status.ACTIVE);
		
		return user;
	}
	
	@Override
	public String getIdentity() {
		return username;
	}

	@Override
	public String getIdentityAttribute() {
		return ID_FIELD_NAME;
	}
	
}