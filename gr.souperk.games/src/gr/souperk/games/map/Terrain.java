/**
 * 
 */
package gr.souperk.games.map;

import java.util.List;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public interface Terrain
{
	public List<Coords> getTiles(int x1, int y1, int x2, int y2);

	public List<Coords> getTiles(Coords c1, Coords c2);

	public Tile getTile(int x, int y);

	public Tile getTile(Coords coords);
}
