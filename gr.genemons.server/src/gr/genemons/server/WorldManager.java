package gr.genemons.server;

import gr.genemons.server.entity.Entity;
import gr.genemons.server.map.World;
import gr.souperk.utils.context.Context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class WorldManager
{

	protected Map<String, Entity> entityMap;
	protected Map<String, World> worldMap;

	public void load(Context resources)
	{
		loadWorlds(resources);
		loadEntities(resources);
	}

	protected void loadWorlds(Context resources)
	{
		Iterator<String> it = resources.keyIterator("genemons.map");
		worldMap = new HashMap<String, World>();

		while (it.hasNext())
		{
			String key = it.next();

			if (key.substring("genemons.map".length() + 1).contains("."))
				continue;

			World world = resources.get(key, World.class);

			worldMap.put(world.getId(), world);
		}
	}

	protected void loadEntities(Context resources)
	{
		Iterator<String> it = resources.keyIterator("genemons.entity");

		entityMap = new HashMap<String, Entity>();

		while (it.hasNext())
		{
			String key = it.next();

			/* TODO this looks ugly, fix it! */
			if (key.substring("genemons.entity".length() + 1).contains("."))
				continue;

			Entity entity = resources.get(key, Entity.class);

			entityMap.put(entity.getId(), entity);
		}

	}

	public void update(Context ctx)
	{
		for (World world : worldMap.values())
		{
			world.update(ctx);
		}
	}

	public Iterator<Entity> entityIterator()
	{
		return entityMap.values().iterator();
	}

	public Entity getEntity(String id)
	{
		return entityMap.get(id);
	}

	public Iterator<World> worldIterator()
	{
		return worldMap.values().iterator();
	}

	public World getWorld(String id)
	{
		return worldMap.get(id);
	}

}
