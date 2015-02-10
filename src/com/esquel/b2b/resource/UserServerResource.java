/** 
 * UserServerResource.java
 *
 * Copyright (c) 2008-2014 Joy Aether Limited. All rights reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * 
 * This unpublished material is proprietary to Joy Sprouts Limited.
 * All rights reserved. The methods and
 * techniques described herein are considered trade secrets
 * and/or confidential. Reproduction or distribution, in whole
 * or in part, is forbidden except by express written permission
 * of Joy Aether Limited.
 */
package com.esquel.b2b.resource;

import java.sql.SQLException;

import com.esquel.b2b.schema.User;
import com.joyaether.datastore.exception.DatastoreException;
import com.joyaether.datastore.oauth.OAuthToken;
import com.joyaether.datastore.resource.DataObjectServerResource;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Query;

/**
 * Provides REST access to {@link User}
 */
public class UserServerResource extends DataObjectServerResource<User, String> {
	
	@Override
	protected void onModify(Object object) throws DatastoreException {
		if (object instanceof User) {
			User user = (User) object;
			if (user.getStatus() == User.Status.INACTIVE) {
				// Removes all tokens issued to the user
				Query query = new Query();
				query.fieldIsEqualTo(OAuthToken.USER_ID_FIELD_NAME, user.getUsername());
				try {					
					Model.delete(getConnectionSource(), OAuthToken.class, query);
				} catch (SQLException ex) {
					throw new DatastoreException(ex);
				}
			}
		}
	}

	@Override
	protected Class<User> getResourceType() {
		return User.class;
	}

	@Override
	protected String getId() {
		String id = (String) getRequest().getAttributes().get(User.ID_FIELD_NAME);
		return id;
	}

}
