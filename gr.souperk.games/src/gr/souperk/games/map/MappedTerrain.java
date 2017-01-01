package gr.souperk.games.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @since 0.1.0
 * @author souperk
 *
 */
// TODO write javadoc.
public class MappedTerrain
		implements Terrain
{
	protected final Map<Coords, Tile> tileMap;

	protected final Tile defaultTile;

	public MappedTerrain(Map<Coords, Tile> tileMap, Tile defaultTile)
	{
		if (tileMap == null)
			throw new IllegalArgumentException("tileMap was not supposed to be null.");
		this.tileMap = tileMap;

		if (defaultTile == null)
			throw new IllegalArgumentException("defaultTile was not supposed to be null.");
		this.defaultTile = defaultTile;

	}

	public Tile getTile(int x, int y)
	{
		return getTile(new Coords(x, y));
	}

	public Tile getTile(Coords coords)
	{
		Tile t = tileMap.get(coords);

		if (t == null)
			return defaultTile;

		return t;
	}

	/**
	 * @return All the Tiles in the given rectangle.
	 */
	public List<Coords> getTiles(int x1, int y1, int x2, int y2)
	{
		return getTiles(new Coords(x1, y1), new Coords(x2, y2));
	}

	@Override
	public List<Coords> getTiles(Coords c1, Coords c2)
	{
		List<Coords> list = new ArrayList<>();

		for (Coords c : tileMap.keySet())
		{
			if (c1.x <= c.x && c.x >= c2.x && c1.x <= c.y && c.y >= c2.y)
			{
				list.add(c);
			}
		}

		return list;
	}
}
