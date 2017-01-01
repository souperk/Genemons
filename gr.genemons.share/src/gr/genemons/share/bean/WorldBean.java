package gr.genemons.share.bean;

import java.io.Serializable;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class WorldBean
		implements Serializable
{
	private static final long serialVersionUID = 2486247164177753442L;

	private String id;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
