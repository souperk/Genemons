package gr.souperk.games;

import gr.souperk.utils.State;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public abstract class Service
		implements Runnable
{
	/*
	 * TODO think of this.
	 * 
	 * For terminating Services I should create a two phase policy.
	 * 
	 * Upon deciding the termination of a Service, it "soft-stop" method will be
	 * called and the service will be entered in a "hard-stop" queue, if the
	 * service is not fully stopped by the end of a fixed time period the
	 * hard-stop method of the service will be called.
	 */

	public static final State RUNNING = new State("gr.souperk.game.networking.service.running");
	public static final State PAUSED = new State("gr.souperk.game.networking.service.paused");
	public static final State STOPPED = new State("gr.souperk.game.networking.service.stopped");

	protected State state = STOPPED;

	protected Thread thread;

	public void start()
	{
		if (thread != null)
			return;

		setState(RUNNING);
		thread = new Thread(this);
		thread.start();

	}

	public void pause()
	{
		setState(PAUSED);
	}

	public void resume()
	{
		if (getState().equals(PAUSED))
			setState(RUNNING);
	}

	public void stop()
	{
		setState(STOPPED);
	}

	@Override
	public void run()
	{
		while (!state.equals(STOPPED))
		{
			if (state.equals(RUNNING))
				execute();
		}

		thread = null;
	}

	public abstract void execute();

	public State getState()
	{
		return state;
	}

	protected void setState(State state)
	{
		this.state = state;
	}

}
