/** 
 * CompanyFileServerResource.java
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

import java.util.HashMap;
import java.util.Map;

import com.esquel.b2b.schema.CompanyFile;
import com.esquel.b2b.serialization.LocalhostStringTypeBlobDeserializerImpl;
import com.joyaether.datastore.resource.DataObjectServerResource;
import com.joyaether.datastore.serialization.BlobDeserializer;

public class CompanyFileServerResource extends DataObjectServerResource<CompanyFile, String> {
	
	@Override
	protected String getId() {
		String id = (String) getRequest().getAttributes().get(CompanyFile.ID_FIELD_NAME);
		return id;
	}
	
	@Override
	protected Class<CompanyFile> getResourceType() {
		return CompanyFile.class;
	}
	
	@Override
	protected Map<Class<?>, BlobDeserializer<?>> getBlobDeserializers() {
		Map<Class<?>, BlobDeserializer<?>> result = new HashMap<Class<?>, BlobDeserializer<?>>();
		result.put(
				String.class, 
				new LocalhostStringTypeBlobDeserializerImpl(
						getContext(), 
						getRootRef()));
		return result;
	}
	
}
