/** 
 * StoredProcedureParameters.java
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

public interface StoredProcedureParameters {
	
	/** An enum of the type of parameters. */
	public enum Type {
		
		CREATE,
		
		READ,
		
		UPDATE,
		
		DELETE
		
	}
	
	/**
	 * Returns an array of arguments to a stored procedure
	 * 
	 * @return An array of string that will be used as arguments to a stored procedure
	 */
	String[] toArguments(Type type);

}
