/** 
 * OrderProductDetailServerResource.java
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

import com.esquel.b2b.schema.SubProductValue;
import com.joyaether.datastore.resource.DataObjectServerResource;

public class SubProductValueServerResource extends DataObjectServerResource<SubProductValue, String> {
	
	@Override
	protected String getId() {
		String id = (String) getRequest().getAttributes().get(SubProductValue.ID_FIELD_NAME);
		return id;
	}
	
	@Override
	protected Class<SubProductValue> getResourceType() {
		return SubProductValue.class;
	}
	
}

