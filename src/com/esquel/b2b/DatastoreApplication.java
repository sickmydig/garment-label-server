/** 
 * DatastoreApplication.java
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
package com.esquel.b2b;

import org.apache.commons.configuration.XMLConfiguration;
import org.restlet.Application;
import org.restlet.security.Enroler;
import org.restlet.security.LocalVerifier;

import com.esquel.b2b.security.CredentialEnroler;
import com.esquel.b2b.security.CredentialVerifier;
import com.joyaether.datastore.Datastore;
import com.joyaether.datastore.servlet.BaseDatastoreApplication;

/**
 * The EsquelPass {@link Application} that provides access to miscellaneous resources.
 */
public class DatastoreApplication extends BaseDatastoreApplication {
	
	/** Name of the key that specifies the path to store BLOB data in the application. */
	public static final String PARAM_CONTENT_PATH = "com.joyaether.datastore.content.path";
	
	/** Name of the key that specifies the URL */
	public static final String PARAM_CONTENT_URL = "com.joyaether.datastore.content.url";
	
	/** EAP database configuration */
	private final String CONFIG_EAP_DATABASE_URL = "eap_database.url";
	private final String CONFIG_EAP_DATABASE_USERNAME = "eap_database.username";
	private final String CONFIG_EAP_DATABASE_PASSWORD = "eap_database.password";
	
	private Datastore eapDatastore;
	
	/** The verifier to verify credentials. */
	private CredentialVerifier verifier;
	
	/**
	 * An enumeration of different stores used in CCS.
	 */
	public enum Store {
		
		/**
		 * The underlying store to host data for B2B
		 */
		B2B,
		
		/**
		 * The store containing EAP data
		 */
		EAP;
		
		public static Store fromInteger(int value) {
			switch(value) {
			case 1:
				return EAP;
			default:
				return B2B;
			}
		}
	}
	
	/**
	 * Returns a {@link Datastore} to a given store
	 * 
	 * @param store the type of store to return
	 * @return the {@link Datastore} that connects to the database of the given type, {@code null} if the given store is not found
	 */
	public Datastore getDatastore(Store store) {
		switch(store) {
		case B2B:
			return getDatastore();
		case EAP:
			return getEapDatastore();
		}
		return null;
	}
	
	/**
	 * Retrieves the EAP datastore 
	 * 
	 * @return the datastore that connects to the EAP database
	 */
	public synchronized Datastore getEapDatastore() {
		if (eapDatastore == null) {
			XMLConfiguration config = getConfiguration();
			eapDatastore = new Datastore(
					config.getString(CONFIG_EAP_DATABASE_URL),
					config.getString(CONFIG_EAP_DATABASE_USERNAME),
					config.getString(CONFIG_EAP_DATABASE_PASSWORD)); 
		}
		return eapDatastore;
	}
	
	@Override
	protected LocalVerifier getCredentialVerifier() {
		if (verifier == null) {
			verifier = new CredentialVerifier(getDatastore(Store.B2B));
		}
		return verifier;
	}
	
	@Override
	protected Enroler getCredentialEnroler() {
		return new CredentialEnroler(getDatastore());
	}
	
}
