package gr.souperk.utils.context.wrap;

import gr.souperk.utils.context.Context;
import gr.souperk.utils.context.support.MappedContext;


/**
 * 
 * @since 0.1.0
 * @author souperk
 */
//TODO write javadoc. 
public class DefaultContext
	extends ContextWrapper
	implements Context
{
	public DefaultContext() 
	{
		super( new MappedContext());
	}
	
	public DefaultContext( Context theContext) 
	{
		super( theContext);
	}
}
