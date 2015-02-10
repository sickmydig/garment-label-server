/** 
 * StoredProcedure.java
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

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(TYPE)
@Retention(RUNTIME)
public @interface StoredProcedure {
	
	/** The name of the stored procedure to execute to update an object. */
	String update() default "";
	
	/** The name of the stored procedure to execute to delete an object. */
	String delete() default "";
	
	/** The name of the stored procedure to execute to read an object. */
	String read() default "";
	
	/** The name of the stored procedure to execute to create an object. */
	String create() default "";

}
