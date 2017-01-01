package gr.genemons.share.networking;

import java.io.Serializable;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class AuthQuery
		implements Serializable
{
	private static final long serialVersionUID = 5630102418587800923L;

	private String username;
	private String password;

	public String getUsername()
	{
		return username;
	}

	public AuthQuery setUsername(String username)
	{
		this.username = username;
		
		return this;
	}

	public String getPassword()
	{
		return password;
	}

	public AuthQuery setPassword(String password)
	{
		this.password = password;
		
		return this;
	}

}
