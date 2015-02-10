/** 
 * LocalhostStringTypeBlobDeserializer.java
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
package com.esquel.b2b.serialization;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.restlet.Context;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;

import com.esquel.b2b.DatastoreApplication;
import com.joyaether.datastore.serialization.LocalhostStringTypeBlobDeserializer;

/**
 * An implementation of localhost blob deserializer that deserializes blob data into a specific directory
 */
public class LocalhostStringTypeBlobDeserializerImpl extends LocalhostStringTypeBlobDeserializer {

	/**
	 * Creates a new instance of {@link LocalhostStringTypeBlobDeserializerImpl}
	 * 
	 * @param context the context that the deserializer runs in
	 * @param rootRef the root reference of the application
	 */
	public LocalhostStringTypeBlobDeserializerImpl(Context context, Reference rootRef) {
		super(context, rootRef);
	}
	
	@Override
	protected File getBasePath(Reference baseRef) {
		String contentPath = getContext().getParameters().getFirstValue(DatastoreApplication.PARAM_CONTENT_PATH, true);
		if (contentPath != null) {
			// Ensure the content path is well formed
			contentPath = contentPath.endsWith(File.separator) ? contentPath : contentPath.concat(File.separator);
			Reference contentRef = new Reference(contentPath);
			if (contentRef.isRelative()) {
				contentRef.setProtocol(Protocol.FILE);
			}
			
			File result = new File(contentRef.toUri());
			if (baseRef != null) {
				result = new File(result, baseRef.toString());
			}
			return result;
		} else {
			return super.getBasePath(baseRef);
		}
	}
	
	@Override
	protected URL getRootURL() throws MalformedURLException {
		String contentURL = getContext().getParameters().getFirstValue(DatastoreApplication.PARAM_CONTENT_URL, true);
		if (contentURL != null) {
			return new Reference(contentURL).toUrl();			
		} else {
			return super.getRootURL();
		}
	}

}
