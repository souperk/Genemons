/**
 * 
 */
package gr.genemons.client;


/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class StatisticsManager
{
//	protected GenemonsClient client = GenemonsClient.getInstance();

	protected long renderCount = 0;

	protected long lastTime = 0;

	public StatisticsManager(long nowTime)
	{
		this.lastTime = nowTime;
	}

	public void update()
	{

		long nowTime = GenemonsClient.getInstance().getTime();

		if (nowTime - lastTime > 1000)
		{
			SimpleLogger.info("Average fps : " + renderCount / ((nowTime - lastTime) / 1000));
			renderCount = 0;
			lastTime = nowTime;
		}
	}

	public void countRender()
	{
		renderCount++;
	}
}
