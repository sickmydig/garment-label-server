/** 
 * CompanyServerResource.java
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
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.io.FilenameUtils;
import org.restlet.Context;
import org.restlet.data.Reference;

import com.esquel.b2b.DatastoreApplication;
import com.esquel.b2b.DatastoreApplication.Store;
import com.esquel.b2b.schema.Company;
import com.esquel.b2b.schema.Customer;
import com.esquel.b2b.schema.CustomerLogo;
import com.esquel.b2b.schema.SubBrand;
import com.esquel.b2b.schema.SubBrandLogo;
import com.esquel.b2b.serialization.LocalhostStringTypeBlobDeserializerImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.joyaether.datastore.exception.DatastoreException;
import com.joyaether.datastore.exception.InvalidParameterException;
import com.joyaether.datastore.resource.DataObjectServerResource;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Query;
import com.joyaether.datastore.serialization.BlobDeserializer;
import com.joyaether.datastore.serialization.FieldTransformer;
import com.joyaether.datastore.serialization.ModelSerializationPolicy;
import com.joyaether.datastore.serialization.ModelSerializationStrategy;

public class CompanyServerResource extends DataObjectServerResource<Company, String> {
	
	/** The directory and file extension to store the logos */
	private static final String FILE_EXTENSION = "png";
	
	/**
	 * A custom implementation of Blob data deserializer that deserializes blob data read from a database table in EAP
	 */
	private class CompanyLogoDeserializer extends LocalhostStringTypeBlobDeserializerImpl {

		/**
		 * Creates a new instance of {@link StringTypeBlobDeerializer}
		 * 
		 * @param context the context that the deserializer runs in
		 * @param rootRef the root reference of the application
		 */
		public CompanyLogoDeserializer(Context context, Reference rootRef) {
			super(context, rootRef);
		}
		
		/**
		 * Determines whether or not the given value is already in the desired deserialized
		 * form
		 * @param field the field being serialized
		 * @param company the company object to be serialized
		 * @return true if the value was already in the desired deserialized format, false otherwise
		 * @throws SQLException thrown if there was problem accessing the EAP database
		 */
		protected boolean isDeserialized(Field field, Company company) throws SQLException {
			if (company != null && getApplication() instanceof DatastoreApplication) {
				DatastoreApplication application = (DatastoreApplication) getApplication();
				if (company.getEapLastModifiedDate() == null) {
					// The company logo was never deserialized from the EAP system
					return false;
				}
				
				switch (company.getType()) {
				case VENDOR:
					Customer customer = Model.find(
							application.getDatastore(Store.EAP).getConnectionSource(), 
							Customer.class, 
							company.getVendorId());
					
					if (customer != null && customer.getLastModified() != null) {
						return company.getEapLastModifiedDate().getTime() >= customer.getLastModified().getTime();
					}
					break;
				case BRAND:
					SubBrand subBrand = Model.find(
							application.getDatastore(Store.EAP).getConnectionSource(), 
							SubBrand.class, 
							company.getBrandId());
					
					if (subBrand != null && subBrand.getLastModified() != null) {
						return company.getEapLastModifiedDate().getTime() >= subBrand.getLastModified().getTime();
					}
					break;
				default: 
					return true;
				}
			}
			return true;
		}
		
		/**
		 * Returns the binary blob data for the given {@code field} 
		 * 
		 * @param field the field being deserialized from a EAP system
		 * @param company the company being deserialized
		 * @return the binary blob data, {@code null} if the blob data cannot be deserialized
		 * @throws SQLException thrown if there was problem accessing the EAP database
		 */
		protected byte[] getDeserializedValue(Field field, Company company) throws SQLException {
			if (company != null && getApplication() instanceof DatastoreApplication) {
				DatastoreApplication application = (DatastoreApplication) getApplication();
				switch (company.getType()) {
				case VENDOR:
					CustomerLogo customerLogo = Model.find(
							application.getDatastore(Store.EAP).getConnectionSource(), 
							CustomerLogo.class, 
							company.getVendorId());
					
					if (customerLogo != null) {
						return customerLogo.getLogo();
					}
					break;
				case BRAND:
					SubBrandLogo brandLogo = Model.find(
							application.getDatastore(Store.EAP).getConnectionSource(), 
							SubBrandLogo.class, 
							company.getBrandId());
					
					if (brandLogo != null) {
						return brandLogo.getLogo();
					}
					break;
				default:
					break;
				}
			}
			
			// Returns {@code null} by default
			return null;
		}
		
		/**
		 * Deserializes BLOB data from an EAP database table 
		 * 
		 * @param field the field being deserialized
		 * @param company the object being deserialized
		 * @return
		 */
		private Object serialize(Field field, Company company) {
			try {				
				if (isDeserialized(field, company)) {
					return field == null ? null : field.get(company);
				} else if (company != null) {
					String filename = company.getIdentity() + FilenameUtils.EXTENSION_SEPARATOR_STR + FILE_EXTENSION;
					Reference baseRef = getBaseRef(field);
					byte[] logo = getDeserializedValue(field, company);
					
					if (logo != null) {						
						String result = getDeserializedValue(logo, baseRef, filename);
						
						// Updates company
						if (company.getDao() == null) {
							Dao<Company, String> dao = DaoManager.createDao(getConnectionSource(), Company.class);
							company.setDao(dao);
						}
						company.setLogoUrl(result);
						company.setEapLastModifiedDate(new Date());
						company.update();
						
						return result;
					}
				}
			} catch (Exception ex) {
				getLogger().log(Level.WARNING, "Failed to serialize a field", ex);
			}
			
			// We return {@code null} by default
			return null;
		}
		
	}
	
	private CompanyLogoDeserializer deserializer;
	
	/**
	 * Returns a de-serializer to deserialize company logo blob data from EAP system
	 * 
	 * @return a deserializer to deserialize company logo from EAP
	 */
	protected synchronized CompanyLogoDeserializer getDeserializer() {
		if (deserializer == null) {
			deserializer = new CompanyLogoDeserializer(getContext(), getRootRef());
		}
		return deserializer;
	}
	
	/**
	 * Returns whether or not the given company is valid
	 * 
	 * @param company the company to validate
	 * @return {@code true} if the company is valid, {@code false} otherwise
	 */
	protected boolean isValid(Company company) {
		boolean result = true;
		if (company != null) {
			// If a company must enforce its users' email to be a specific domain, its domain cannot be null
			if (company.isEnforceDomain() && company.getDomain() == null) {
				result = false;
			}
		}
		return result;
	}
	
	@Override
	protected void onBeforeCreate(Object object) throws DatastoreException {
		if (object instanceof Company) {
			Company company = (Company) object;
			if (!isValid(company)) {
				throw new InvalidParameterException(Company.class.getSimpleName());
			}
		}
	}
	
	@Override
	protected void onBeforeModify(Object object) throws DatastoreException {
		if (object instanceof Company) {
			Company company = (Company) object;
			if (!isValid(company)) {
				throw new InvalidParameterException(Company.class.getSimpleName());
			}
		}
	}
	
	@Override
	protected String getId() {
		String id = getAttribute(Company.ID_FIELD_NAME);
		if (id == null) {
			id = getQuery().getFirstValue(Company.ID_FIELD_NAME, true);
		}
		return id;
	}
	
	@Override
	protected Class<Company> getResourceType() {
		return Company.class;
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
	
	@Override
	protected ModelSerializationStrategy getSerializationStrategy(Query query) {
		ModelSerializationStrategy strategy = super.getSerializationStrategy(query);
		
		if (strategy instanceof ModelSerializationPolicy) {
			ModelSerializationPolicy policy = (ModelSerializationPolicy) strategy;
			policy.registerFieldTransformer(Company.LOGO_URL_FIELD_NAME, new FieldTransformer() {

				@Override
				public Object transform(Field field, Object value) {
					if (value instanceof Company) {						
						return getDeserializer().serialize(field, (Company) value);
					}
					
					// Returns {@code null} by default
					return null;
				}
				
			});
		}
		
		return strategy;
	}
	
}
