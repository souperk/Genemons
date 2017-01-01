package gr.genemons.share.networking;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class EntityQuery
{
	protected String entityId;

	public EntityQuery(String entityId)
	{
		super();
		this.entityId = entityId;
	}

	public String getEntityId()
	{
		return entityId;
	}

}
