package gr.souperk.utils.context.translate;

import gr.souperk.utils.StringUtils;

/**
 * 
 * @since 0.1.0
 * @author souperk
 *
 */
public class PrefixKeyTranslator
		extends KeyTranslator
{
	private String prefix;

	public PrefixKeyTranslator(String thePrefix)
	{
		this.prefix = thePrefix;
	}

	/**
	 * @param key
	 *            the key to be translated
	 * @return if prefix is null returns the key else returns prefix + "." + key
	 *         .
	 */
	@Override
	public String translateKey(String key)
	{
		if (StringUtils.isBlank(prefix))
			return key;
		return prefix + "." + key;
	}

}
