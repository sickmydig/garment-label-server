/** 
 * Users.java
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

@DatabaseTable(tableName = "users")
public class User extends com.joyaether.datastore.security.User {
	
	public static final String COMPANY_FIELD_NAME = "company";
	public static final String DISPLAY_NAME_FIELD_NAME = "display_name";
	public static final String PHONE_FIELD_NAME = "phone";
	public static final String EMAIL_FIELD_NAME = "email";
	public static final String LAST_LOGIN_TIME_FIELD_NAME = "last_login_time";
	public static final String STATUS_FIELD_NAME = "status";
	
	/** An enum that represents the status of the user. */
	public enum Status {
		
		INACTIVE,
		
		ACTIVE;
		
		/**
		 * Returns the enum constant of the specified enum type with the specified ordinal value 
		 * 
		 * @param val the ordinal value of the constant to return
		 * @return the enum constant of the specified enum type with the specified value
		 * @throws IllegalArgumentException thrown if the specified enum type has no constant with the specified name, or the specified class object does not represent an enum type
		 */
		public static Status valueOf(int val) {
			for (Status s : Status.values()) {
				if (s.ordinal() == val) {
					return s;
				}
			}
			throw new IllegalArgumentException();
		}
	}
	
	/** An enum that represents the roles of users. */
	public enum Role {
		
		/** An administrator in the system. */
		ADMINISTRATOR(1),
		
		/** A normal user in the system. */
		USER(2);
		
		int value;
		
		private Role(int value) {
			this.value = value;
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
		 * Returns the enum constant of the specified enum type with the specified ordinal value 
		 * 
		 * @param val the ordinal value of the constant to return
		 * @return the enum constant of the specified enum type with the specified value
		 * @throws IllegalArgumentException thrown if the specified enum type has no constant with the specified name, or the specified class object does not represent an enum type
		 */
		public static Role valueOf(int val) {
			for (Role b : Role.values()) {
				if (b.ordinal() == val) {
					return b;
				}
			}
			throw new IllegalArgumentException();
		}
		
	}
	
	@DatabaseField(
			columnName = LAST_LOGIN_TIME_FIELD_NAME, 
			canBeNull = false, 
			dataType = DataType.DATE_STRING, 
			format = "yyyy-MM-dd HH:mm:ss")
	@SerializedName(LAST_LOGIN_TIME_FIELD_NAME)
	@Expose
	private Date lastLoginDate;
	
	@DatabaseField(
			columnName = COMPANY_FIELD_NAME + "_id", 
			canBeNull = false,
			foreign = true)
	@SerializedName(COMPANY_FIELD_NAME)
	@Expose
	private Company company;
	
	@DatabaseField(
			columnName = DISPLAY_NAME_FIELD_NAME, 
			canBeNull = true, 
			useGetSet = true)
	@SerializedName(DISPLAY_NAME_FIELD_NAME)
	@Expose
	private String displayName;
	
	@DatabaseField(
			columnName = PHONE_FIELD_NAME, 
			canBeNull = true, 
			useGetSet = true)
	@SerializedName(PHONE_FIELD_NAME)
	@Expose
	private String phone;
	
	@DatabaseField(
			columnName = EMAIL_FIELD_NAME, 
			canBeNull = true)
	@SerializedName(EMAIL_FIELD_NAME)
	@Expose
	private String email;
	
	@DatabaseField(columnName = STATUS_FIELD_NAME)
	@SerializedName(STATUS_FIELD_NAME)
	@Expose
	private int status;
	
	
	User() {
		// all persisted classes must define a no-arg constructor with at least
		// package visibility
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String username, String encryptedPassword) {
		setUsername(username);
		setEncryptedPassword(encryptedPassword);
	}
	
	/**
	 * Specifies a new company for the user
	 * 
	 * @param company the new company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	
	/**
	 * Returns the {@link Company} this user works in
	 * 
	 * @return the {@link Company} this user works in
	 */
	public Company getCompany() {
		return company;
	}
	
	/**
	 * Returns the status of the user
	 * 
	 * @return the status of the user
	 */
	public Status getStatus() {
		return Status.valueOf(status);
	}
	
	/**
	 * Specifies the status of the user
	 * 
	 * @param status the new status of the user
	 */
	public void setStatus(Status status) {
		this.status = status.ordinal();
	}
	
}
