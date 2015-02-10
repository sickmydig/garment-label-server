/** 
 * ForgetPasswordServerResource.java
 *
 * Copyright (c) 2008-2014 Joy Sprouts Limited. All rights reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * 
 * This unpublished material is proprietary to Joy Sprouts Limited.
 * All rights reserved. The methods and
 * techniques described herein are considered trade secrets
 * and/or confidential. Reproduction or distribution, in whole
 * or in part, is forbidden except by express written permission
 * of Joy Sprouts Limited.
 */
package com.esquel.b2b.resource;

import java.util.logging.Level;

import javax.mail.Message.RecipientType;

import org.codemonkey.simplejavamail.Email;

import com.joyaether.datastore.security.ForgetCredentialSecretServerResource;
import com.joyaether.datastore.security.User;
import com.joyaether.datastore.service.MailService;

public class ForgetPasswordServerResource extends ForgetCredentialSecretServerResource {
	
	/** Information on the message */
	private static final String SUBJECT = "You must have forgot your password";
	private static final String BODY = "Your temporary password: %s";
	
	/** Information on the message */
	private static final String FROM_EMAIL = "support@esquel.com";
	private static final String FROM_NAME = "Esquel Group";
	
	@Override
	protected void onForgetPassword(User user, String tempPassword) {
		try {
			MailService mailService = getApplication().getServices().get(MailService.class);
			if (mailService != null) {				
				Email email = new Email();
				email.setFromAddress(FROM_NAME, FROM_EMAIL);
				email.setText(String.format(BODY, tempPassword));
				email.setSubject(SUBJECT);
				
				String recipient = user.getUsername();
				if (user instanceof com.esquel.b2b.schema.User) {
					com.esquel.b2b.schema.User usr = (com.esquel.b2b.schema.User) user;
					if (usr.getEmail() != null) {
						recipient = usr.getEmail();
					}
				}
				email.addRecipient("", recipient, RecipientType.TO);
				
				mailService.sendMail(email);
			}    		
    	} catch (Exception ex) {
    		getLogger().log(Level.SEVERE, "Failed to send temporary password email", ex);
    	}
	}
	
}
