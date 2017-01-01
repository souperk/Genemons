/**
 * 
 */
package gr.genemons.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author souperk
 * @since
 *
 */
// TODO write javadoc.
public class RenderingTest
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		ServerSocket socket = new ServerSocket(1100);

		Socket client = socket.accept();

		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		OutputStream out = client.getOutputStream();

		reader.readLine();
		reader.readLine();
		out.write(new String("player,souperk,first-world,-100,0,entity.player.idle,4,1\n").getBytes());
		out.flush();

		int i = 0;

		while (true)
		{
			out.write(new String("player,kostas,first-world,0,0,entity.player.idle,4,1\n").getBytes());
			out.write(new String("player,souperk,first-world,-100," + i + ",entity.player.walking,4,1\n").getBytes());
			out.flush();
			i += 4;
			Thread.sleep(40);
		}
		
	}
}
