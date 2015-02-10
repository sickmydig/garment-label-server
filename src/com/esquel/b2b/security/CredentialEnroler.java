/** 
 * CredentialEnroler.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.restlet.Application;
import org.restlet.data.ClientInfo;
import org.restlet.security.Enroler;
import org.restlet.security.Role;

import com.esquel.b2b.schema.User;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.joyaether.datastore.Datastore;
import com.joyaether.datastore.security.RoleScope;

/**
 * An {@link Enroler} that assign appropriate roles for authenticated B2B
 * credentials
 */
public class CredentialEnroler implements Enroler {
	
	/** The credential store. */
	private volatile Datastore store;
	
	/**
	 * Creates a new {@link Enroler} that is based on the given credential store
	 * 
	 * @param datastore the credential store this enroler base on
	 */
	public CredentialEnroler(Datastore datastore) {
		store = datastore;
	}
	
	/**
	 * Returns the credential store this enroler is based on
	 * 
	 * @return the credential store this enroler is based on
	 */
	protected Datastore getCredentialStore() {
		return store;
	}

	@Override
	public void enrole(ClientInfo clientInfo) {
		if (clientInfo != null) {
			String identity = clientInfo.getUser() == null ? null : clientInfo.getUser().getIdentifier();
			CloseableIterator<RoleScope> iterator = null;
			List<Role> result = new ArrayList<Role>();
			ConnectionSource connectionSource = getCredentialStore() == null ? null : getCredentialStore().getConnectionSource();
			
			if (connectionSource == null) {
				// Unable to enrole the user
				return;
			}
			
			try {
				Dao<User, String> dao = DaoManager.createDao(connectionSource, User.class);
				User user = dao.queryForId(identity);
				user.getRole().refresh();
				
				iterator = user.getRole().getScopes().closeableIterator();
				while (iterator.hasNext()) {
					RoleScope roleScope = iterator.next();
					roleScope.getScope().refresh();
					
					result.add(new Role(Application.getCurrent(), roleScope.getScope().getScopeId(), null));
				}
				
				clientInfo.setRoles(result);
			} catch (Exception ex) {
				Application.getCurrent().getLogger().log(Level.SEVERE, "Unable to enrole the user", ex);
			} finally {
				if (iterator != null) {
					iterator.closeQuietly();
				}
			}
		}
	}

}
