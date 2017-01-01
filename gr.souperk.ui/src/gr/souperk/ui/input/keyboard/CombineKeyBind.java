package gr.souperk.ui.input.keyboard;

import gr.souperk.utils.events.ActionEvent;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class CombineKeyBind
		extends KeyBind
{
	public final KeyBind[] binds;

	public CombineKeyBind(String action, KeyBind... binds)
	{
		super(action, -1, -1);

		this.binds = binds;
	}

	@Override
	public ActionEvent update(KeyInputEvent keyEvent)
	{
		boolean changed = false;
		boolean failed = false;

		for (KeyBind bind : binds)
		{
			if (!bind.isActive())
			{
				bind.update(keyEvent);
				if (bind.isActive())
				{
					changed = true;
				} else
				{
					failed = true;
				}
			} else
			{
				bind.update(keyEvent);
				if (!bind.isActive())
				{
					failed = true;
				}
			}
		}

		if (changed && !failed)
			return new ActionEvent(action);

		return null;
	}
}
