/** 
 * ImportOrderItemServerResource.java
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

/**
 * Imports items as specified in the POST body into the order specified
 */
public class ImportOrderItemServerResource extends SqlServerResource {
	
	/** Error messages. */
	private static final String ERROR_UNSUPPORTED_MEDIA_TYPE = "Unsupported media type.";
	
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
			Order toOrder = Model.find(getConnectionSource(), Order.class, getOrderId());
			if (toOrder == null) {
				throw new ResourceNotFoundException(Order.class.getSimpleName(), getOrderId());
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
		}
		
		return result;
	}

	@Override
	protected Map<Class<?>, BlobDeserializer<?>> getBlobDeserializers() {
		// Deserialization of blob data is not supported
		return null;
	}

}
