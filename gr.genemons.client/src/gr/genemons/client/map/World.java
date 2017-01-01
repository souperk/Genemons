/**
 * 
 */
package gr.genemons.client.map;

import gr.genemons.client.Camera;
import gr.genemons.share.bean.WorldBean;
import gr.souperk.ui.GraphicsDevice;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class World
{
	private WorldBean worldBean;
	
	public World(WorldBean worldBean)
	{
		this.worldBean = worldBean;
	}

	public void render(GraphicsDevice graphicsDevice, Camera camera)
	{
		//TODO implement.
	}

	public String getId()
	{
		return worldBean.getId();
	}
	
	public WorldBean toBean()
	{
		return worldBean;
	}
	
	

}
