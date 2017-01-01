/**
 * 
 */
package gr.genemons.client.entity;

import gr.genemons.client.SimpleLogger;
import gr.genemons.share.bean.GhostBean;
import gr.souperk.games.graphics.Animation;
import gr.souperk.utils.State;
import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.configure.SettingPriority;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class ClientGhost
		extends NPC
{
	@Setting(key = "genemons.client.entity.ghost.animation.walking.up", priority = SettingPriority.ERROR)
	public static Animation walkingUpAnimation;

	@Setting(key = "genemons.client.entity.ghost.animation.walking.down", priority = SettingPriority.ERROR)
	public static Animation walkingDownAnimation;

	@Setting(key = "genemons.client.entity.ghost.animation.walking.right", priority = SettingPriority.ERROR)
	public static Animation walkingRightAnimation;

	@Setting(key = "genemons.client.entity.ghost.animation.walking.left", priority = SettingPriority.ERROR)
	public static Animation walkingLeftAnimation;

	@Setting(key = "genemons.client.entity.ghost.animation.idle-up", priority = SettingPriority.ERROR)
	public static Animation idleUpAnimation;

	@Setting(key = "genemons.client.entity.ghost.animation.idle-down", priority = SettingPriority.ERROR)
	public static Animation idleDownAnimation;

	@Setting(key = "genemons.client.entity.ghost.animation.idle-right", priority = SettingPriority.ERROR)
	public static Animation idleRightAnimation;

	@Setting(key = "genemons.client.entity.ghost.animation.idle-left", priority = SettingPriority.ERROR)
	public static Animation idleLeftAnimation;

	private GhostBean bean;

	public ClientGhost(GhostBean bean)
	{
		super(bean);
		this.bean = bean;
	}

	@Override
	public Animation getAnimation()
	{
		State state = getState();
		Animation anim = null;

		if (state.equals(NPC.idleState))
		{
			switch ((int) getDirection()) {
			case NPC.UP_DIRECTION:
				anim = idleUpAnimation;
				break;
			case NPC.DOWN_DIRECTION:
				anim = idleDownAnimation;
				break;
			case NPC.RIGHT_DIRECTION:
				anim = idleRightAnimation;
				break;
			case NPC.LEFT_DIRECTION:
				anim = idleLeftAnimation;
				break;
			default:
				break;

			}
		} else if (state.equals(Player.walkingState))
		{
			switch ((int) getDirection()) {
			case NPC.UP_DIRECTION:
				anim = walkingUpAnimation;
				break;
			case NPC.DOWN_DIRECTION:
				anim = walkingDownAnimation;
				break;
			case NPC.RIGHT_DIRECTION:
				anim = walkingRightAnimation;
				break;
			case NPC.LEFT_DIRECTION:
				anim = walkingLeftAnimation;
				break;
			default:
				break;
			}
		}

		SimpleLogger.assertLog(anim == null, "Unknown state or direction of Ghost. getAnimation() returns null.");

		return anim;
	}

	// @Override
	// public void triggerEvent(ActionEvent event)
	// {
	// super.triggerEvent(event);
	//
	// if (event == null || event.isDisposed())
	// return;
	// }

	public GhostBean toBean()
	{
		return bean;
	}
}