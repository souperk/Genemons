package gr.souperk.utils.context.translate;

import java.util.Map;

/**
 * 
 * @author kostas
 *
 */
// TODO write javadoc.
public class MappedKeyTranslator
		extends KeyTranslator
{
	private Map<String, String> map;

	public MappedKeyTranslator(Map<String, String> theMap)
	{
		this.map = theMap;
	}

	@Override
	public String translateKey(String key)
	{
		if (map.containsKey(key))
			return map.get(key);

		return key;
	}

}
