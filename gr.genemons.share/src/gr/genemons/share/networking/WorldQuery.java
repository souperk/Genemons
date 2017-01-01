package gr.genemons.share.networking;

import java.io.Serializable;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class WorldQuery
	implements Serializable
{
	private static final long serialVersionUID = -8718081758546270018L;
	
	private String worldId;

	public String getWorldId()
	{
		return worldId;
	}

	public WorldQuery setWorldId(String worldId)
	{
		this.worldId = worldId;
		
		return this;
	}

	


}
