/**
 * 
 */
package gr.genemons.server.entity;

import gr.genemons.share.bean.GhostBean;
import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.configure.SettingPriority;

import java.awt.image.BufferedImage;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class Ghost
		extends NPC
{

	@Setting(key = "genemons.server.entity.ghost.mask", priority = SettingPriority.ERROR)
	public static BufferedImage PLAYER_MASK;

	private GhostBean bean;

	public Ghost(GhostBean bean)
	{
		super(bean);
		this.bean = bean;
	}
}
