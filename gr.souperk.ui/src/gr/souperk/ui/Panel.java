package gr.souperk.ui;

import gr.souperk.ui.layout.Layout;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class Panel
		extends AbstractContainer
		implements Container
{
	public Panel()
	{
		super();
	}

	public Panel(Layout layout)
	{
		super(layout);
	}

	public Panel(String ID)
	{
		super(ID);
	}

	public Panel(String ID, Layout layout)
	{
		super(ID, layout);
	}

	public void setShowDecoration(boolean showDecoration)
	{
		this.showDecoration = showDecoration;
		invalidate();
	}
}
