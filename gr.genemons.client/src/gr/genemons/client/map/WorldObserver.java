/**
 * 
 */
package gr.genemons.client.map;

import gr.genemons.client.entity.Entity;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public interface WorldObserver
{
	public void add(Entity entity);

	public void remove(Entity entity);
}
