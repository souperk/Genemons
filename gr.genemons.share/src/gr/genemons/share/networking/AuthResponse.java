package gr.genemons.share.networking;

import java.io.Serializable;

/**
 * @author souperk
 * @since 0.1.0
 */
// TODO write javadoc.
public class AuthResponse
	implements Serializable
{
	private static final long serialVersionUID = 3197202967921161401L;
	
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;

	private int status;

	public int getStatus()
	{
		return status;
	}

	public AuthResponse setStatus(int status)
	{
		this.status = status;
		
		return this;
	}

}
