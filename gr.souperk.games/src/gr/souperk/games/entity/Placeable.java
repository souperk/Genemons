package gr.souperk.games.entity;

import gr.souperk.games.map.World;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public interface Placeable
{
	public int getX();

	public int getY();

	public World getWorld();
}
