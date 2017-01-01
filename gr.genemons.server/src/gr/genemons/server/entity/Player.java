/**
 * 
 */
package gr.genemons.server.entity;

import gr.genemons.server.map.World;
import gr.genemons.share.bean.PlayerBean;
import gr.souperk.utils.State;
import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.configure.SettingPriority;
import gr.souperk.utils.events.ActionEvent;

import java.awt.image.BufferedImage;

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

	@Setting(key = "genemons.server.entity.player.mask", priority = SettingPriority.ERROR)
	public static BufferedImage PLAYER_MASK;

	private PlayerBean bean;

	public Player(PlayerBean bean)
	{
		super(bean);
		this.bean = bean;
	}

	@Override
	public void triggerEvent(ActionEvent event)
	{
		super.triggerEvent(event);

		if (event == null || event.isDisposed())
			return;

		if (event.name.equals("talk"))
		{
			setState(talkingState);
		}
	}
	
	public PlayerBean toBean()
	{
		return bean;
	}

}
