
package com.tirmizee.core.annotaion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

/**
 * Annotation for sort datatable
 * 
 * @author pratya yeekhaday
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })  
@Inherited
@Documented
public @interface SortColumn { 
	
	@AliasFor("name")
	String[] value() default {}; 
	
}
