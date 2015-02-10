/** 
 * CopyOrderItemServerResource.java
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
import java.util.Map;

import javax.servlet.ServletContext;

import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;

import com.esquel.b2b.schema.Order;
import com.esquel.b2b.schema.OrderItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.dao.CloseableIterator;
import com.joyaether.datastore.exception.NotSupportedException;
import com.joyaether.datastore.exception.ResourceNotFoundException;
import com.joyaether.datastore.representation.BufferedRepresentation;
import com.joyaether.datastore.representation.ExceptionRepresentation;
import com.joyaether.datastore.representation.ModelRepresentation;
import com.joyaether.datastore.resource.SqlServerResource;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Query;
import com.joyaether.datastore.serialization.BlobDeserializer;
import com.joyaether.datastore.serialization.ModelSerializationPolicy;
import com.joyaether.datastore.serialization.ModelSerializationStrategy;
import com.joyaether.datastore.servlet.BaseDatastoreApplication;

public class CopyOrderItemServerResource extends SqlServerResource {
	
	/** Error messages. */
	private static final String ERROR_UNSUPPORTED_MEDIA_TYPE = "Unsupported media type.";
	
	/** The input JSON representation class. */
	private final class Input {
		
		@SerializedName(Order.ORDER_ID_FIELD_NAME)
		@Expose
		private String orderId;
		
	}
	
	/**
	 * Returns the unique identifier of the order as specified in the query
	 * 
	 * @return the unique identifier of the order to copy items to
	 */
	protected String getOrderId() {
		String id = getAttribute(Order.ORDER_ID_FIELD_NAME);
		if (id == null) {
			id = getQueryValue(Order.ORDER_ID_FIELD_NAME);
		}
		return id;
	}
	
	@Post("json")
	public Representation handlPost(Representation representation) {
		Representation result = null;
		
		BufferedRepresentation buf = null;
		CloseableIterator<OrderItem> iterator = null;
		try {
			// Parses request query parameters
			Query query = parseRequest();
			ModelSerializationStrategy serializationStrategy = ModelSerializationPolicy.DEFAULT
					.disableIdFieldOnlySerialization()
					.withExpansionTree(query.getExpandingFields())
					.withSelectingFields(query.getSelectFields());
			
			ServletContext ctx = (ServletContext) getContext().getAttributes().get(BaseDatastoreApplication.SERVLET_CONTEXT_ATTRIBUTE);
			File repo = (File) ctx.getAttribute(BaseDatastoreApplication.SERVLET_CONTEXT_TEMPDIR);
			buf = new BufferedRepresentation(representation, repo);
						
			// Retrieve items from the given order
			if (!buf.getMediaType().includes(MediaType.APPLICATION_JSON)) {
				throw new NotSupportedException(ERROR_UNSUPPORTED_MEDIA_TYPE);
			}
			
			final Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation()
					.serializeNulls()
					.setPrettyPrinting()
					.create();
			Input input = gson.fromJson(buf.getReader(), Input.class);
			Order fromOrder = Model.find(getConnectionSource(), Order.class, input.orderId);
			Order toOrder = Model.find(getConnectionSource(), Order.class, getOrderId());
			
			if (fromOrder == null) {
				throw new ResourceNotFoundException(Order.class.getSimpleName(), input.orderId);
			}
			if (toOrder == null) {
				throw new ResourceNotFoundException(Order.class.getSimpleName(), getOrderId());
			}
			
			// Copy items from {@code fromOrder} to {@code toOrder}
			iterator = fromOrder.getOrderItems() == null ? null : fromOrder.getOrderItems().closeableIterator();
			if (iterator != null) {
				while (iterator.hasNext()) {
					OrderItem item = iterator.next();
					item.setId(null);
					toOrder.getOrderItems().add(item);
				}
			}
						
			result = new ModelRepresentation(toOrder, serializationStrategy);
			setStatus(Status.SUCCESS_OK);
		} catch (Exception ex) {
			// Retrieves status from StatusService
			Status status = getApplication().getStatusService().getStatus(ex, this);
			setStatus(status);
			result = new ExceptionRepresentation(ex);
		} finally {
			if (buf != null) {
				buf.release();
			}
			if (iterator != null) {
				iterator.closeQuietly();
			}
		}
		
		return result;
	}

	@Override
	protected Map<Class<?>, BlobDeserializer<?>> getBlobDeserializers() {
		// Deserialization of blob data is not supported
		return null;
	}

}
