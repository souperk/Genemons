package gr.souperk.utils.configure;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Setting
{

	String key() default "no-key";

	SettingPriority priority() default SettingPriority.WARNING;
}
