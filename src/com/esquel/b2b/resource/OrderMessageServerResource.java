/** 
 * OrderCommunicationServerResource.java
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

import com.esquel.b2b.schema.OrderMessage;
import com.joyaether.datastore.resource.ReadonlyDataObjectServerResource;

public class OrderMessageServerResource extends ReadonlyDataObjectServerResource<OrderMessage, String> {
	
	@Override
	protected String getId() {
		String id = (String) getRequest().getAttributes().get(OrderMessage.MESSAGE_ID_FIELD_NAME);
		return id;
	}
	
	@Override
	protected Class<OrderMessage> getResourceType() {
		return OrderMessage.class;
	}
	
}

