/** 
 * StoredProcedureObject.java
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
package com.joyaether.datastore.schema;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.joyaether.datastore.schema.internal.$Orm$Preconditions;

/**
 * A data object to execute stored procedures
 *
 * @param <T> the type of object to return
 * @param <ID> the identifier of the object
 */
public abstract class StoredProcedureObject<T, ID> {
	
	/** The command to execute a query in the underlying SQL server. */
	private static final String QUERY_EXECUTE = "EXEC %s";
	
	/**
	 * Executes a stored procedure that does not return a result set 
	 * 
	 * @param param the array of parameters for the stored procedure
	 * @param dao the {@link Dao} object to access the database
	 * @throws SQLException thrown if there was error executing the stored procedure
	 */
	public static <T, ID> void set(StoredProcedureParameters params, Dao<T, ID> dao) throws SQLException {
		$Orm$Preconditions.checkNotNull(dao);
		$Orm$Preconditions.checkNotNull(params);
		
		StoredProcedure sp = params.getClass().getAnnotation(StoredProcedure.class);
		if (sp != null && !sp.update().isEmpty()) {
			dao.executeRaw(
					getStoredProcedureRawQuery(sp.update(), params == null ? null : params.toArguments(StoredProcedureParameters.Type.UPDATE)), 
					params.toArguments(StoredProcedureParameters.Type.UPDATE));
		}
	}
	
	/**
	 * Returns a list of objects as a result of executing the given stored procedure
	 * 
	 * @param params an object containing parameters to the stored procedure
	 * @param dao the {@link Dao} object to access the database
	 * @return the result set as a result of executing the given stored procedure.
	 * @throws SQLException thrown if there was error executing the stored procedure
	 */
	public static <T, ID> List<T> fetch(StoredProcedureParameters params, Dao<T, ID> dao) throws SQLException {
		$Orm$Preconditions.checkNotNull(dao);
		$Orm$Preconditions.checkNotNull(params);
		
		List<T> result = null;
		StoredProcedure sp = params.getClass().getAnnotation(StoredProcedure.class);
		if (sp != null && !sp.read().isEmpty()) {			
			GenericRawResults<T> results = dao.queryRaw(
					getStoredProcedureRawQuery(sp.read(), params == null ? null : params.toArguments(StoredProcedureParameters.Type.READ)), 
					dao.getRawRowMapper(), 
					params.toArguments(StoredProcedureParameters.Type.READ));
			
			if (results != null) {
				try {
					result = new ArrayList<T>();
					for (T t : results) {
						result.add(t);
					}
				} finally {
					results.close();
				}
			}
		}
		return result;
	}
	
	/**
	 * Returns the given object by executing a stored procedure against the database 
	 * 
	 * @param params an object containing parameters to the stored procedure
	 * @param dao the {@link Dao} object to access the database
	 * @return the object identified by the given identifier, {@code null} if no object is found
	 * @throws SQLException thrown if there was error executing the query
	 */
	public static <T, ID> T get(StoredProcedureParameters params, Dao<T, ID> dao) throws SQLException {
		$Orm$Preconditions.checkNotNull(dao);
		$Orm$Preconditions.checkNotNull(params);
		
		StoredProcedure sp = params.getClass().getAnnotation(StoredProcedure.class);
		if (sp != null && !sp.read().isEmpty()) {
			GenericRawResults<T> results = dao.queryRaw(
					getStoredProcedureRawQuery(sp.read(), params == null ? null : params.toArguments(StoredProcedureParameters.Type.READ)), 
					dao.getRawRowMapper(), 
					params.toArguments(StoredProcedureParameters.Type.READ));
			
			if (results != null) {
				return results.getFirstResult();
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the stored procedure raw query string
	 * 
	 * @param procName the name of the stored procedure
	 * @param arguments the parameters to pass to the stored procedure
	 * @return a raw query string to execute a stored procedure
	 */
	public static String getStoredProcedureRawQuery(String procName, String[] arguments) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format(QUERY_EXECUTE, procName));
		
		if (arguments != null) {
			builder.append(' ');
			for (int i = 0; i < arguments.length; i++) {
				if (i > 0) {
					builder.append(", ");
				}
				builder.append("?");
			}
		}
		
		return builder.append(" ;").toString();
	}

}
