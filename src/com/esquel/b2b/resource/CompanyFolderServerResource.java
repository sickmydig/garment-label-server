/** 
 * CompanyFolderServerResource.java
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
package com.esquel.b2b.resource;

import com.esquel.b2b.schema.CompanyFolder;
import com.joyaether.datastore.resource.DataObjectServerResource;

/**
 * The server resource provides REST API access to the table "company_folders"
 */
public class CompanyFolderServerResource extends DataObjectServerResource<CompanyFolder, String> {

	@Override
	protected Class<CompanyFolder> getResourceType() {
		return CompanyFolder.class;
	}

	@Override
	protected String getId() {
		return (String) getRequest().getAttributes().get(CompanyFolder.ID_FIELD_NAME);
	}

}
