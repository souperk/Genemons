package gr.souperk.utils.path;

import java.util.List;

public interface Path 
	extends Iterable<String>
{
	public int add( int level, List<String> newList);
	public int add( int level, Path path);
	public int add( int level, String part);

	public int add( List<String> newList);
	public int add( Path path);
	public int add( String part);
	public int size();
	public String get( int level);
	
	public Path sub( int start, int depth);
	public Path head( int depth);
	public Path tail( int depth);
	
	public Path reverse();
	public String format();
	public List<String> toList();
}
