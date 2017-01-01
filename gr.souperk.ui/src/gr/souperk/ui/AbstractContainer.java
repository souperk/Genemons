package gr.souperk.ui;

import gr.souperk.ui.input.InputEvent;
import gr.souperk.ui.input.InputObserver;
import gr.souperk.ui.input.mouse.MouseInputEvent;
import gr.souperk.ui.layout.Layout;
import gr.souperk.utils.events.EventObserverManager;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public abstract class AbstractContainer
		extends AbstractComponent
		implements Container
{

	protected EventObserverManager<InputEvent> iom = new EventObserverManager<>();

	protected List<Component> childs = new CopyOnWriteArrayList<>();

	protected Map<String, Component> idMap = new ConcurrentHashMap<>();

	protected Layout layout;

	protected Component focusedComponent;

	public AbstractContainer()
	{
		super();
	}

	public AbstractContainer(String ID)
	{
		super(ID);
	}

	public AbstractContainer(Layout layout)
	{
		super();
		setLayout(layout);
	}

	public AbstractContainer(String ID, Layout layout)
	{
		super(ID);
		setLayout(layout);
	}

	@Override
	public Collection<Component> getChilds()
	{
		return childs;
	}

	@Override
	public void add(Component comp)
	{
		synchronized (childs)
		{

			if (idMap.containsKey(comp.getID()))
			{
				// component is already added.
				return;
			}

			// if comp already has a parent, remove it from its parent
			if (comp.getParent() != null && !comp.getParent().equals(this))
			{
				comp.getParent().remove(this);
				comp.getParent().invalidate();
			}

			// set the comp parent
			comp.setParent(this);
			invalidate();

			// register the comp
			childs.add(comp);
			idMap.put(comp.getID(), comp);
		}
	}

	@Override
	public Layout getLayout()
	{
		return layout;
	}

	@Override
	public void setLayout(Layout layout)
	{
		this.layout = layout;
	}

	@Override
	public void paint(GraphicsDevice graphics)
	{
		// have this on whole method or only on else body ?
		synchronized (childs)
		{
			if (isValid())
			{
				graphics.drawImage(0, 0, cache);
			} else
			{
				repaint(graphics);
				cache = graphics.getImage();
				this.valid = true;
			}
		}
	}

	protected void repaint(GraphicsDevice graphics)
	{
		lookAndFeel.paint(graphics, this);

		GraphicsDevice g = graphics.smaller(x, y, x + width, y + height);
		layout.layout(this, g);
	}

	@Override
	public void triggerEvent(InputEvent event)
	{
		if (event == null || event.isDisposed())
			return;

		InputEvent e = event;

		if (event instanceof MouseInputEvent)
		{
			MouseInputEvent me = (MouseInputEvent) e;
			e = new MouseInputEvent(me.x - x, me.y - y, me.button, me.status);
		}

		for (Component component : getChilds())
		{
			component.getInputObserver().triggerEvent(e);

			if (e.isDisposed() || !isValid())
			{
				event.dispose();
				return;
			}
		}

		iom.triggerEvent(event);

		if (e.isDisposed())
			event.dispose();
	}

	public void addInputObserver(InputObserver inputObserver)
	{
		iom.addObserver(inputObserver);
	}

	public void removeInputObserver(InputObserver inputObserver)
	{
		iom.removeObserver(inputObserver);
	}

	@Override
	public void remove(Component component)
	{
		remove(component.getID());
	}

	@Override
	public void remove(String ID)
	{
		synchronized (childs)
		{
			if (idMap.containsKey(ID))
			{
				childs.remove(idMap.get(ID));
				idMap.remove(ID);
				invalidate();
			}
		}
	}

	@Override
	public boolean contains(String ID)
	{
		return idMap.containsKey(ID);
	}

	@Override
	public void clear()
	{
		synchronized (childs)
		{
			childs.clear();
			idMap.clear();
			invalidate();
		}
	}

	@Override
	public Component getFocusedComponent()
	{
		return focusedComponent;
	}

	@Override
	public void setFocusedComponent(Component component)
	{
		synchronized (childs)
		{

			if (focusedComponent != null)
			{
				focusedComponent.setFocused(false);
			}

			this.focusedComponent = component;
			parent.setFocusedComponent(focusedComponent);
		}
	}
}
