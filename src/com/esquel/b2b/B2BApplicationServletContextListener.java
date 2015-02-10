/** 
 * CCSApplicationServletContextListener.java
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

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.joyaether.datastore.servlet.ApplicationServletContextListener;

public class B2BApplicationServletContextListener extends ApplicationServletContextListener {
	
	final String ROOT_PATH = "webapp.base";
	
	/** A configuration setting that specifies the location to store content in the app. */
	public static final String CONFIG_CONTENT_PATH = "com.joyaether.datastore.content.path";
	
	/** The configuration parameter that specifies the root URL of the contents uploaded to the server. */
	public static final String CONFIG_ROOT_URL = "com.joyaether.datastore.root.url";
	
	@Override
	public void contextInitialized(ServletContextEvent evt) {
		super.contextInitialized(evt);
		
		ServletContext ctx = evt.getServletContext();
		String param = ctx.getInitParameter(CONFIG_CONTENT_PATH);
		if (param != null) {			
			System.setProperty(ROOT_PATH, param);
		}
	}

}
