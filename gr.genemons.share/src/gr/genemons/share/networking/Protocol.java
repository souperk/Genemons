package gr.genemons.share.networking;

/**
 * A Utility class containing various tokens.
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class Protocol
{
	/* Client Messages */
	public static final String AUTH_MESSAGE_HEADER = "genemons.protocol.auth";

	public static final String ENTITY_QUERY_HEADER = "genemons.protocol.entity.query";

	/* Server Messages */
	public static final String AUTH_SUCCESS_MESSAGE_HEADER = "genemons.protocol.auth.success";
	public static final String AUTH_FAIL_MESSAGE_HEADER = "genemons.protocol.auth.fail";

	public static final String SESSION_END_HEADER = "genemons.protocol.session.end";

	/* Shared. */
	public static final String ENTITY_NOT_FOUND_MESSAGE_HEADER = "genemons.protocol.entity.query";
}
