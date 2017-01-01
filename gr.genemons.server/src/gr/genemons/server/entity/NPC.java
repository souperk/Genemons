/**
 * 
 */
package gr.genemons.server.entity;

import gr.genemons.server.map.World;
import gr.genemons.share.bean.NPCBean;
import gr.souperk.utils.State;
import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.context.Context;
import gr.souperk.utils.events.ActionEvent;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class NPC
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

	
	private NPCBean bean;
	
	public NPC(NPCBean bean)
	{
		super(bean);
		this.bean = bean;
	}

	@Override
	public void update(Context ctx)
	{
		World world = ctx.get("world", World.class);
		
		int x = getX();
		int y = getY();

		if (getState().equals(NPC.walkingState))
		{

			// TODO improve direction mechanism.
			switch ((int) getDirection())
			{
			case NPC.DOWN_DIRECTION:
				setY(y + getSpeed());
				break;
			case NPC.UP_DIRECTION:
				setY(y - getSpeed());
				break;
			case NPC.RIGHT_DIRECTION:
				setX(x + getSpeed());
				break;
			case NPC.LEFT_DIRECTION:
				setX(x - getSpeed());
				break;
			}
		}

		if (world.collides(this))
		{
			setX(x);
			setY(y);
		}
	}

//	@Override
	public void triggerEvent(ActionEvent event)
	{
		if (event == null || event.isDisposed())
			return;

		if (event.name == null)
			return; // specific log ?

		String eventName = event.name;

		if (canChangeDirection())
		{
			setState(walkingState);
			if (eventName.equals("up"))
			{
				bean.setDirection(UP_DIRECTION);
				event.dispose();

				if (canMove())
					setState(walkingState);
			} else if (eventName.equals("down"))
			{
				bean.setDirection(DOWN_DIRECTION);
				event.dispose();

				if (canMove())
					setState(walkingState);
			} else if (eventName.equals("right"))
			{
				bean.setDirection(RIGHT_DIRECTION);
				event.dispose();

				if (canMove())
					setState(walkingState);

			} else if (eventName.equals("left"))
			{
				bean.setDirection(LEFT_DIRECTION);
				event.dispose();

				if (canMove())
					setState(walkingState);

			}
		}

		if (eventName.equals("idle"))
		{
			if (canStop())
				setState(idleState);

			event.dispose();
		}
	}

	protected boolean canStop()
	{
		return true;
	}

	protected boolean canMove()
	{
		return true;
	}

	protected boolean canChangeDirection()
	{
		State state = getState();

		return state.equals(idleState) || state.equals(walkingState);
	}

	public int getSpeed()
	{
		return bean.getSpeed();
	}

	public double getDirection()
	{
		return bean.getDirection();
	}

}
