/** 
 * CredentialVerifier.java
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
package com.esquel.b2b.security;

import java.sql.SQLException;

import com.esquel.b2b.schema.User;
import com.joyaether.datastore.Datastore;
import com.joyaether.datastore.schema.Model;

/**
 * Verifier that verifies secrets against credentials stored as {@link User}.
 * This verifier also verifies whether a user is active before authenticating
 * the user.
 */
public class CredentialVerifier extends com.joyaether.datastore.security.CredentialVerifier {

	/**
	 * Creates a new instance of {@link CredentialVerifier} against the given credential store
	 * @param datastore the credential store that contains credential information
	 */
	public CredentialVerifier(Datastore datastore) {
		super(datastore, User.class);
	}

	@Override
	public int verify(String identifier, char[] secret) {
		int result = super.verify(identifier, secret);
		
		// Verifies that the user is active
		if (result == RESULT_VALID) {
			result = isCredentialActive(identifier, clazz) ? RESULT_VALID : RESULT_INVALID;
		}
		
		return result;
	}
	
	/**
	 * Returns whether or not the credential identified by the given identifier is active
	 * 
	 * @param identifier the unique identifier of the credential
	 * @param clazz the user object class
	 * @return {@code true} if the credential is active, {@code false} otherwise
	 */
	private <U> boolean isCredentialActive(String identifier, Class<U> clazz) {
		boolean result = false;
		try {
			if (datastore != null) {				
				U user = Model.find(datastore.getConnectionSource(), clazz, identifier);
				if (user instanceof User) {
					result = ((User) user).getStatus() == User.Status.ACTIVE;
				}
			}
		} catch (SQLException ex) {
			result = false;
		}
		return result;
	}
	
}
