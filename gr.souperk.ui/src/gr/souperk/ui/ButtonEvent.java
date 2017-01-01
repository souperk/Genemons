package gr.souperk.ui;

import gr.souperk.utils.State;
import gr.souperk.utils.events.ActionEvent;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class ButtonEvent
		extends ActionEvent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8154041977459154212L;
	
	protected String buttonID;
	protected State buttonState;

	public ButtonEvent(String buttonID, State buttonState)
	{
		super("button." + buttonState.getName() + "." + buttonID);

		this.buttonID = buttonID;
		this.buttonState = buttonState;
	}

	public String getButtonID()
	{
		return buttonID;
	}

	public State getButtonState()
	{
		return buttonState;
	}

}
