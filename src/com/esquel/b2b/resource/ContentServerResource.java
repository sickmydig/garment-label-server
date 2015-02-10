/** 
 * ContentServerResource.java
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

import java.io.File;

import org.restlet.data.Protocol;
import org.restlet.data.Reference;

import com.esquel.b2b.DatastoreApplication;

/**
 * REST access to BLOB data stored on server
 */
public class ContentServerResource extends com.joyaether.datastore.resource.ContentServerResource {
	
	@Override
	protected File getBasePath() {
		String contentPath = getContext().getParameters().getFirstValue(DatastoreApplication.PARAM_CONTENT_PATH, true);
		if (contentPath != null) {
			// Ensure the content path is well formed
			contentPath = contentPath.endsWith(File.separator) ? contentPath : contentPath.concat(File.separator);
			Reference contentRef = new Reference(contentPath);
			if (contentRef.isRelative()) {
				contentRef.setProtocol(Protocol.FILE);
			}
			return new File(contentRef.toUri());
		} else {
			return super.getBasePath();
		}
	}

}
