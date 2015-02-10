/** 
 * OrderServerResource.java
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

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

import com.esquel.b2b.schema.Order;
import com.esquel.b2b.schema.OrderNumber;
import com.joyaether.datastore.exception.DatastoreException;
import com.joyaether.datastore.resource.DataObjectServerResource;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Query;
import com.joyaether.datastore.serialization.FieldTransformer;
import com.joyaether.datastore.serialization.ModelSerializationPolicy;
import com.joyaether.datastore.serialization.ModelSerializationStrategy;

public class OrderServerResource extends DataObjectServerResource<Order, String> {
	
	@SuppressWarnings("unchecked")
	@Override
	protected Query parseRequest(boolean isCountQuery) throws SQLException, MalformedURLException {
		Query result = super.parseRequest(isCountQuery);
		
		// We convert the formatted string into a number to query for an order
		// with a particular order number
		if (result != null && result.getArguments().containsKey(Order.B2B_ORDER_NUMBER_FIELD_NAME)) {
			Map<String, Object> argument = (Map<String, Object>) result.getArguments().get(Order.B2B_ORDER_NUMBER_FIELD_NAME);
			Set<String> keys = argument == null ? null : argument.keySet();
			if (keys != null) {				
				for (String key : keys) {
					Object value = argument.get(key);
					if (value instanceof List) {
						List<Object> values = new ArrayList<Object>();
						for (Object val : (List<Object>) value) {
							if (val instanceof String) {
								String v = (String) val;
								v = v.replaceFirst(OrderNumber.PREFIX, "");
								try {
									values.add(Long.parseLong(v));
								} catch (NumberFormatException ex) {
									// We ignore the value
								}
							}
						}
						
						// We remove the argument from the query
						if (!values.isEmpty()) {							
							argument.put(key, values);
						} else {
							argument.remove(key);
						}
					} else if (value instanceof String) {
						String val = (String) value;
						val = val.replaceFirst(OrderNumber.PREFIX, "");
						try {
							argument.put(key, (Object) Long.parseLong(val));
						} catch (NumberFormatException ex) {
							argument.remove(key);
						}
					}
				}
			}
			
			if (!argument.isEmpty()) {				
				result.getArguments().put(Order.B2B_ORDER_NUMBERS_FIELD_NAME + Query.FIELD_SEPARATOR + OrderNumber.ID_FIELD_NAME, argument);
			}
			result.getArguments().remove(Order.B2B_ORDER_NUMBER_FIELD_NAME);
		}
		
		return result;
	}
	
	@Override
	protected String getId() {
		String id = (String) getRequest().getAttributes().get(Order.ORDER_ID_FIELD_NAME);
		return id;
	}
	
	@Override
	protected Class<Order> getResourceType() {
		return Order.class;
	}
	
	@Override
	protected void onCreate(Object object) throws DatastoreException {
		if (object instanceof Order) {
			try {				
				OrderNumber number = new OrderNumber((Order) object);
				number.create(getConnectionSource());
			} catch (SQLException ex) {
				// Re-throw the exception
				throw new DatastoreException(ex);
			}
		}
	}
	
	@Override
	protected ModelSerializationStrategy getSerializationStrategy(Query query) {
		ModelSerializationStrategy strategy = super.getSerializationStrategy(query);
		
		if (strategy instanceof ModelSerializationPolicy) {
			ModelSerializationPolicy policy = (ModelSerializationPolicy) strategy;
			policy.registerFieldTransformer(Order.B2B_ORDER_NUMBER_FIELD_NAME, new FieldTransformer() {

				@Override
				public Object transform(Field field, Object value) {
					if (value instanceof Order) {
						try {
							Query query = new Query().fieldIsEqualTo(OrderNumber.ORDER_FIELD_NAME, ((Order) value).getIdentity());
							List<OrderNumber> numbers = Model.find(getConnectionSource(), OrderNumber.class, query);
							if (numbers != null && !numbers.isEmpty()) {
								return numbers.get(0).getFormattedOrderNumber();
							} else {
								return null;
							}							
						} catch (Exception ex) {
							getLogger().log(Level.SEVERE, "Failed to tranform B2B order number", ex);
						}
					}
					return null;
				}
				
			});
		}
		
		return strategy;
	}
	
}

