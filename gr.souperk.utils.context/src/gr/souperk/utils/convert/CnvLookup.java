package gr.souperk.utils.convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author souperk
 *
 */
//TODO finish javadoc.
public class CnvLookup
{
	private List<Class<?>> typeList = new ArrayList<Class<?>>();

	private Map<Class<?>, Map<Class<?>, Converter>> map;

	/*
	 * It's probably inefficient to use a 2d array. Also it is better to change
	 * this to boolean.
	 */
	/**
	 * A two dimensional array holding in which the value of every (x,y) point
	 * means it have already tried to convert from typeList.get(x) to
	 * typeList.get(y).
	 */
	private boolean matrix[][];

	public CnvLookup( Map<Class<?>, Map<Class<?>, Converter>> theMap )
	{
		map = new HashMap<Class<?>, Map<Class<?>, Converter>>();

		init(theMap);
		lookup();

	}

	/**
	 * Basically tries to find paths to convert between types that there isn't a
	 * direct {@code Converter}.
	 * 
	 * Note if a type is child of another it should return the child type and note the parent. 
	 */
	public void lookup()
	{

		for ( Class<?> sourceType : typeList )
		{
			for ( Class<?> targetType : typeList )
			{
				clear();
				ConverterChain chain = new ConverterChain();

				if ( sourceType != targetType )
				{
					boolean found = travel(sourceType, targetType, chain);

					if ( found && chain.size() > 0 )
					{
						Map<Class<?>, Converter> targetMap = map.get(sourceType);
						if ( targetMap == null )
							targetMap = new HashMap<Class<?>, Converter>();
						targetMap.put(targetType, chain);
					}
				}
			}
		}
	}

	/**
	 * Recursively searches for a path between sourceType and targetType.
	 * 
	 * @param sourceType
	 *            The type of the source.
	 * @param targetType
	 *            The type of the target.
	 * @param chain
	 *            The {@code ConverterChain} to store the results on.
	 * @return true if have managed to find a path between the sourceType and
	 *         targetType.
	 */
	private boolean travel( Class<?> sourceType, Class<?> targetType, ConverterChain chain )
	{
		if ( sourceType == targetType )
		{ // If it have reached the target return true.
			return true;
		} else if ( !map.containsKey(sourceType) )
		{ // If it can't convert sourceType to anything.
			return false;
		} else if ( map.get(sourceType).containsKey(targetType) )
		{ // If the it can convert sourceType to targetType
			// Add converter to chain
			chain.add(map.get(sourceType).get(targetType), targetType);
			return true;
		}

		// for every type that can be converted from sourceType.
		for ( Class<?> newTargetType : map.get(sourceType).keySet() )
		{
			if ( !isVisited(sourceType, newTargetType) )
			{ // If haven't tried sourceType to newTargetType conversion.
				visit(sourceType, newTargetType);

				// Recursively complete chain.
				boolean found = travel(sourceType, newTargetType, chain);
				if ( found )
				{ // if chain is completed.
					Converter cnv = map.get(sourceType).get(newTargetType);
					chain.add(cnv, newTargetType);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Initializes the matrix as an two dimensional array with the same size as
	 * typeList and sets elements to false.
	 */
	private void clear()
	{
		int size = typeList.size();
		matrix = new boolean[size][size];
	}

	private void visit( Class<?> sourceType, Class<?> targetType )
	{
		int x = typeList.indexOf(sourceType);
		int y = typeList.indexOf(targetType);
		matrix[x][y] = true;
	}

	/**
	 * @param sourceType
	 *            The type of the source.
	 * @param targetType
	 *            The type of the target.
	 * @return true if and only if conversion from sourceType to targetType is
	 *         already processed else false.
	 */
	private boolean isVisited( Class<?> sourceType, Class<?> targetType )
	{
		int x = typeList.indexOf(sourceType);
		int y = typeList.indexOf(targetType);
		return matrix[x][y];
	}

	/**
	 * Clears map and typeList and then adds all types on the map to typeList.
	 * 
	 * @param theMap
	 */
	private void init( Map<Class<?>, Map<Class<?>, Converter>> theMap )
	{

		typeList.clear();
		map.clear();
		map.putAll(theMap);

		for ( Class<?> sourceType : map.keySet() )
		{
			typeList.add(sourceType);

			for ( Class<?> targetType : map.get(sourceType).keySet() )
			{
				typeList.add(targetType);
			}
		}
	}

	public Map<Class<?>, Map<Class<?>, Converter>> getMap()
	{
		return map;
	}

}
