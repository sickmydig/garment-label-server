/** 
 * ImportSubBrandsServerResource.java
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

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import org.restlet.data.Status;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;
import org.restlet.service.TaskService;

import com.esquel.b2b.DatastoreApplication;
import com.esquel.b2b.DatastoreApplication.Store;
import com.esquel.b2b.schema.Company;
import com.esquel.b2b.schema.SubBrand;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.CloseableWrappedIterable;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.joyaether.datastore.Datastore;
import com.joyaether.datastore.representation.ExceptionRepresentation;
import com.joyaether.datastore.resource.ReadonlyDataObjectServerResource;
import com.joyaether.datastore.schema.Model;
import com.joyaether.datastore.schema.Query;

/**
 * This server resource imports all records in TMISDB.dbo.dtSubBrandList into b2b.dbo.companies
 */
public class ImportSubBrandsServerResource extends ReadonlyDataObjectServerResource<SubBrand, Long> {
	
	/**
	 * Returns a connection source to the given {@link Store}
	 * 
	 * @param store the store to return the connection source
	 * @return the connection source to the given store, {@code null} if the store is not defined or if the containing application is not a {@link DatastoreApplication}
	 * @throws SQLException thrown if there was problem connecting to the database
	 */
	protected ConnectionSource getConnectionSource(Store store) throws SQLException {
		if (getApplication() instanceof DatastoreApplication) {
			Datastore datastore = ((DatastoreApplication) getApplication()).getDatastore(store);
			if (datastore != null) {				
				return datastore.getConnectionSource();
			}
		}
		return null;
	}
	
	@Override
	public Representation handleGet() {
		try {
			// Parses the query parameters. This allows us to specify the customers to create or update
			final Query query = parseRequest();
			
			// Start the task to import customers from TMISDB
			TaskService taskService = getApplication().getServices().get(TaskService.class);
			taskService.execute(new Runnable() {
				
				@Override
				public void run() {
					CloseableIterator<SubBrand> subBrands = null;
					try {					
						Dao<Company, String> companyDao = DaoManager.createDao(getConnectionSource(), Company.class);
						CloseableWrappedIterable<SubBrand> iterable = Model.fetch(getConnectionSource(Store.EAP), SubBrand.class, query);
						subBrands = iterable == null ? null : iterable.closeableIterator();
						
						if (subBrands != null) {
							while (subBrands.hasNext()) {
								SubBrand subBrand = subBrands.next();
								
								Query q = new Query();
								q.fieldIsEqualTo(Company.EAPMIS_BRAND_ID_FIELD_NAME, subBrand.getIdentity());
								List<Company> companies = Model.find(getConnectionSource(Store.B2B), Company.class, q);
								if (companies != null && !companies.isEmpty()) {
									for (Company company : companies) {			
										company.setCompanyName(subBrand.getBrandName());
										company.setStatus(subBrand.isActive() ? Company.Status.ACTIVE : Company.Status.INACTIVE);
										company.update();
									}
								} else {
									// The company does not exist. We need to create a new one
									Company company = subBrand.toCompany();
									company.setDao(companyDao);
									company.create();
								}
							}
						}
					} catch (Exception ex) {
						getLogger().log(Level.SEVERE, "Unable to import customers into B2B system", ex);
					} finally {
						if (subBrands != null) {
							subBrands.closeQuietly();
						}
					}
				}
				
			});
		} catch (Exception ex) {
			// Retrieves status from StatusService
			Status status = getApplication().getStatusService().getStatus(ex, this);
			setStatus(status);
			return new ExceptionRepresentation(ex);
		}
		
		return new EmptyRepresentation();
	}

	@Override
	protected Class<SubBrand> getResourceType() {
		return SubBrand.class;
	}

	@Override
	protected Long getId() {
		String id = getAttribute(SubBrand.SUB_BRAND_ID_FIELD_NAME);
		if (id == null) {
			id = getQuery().getFirstValue(SubBrand.SUB_BRAND_ID_FIELD_NAME, true);
		}
		return id == null ? null : Long.parseLong(id);
	}

}
