/**
 * 
 */
package gr.genemons.client.entity;

import gr.genemons.client.SimpleLogger;
import gr.genemons.share.bean.PlayerBean;
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
public class Player
		extends NPC
{
	@Setting(key = "genemons.entity.player.speed", priority = SettingPriority.ERROR)
	public static int playerSpeed = 4;

	@Setting(key = "genemons.entity.entity.state.talking")
	public static State talkingState = new State("player.talking");

	@Setting(key = "genemons.client.entity.player.animation.walking.up", priority = SettingPriority.ERROR)
	public static Animation walkingUpAnimation;

	@Setting(key = "genemons.client.entity.player.animation.walking.down", priority = SettingPriority.ERROR)
	public static Animation walkingDownAnimation;

	@Setting(key = "genemons.client.entity.player.animation.walking.right", priority = SettingPriority.ERROR)
	public static Animation walkingRightAnimation;

	@Setting(key = "genemons.client.entity.player.animation.walking.left", priority = SettingPriority.ERROR)
	public static Animation walkingLeftAnimation;

	@Setting(key = "genemons.client.entity.player.animation.idle-up", priority = SettingPriority.ERROR)
	public static Animation idleUpAnimation;

	@Setting(key = "genemons.client.entity.player.animation.idle-down", priority = SettingPriority.ERROR)
	public static Animation idleDownAnimation;

	@Setting(key = "genemons.client.entity.player.animation.idle-right", priority = SettingPriority.ERROR)
	public static Animation idleRightAnimation;

	@Setting(key = "genemons.client.entity.player.animation.idle-left", priority = SettingPriority.ERROR)
	public static Animation idleLeftAnimation;

	private PlayerBean bean;

	public Player(PlayerBean bean)
	{
		super(bean);
		this.bean = bean;
	}

	public Animation getAnimation()
	{
		State state = getState();
		Animation anim = null;

		if (state.equals(NPC.idleState) || state.equals(Player.talkingState))
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

		SimpleLogger.assertLog(anim == null, "Unknown state or direction of Player. getAnimation() returns null.");

		return anim;

	}

	// @Override
	// public void triggerEvent(ActionEvent event)
	// {
	// super.triggerEvent(event);
	//
	// if (event == null || event.isDisposed())
	// return;
	//
	// if (event.name.equals("talk"))
	// {
	// setState(talkingState);
	// }
	// }

	public PlayerBean getBean()
	{
		return bean;
	}

}
