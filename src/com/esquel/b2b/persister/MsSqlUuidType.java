/** 
 * MsSqlUuidType.java
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
package com.esquel.b2b.persister;

import java.sql.SQLException;
import java.util.UUID;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.UuidType;

/**
 * Type that persists a String object that represent UUID. This class can be
 * used to work around a limitation on MS SQL JDBC which does not allow setting
 * UUID object to PreparedStatement (This may be actually a OrmLite bug. I am
 * not sure).
 * 
 * See http://ormlite.com/javadoc/ormlite-core/doc-files/ormlite_5.html#Custom-
 * Persisters on How to use custom persister.
 * 
 * @author Andrew Chan
 */
public class MsSqlUuidType extends UuidType {

	private static final MsSqlUuidType singleTon = new MsSqlUuidType();

	public static MsSqlUuidType getSingleton() {
		return singleTon;
	}

	private MsSqlUuidType() {
		super(SqlType.STRING, new Class<?>[] {});
	}

	@Override
	public Object parseDefaultString(FieldType fieldType, String defaultStr)
			throws SQLException {
		// verify defaultStr is in UUID format
		super.parseDefaultString(fieldType, defaultStr);
		return defaultStr;
	}

	public Object sqlArgToJava(FieldType fieldType, Object sqlArg, int columnPos)
			throws SQLException {
		// verify sqlArg is in UUID format
		super.sqlArgToJava(fieldType, sqlArg, columnPos);
		return sqlArg;
	}

	public Object javaToSqlArg(FieldType fieldType, Object obj) {
		// verify obj is in UUID format
		UUID.fromString((String) obj);
		return obj;
	}

	@Override
	public Object generateId() {
		return super.generateId().toString();
	}

}
