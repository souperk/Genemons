package gr.souperk.ui.input.keyboard;

/**
 * This implementation is specific for linux and aims to solve a bug where when
 * holding a key many key-pressed/key-released events are generated.<br>
 * <br>
 * The solution is pretty simple. We fire a timer every time the key is released
 * and if the key is pressed we stop the timer. When the timer stops counting we
 * release the key. The delay of the timer is 35 milliseconds which is above the
 * average interval between two key-released events. <br>
 * <br>
 * 
 * @author souperk
 *
 */
public class SwingLinuxKey
		extends Key
{
	/** The average delay between two key-released events. */
	public static final int repeatRate = 35;

	/** A timer. */
	protected KeyDelay delay = new KeyDelay(this);

	protected KeyObserver observer;

	/**
	 * Just calls the constructor of {@code Key}.
	 * 
	 * @param keycode
	 *            The keycode of the key based on the {@code KeyEvent} keycodes.
	 */
	public SwingLinuxKey(Integer keycode)
	{
		super(keycode);
	}

	/**
	 * Disables the flag of the timer and set time to 1.
	 */
	@Override
	public void press()
	{
		delay.flag = false;
		status = PRESSED;
		observer.triggerEvent(new KeyInputEvent(keycode, PRESSED));
	}

	/**
	 * Enables the flag of the timer and starts the timer. The timer after 35 ms
	 * changes the time to -1.
	 */
	@Override
	public void release()
	{
		delay.flag = true;
		new Thread(delay).start();
	}

	/**
	 * {@code KeyDelay} is a timer with a flag.
	 * 
	 * @author souperk
	 *
	 */
	public static class KeyDelay
			implements Runnable
	{
		private SwingLinuxKey key;
		public boolean flag = true;

		public KeyDelay(SwingLinuxKey key)
		{
			this.key = key;
		}

		@Override
		public void run()
		{
			try
			{
				Thread.sleep(SwingLinuxKey.repeatRate);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			if (flag)
			{
				key.status = RELEASED;
				key.observer.triggerEvent(new KeyInputEvent(key.keycode, RELEASED));
			}
		}
	}

	public void setObserver(KeyObserver observer)
	{
		this.observer = observer;
	}

}
