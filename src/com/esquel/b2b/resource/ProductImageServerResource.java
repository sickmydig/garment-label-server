/** 
 * ProductImageServerResource.java
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
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.io.FilenameUtils;
import org.restlet.Context;
import org.restlet.data.Reference;

import com.esquel.b2b.DatastoreApplication;
import com.esquel.b2b.DatastoreApplication.Store;
import com.esquel.b2b.schema.ProductImage;
import com.esquel.b2b.schema.ProductPicture;
import com.esquel.b2b.serialization.LocalhostStringTypeBlobDeserializerImpl;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.joyaether.datastore.resource.ReadonlyDataObjectServerResource;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Query;
import com.joyaether.datastore.schema.Query.Ordering;
import com.joyaether.datastore.serialization.FieldTransformer;
import com.joyaether.datastore.serialization.ModelSerializationPolicy;
import com.joyaether.datastore.serialization.ModelSerializationStrategy;

public class ProductImageServerResource extends ReadonlyDataObjectServerResource<ProductImage, String> {
	
	/** The directory and file extension to store the logos */
	private static final String FILE_EXTENSION = "png";
	
	/**
	 * A custom implementation of Blob data deserializer that deserializes blob data read from a database table in EAP
	 */
	private class ProductImageDeserializer extends LocalhostStringTypeBlobDeserializerImpl {

		/**
		 * A custom implementation of BLOB data deserializer that deserializes
		 * blob data read from a database table in EAP
		 */
		public ProductImageDeserializer(Context context, Reference rootRef) {
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
		protected boolean isDeserialized(Field field, ProductImage image) throws SQLException {
			if (image != null && getApplication() instanceof DatastoreApplication) {
				DatastoreApplication application = (DatastoreApplication) getApplication();
				if (image.getEapLastModifiedDate() == null) {
					// The product image was never deserialized from the EAP system
					return false;
				}
				
				// Find the {@link ProductPicture} from EAP with the given EAP code and sub-code
				Query query = new Query()
					.fieldIsEqualTo(ProductPicture.PRODUCT_NUMBER_FIELD_NAME, image.getProductNumber())
					.fieldIsEqualTo(ProductPicture.SUB_CODE_FIELD_NAME, image.getSubCode())
					.fieldIsOrderedBy(ProductPicture.LAST_MODIFY_TIME_FIELD_NAME, Ordering.DESCENDING);
				CloseableWrappedIterable<ProductPicture> iterable = Model.fetch(
						application.getDatastore(Store.EAP).getConnectionSource(), 
						ProductPicture.class, 
						query);
				CloseableIterator<ProductPicture> pictures = iterable == null ? null : iterable.closeableIterator();
				
				if (pictures != null) {
					try {
						ProductPicture picture = pictures.next();
						if (picture.getLastModified() != null && image.getLastModifiedDate() != null) {
							return image.getLastModifiedDate().getTime() >= picture.getLastModified().getTime();
						}
					} finally {
						pictures.closeQuietly();
					}
				}
			}
			
			return true;
		}
		
		/**
		 * Returns the binary blob data for the given {@code field} 
		 * 
		 * @param field the field being deserialized from a EAP system
		 * @param image the product image being deserialized
		 * @return the binary blob data, {@code null} if the blob data cannot be deserialized
		 * @throws SQLException thrown if there was problem accessing the EAP database
		 */
		protected byte[] getDeserializedValue(Field field, ProductImage image) throws SQLException {
			if (image != null && getApplication() instanceof DatastoreApplication) {
				DatastoreApplication application = (DatastoreApplication) getApplication();
				
				// Find the {@link ProductPicture} from EAP with the given EAP code and sub-code
				Query query = new Query()
					.fieldIsEqualTo(ProductPicture.PRODUCT_NUMBER_FIELD_NAME, image.getProductNumber())
					.fieldIsEqualTo(ProductPicture.SUB_CODE_FIELD_NAME, image.getSubCode())
					.fieldIsOrderedBy(ProductPicture.LAST_MODIFY_TIME_FIELD_NAME, Ordering.DESCENDING);
				CloseableWrappedIterable<ProductPicture> iterable = Model.fetch(
						application.getDatastore(Store.EAP).getConnectionSource(), 
						ProductPicture.class, 
						query);
				CloseableIterator<ProductPicture> pictures = iterable == null ? null : iterable.closeableIterator();
				
				if (pictures != null) {
					try {
						ProductPicture picture = pictures.next();
						if (picture != null) {
							return picture.getImage();
						}
					} finally {
						pictures.closeQuietly();
					}
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
		private Object serialize(Field field, ProductImage image) {
			try {
				if (isDeserialized(field, image)) {
					return field == null ? null : field.get(image);
				} else if (image != null) {
					String filename = image.getIdentity() + FilenameUtils.EXTENSION_SEPARATOR_STR + FILE_EXTENSION;
					Reference baseRef = getBaseRef(field);
					byte[] img = getDeserializedValue(field, image);
					
					if (img != null) {
						String result = getDeserializedValue(img, baseRef, filename);
						
						// Updates company
						if (image.getDao() == null) {
							Dao<ProductImage, String> dao = DaoManager.createDao(getConnectionSource(), ProductImage.class);
							image.setDao(dao);
						}
						image.setImageUrl(result);
						image.setEapLastModifiedDate(new Date());
						image.update();
						
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
	
	
	/** The deserializer to deserialize images from EAP. */
	private ProductImageDeserializer deserializer;
	
	/**
	 * Returns a de-serializer to deserialize company logo blob data from EAP system
	 * 
	 * @return a deserializer to deserialize company logo from EAP
	 */
	protected synchronized ProductImageDeserializer getDeserializer() {
		if (deserializer == null) {
			deserializer = new ProductImageDeserializer(getContext(), getRootRef());
		}
		return deserializer;
	}

	@Override
	protected Class<ProductImage> getResourceType() {
		return ProductImage.class;
	}

	@Override
	protected String getId() {
		String id = getAttribute(ProductImage.ID_FIELD_NAME);
		return id;
	}
	
	@Override
	protected void onRetrieve(Object object) {
		CloseableWrappedIterable<ProductPicture> iterable = null;
		
		try {			
			// We import product image on the fly
			Query q = new Query();
			Query query = parseRequest();
			if (query != null) {
				if (query.getArguments().get(ProductImage.PRODUCT_NUMBER_FIELD_NAME) != null) {					
					q.getArguments().put(
							ProductPicture.PRODUCT_NUMBER_FIELD_NAME, 
							query.getArguments().get(ProductImage.PRODUCT_NUMBER_FIELD_NAME));
				}
				
				if (query.getArguments().get(ProductImage.SUB_CODE_FIELD_NAME) != null) {					
					q.getArguments().put(
							ProductPicture.SUB_CODE_FIELD_NAME, 
							query.getArguments().get(ProductImage.SUB_CODE_FIELD_NAME));
				}
				
				Map<String, Long> range = query.getRange();
				q.limitResultsTo(range.get(Query.HIGH_RANGE));
				q.offsetResultsBy(range.get(Query.LOW_RANGE));
			}
			
			// We do not allow importing ALL product images from EAP. A search
			// criteria must be specified. The only allowed search criteria are
			// EAP code and sub code
			if (!q.getArguments().isEmpty() && getApplication() instanceof DatastoreApplication) {
				DatastoreApplication application = (DatastoreApplication) getApplication();
				iterable = Model.fetch(
						application.getDatastore(Store.EAP).getConnectionSource(), 
						ProductPicture.class, 
						q);
				
				for (ProductPicture picture : iterable) {
					query = new Query()
							.fieldIsEqualTo(ProductImage.PRODUCT_NUMBER_FIELD_NAME, picture.getProductNumber())
							.fieldIsEqualTo(ProductImage.SUB_CODE_FIELD_NAME, picture.getSubCode());
					
					List<ProductImage> images = Model.find(getConnectionSource(), ProductImage.class, query);
					if (images == null || (images != null && images.isEmpty())) {
						ProductImage image = new ProductImage(picture.getProductNumber(), picture.getSubCode());
						image.create(getConnectionSource());
					}
				}
			}
		} catch (Exception ex) {
			getLogger().log(Level.SEVERE, "Failed to import product images", ex);
		} finally {
			try {
				if (iterable != null) {						
					iterable.close();
				}
			} catch (SQLException e) {
				getLogger().log(Level.SEVERE, "Failed to close EAP iterable", e);
			}
		}
	}
	
	@Override
	protected ModelSerializationStrategy getSerializationStrategy(Query query) {
		ModelSerializationStrategy strategy = super.getSerializationStrategy(query);
		
		if (strategy instanceof ModelSerializationPolicy) {
			ModelSerializationPolicy policy = (ModelSerializationPolicy) strategy;
			policy.registerFieldTransformer(ProductImage.IMAGE_URL_FIELD_NAME, new FieldTransformer() {

				@Override
				public Object transform(Field field, Object value) {
					if (value instanceof ProductImage) {						
						return getDeserializer().serialize(field, (ProductImage) value);
					}
					
					// Returns {@code null} by default
					return null;
				}
				
			});
		}
		
		return strategy;
	}
	
}
