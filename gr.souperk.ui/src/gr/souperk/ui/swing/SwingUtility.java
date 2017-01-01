package gr.souperk.ui.swing;

import gr.souperk.ui.input.keyboard.SwingKeyboard;
import gr.souperk.ui.input.mouse.SwingMouse;

public class SwingUtility
{
	public static SwingKeyboard getKeyboard()
	{
		return new SwingKeyboard();
	}

	public static SwingMouse getMouse()
	{
		return new SwingMouse();
	}
}
