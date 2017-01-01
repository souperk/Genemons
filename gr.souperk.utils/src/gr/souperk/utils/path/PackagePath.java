package gr.souperk.utils.path;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class PackagePath
	extends AbstractPath
	implements Path
{

	public PackagePath() 
	{
		super();
	}

	public PackagePath(List<String> theList) 
	{
		super(theList);
	}

	public PackagePath(String pathName) 
	{
		super(pathName);
	}

	protected List<String> parse( String pathName)
	{
		if( StringUtils.isBlank(pathName))
			return new ArrayList<String>();
		String parts[] = pathName.split( ".");
		List<String>partList = new ArrayList<String>();
		for (int i = 0; i < parts.length; i++) 
			partList.add( parts[i]);
		return partList;
	}

	@Override
	public String format() 
	{
		StringBuffer sb = new StringBuffer();
		boolean firstTime = true;
		for( String part : list)
		{
			if( !firstTime)
				sb.append( '.');
			sb.append(part);
		}
		return sb.toString();
	}

	@Override
	protected Path createPath() 
	{
		return new PackagePath();
	}
	

	
}
