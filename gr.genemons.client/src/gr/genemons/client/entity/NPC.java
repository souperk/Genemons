package gr.genemons.client.entity;

import gr.genemons.share.bean.NPCBean;
import gr.souperk.utils.State;
import gr.souperk.utils.configure.Setting;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public abstract class NPC
		extends Entity
{
	
	@Setting(key = "genemons.share.entity.npc.state.idle")
	public static State idleState = new State("entity.player.idle");

	@Setting(key = "genemons.share.entity.npc.state.walking")
	public static State walkingState = new State("entity.player.walking");

	public static final int UP_DIRECTION = 0;
	public static final int DOWN_DIRECTION = 1;
	public static final int RIGHT_DIRECTION = 2;
	public static final int LEFT_DIRECTION = 3;


	@Setting(key = "genemons.share.networking.npc.id")
	public static byte npc_entity_id = 0;

	private NPCBean bean;

	public NPC(NPCBean bean)
	{
		super(bean);
		this.bean = bean;
	}

	/* Getters. */

	public int getSpeed()
	{
		return bean.getSpeed();
	}

	public double getDirection()
	{
		return bean.getDirection();
	}
	
	public NPCBean toBean()
	{
		return bean;
	}

}
