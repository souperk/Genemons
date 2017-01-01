package gr.souperk.games.sound;

/**
 * 
 * @author souperk
 *
 */

// TODO write javadoc.
public interface AudioManager
{
	// TODO read about playing sound both in java and in theory.

	public void play(Sound sound, boolean repeat);

	public void stop(Sound sound);

	public void pause(Sound sound);
}
