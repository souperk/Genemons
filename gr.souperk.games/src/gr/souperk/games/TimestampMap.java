package gr.souperk.games;

import java.util.TreeMap;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class TimestampMap
		extends TreeMap<Long, Timestamp>
{

	private static final long serialVersionUID = -1142014337494047214L;

	public void put(Timestamp stamp)
	{
		put(stamp.time, stamp);
	}

	public Timestamp getNearest(Long key)
	{
		Long tempKey = floorKey(key);

		if (tempKey != null)
			return get(floorKey(key));
		else
			return get(ceilingKey(key));
	}
}
