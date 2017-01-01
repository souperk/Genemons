package gr.souperk.utils.configure;

/**
 * ERROR : if the Setting contains no value the game will crush. <br>
 * <br>
 * WARNING : if the Setting contains no value a new log entry will created.<br>
 * <br>
 * INFO : if the Setting contains no value no action will be taken.
 * 
 * @author kostas
 *
 */
public enum SettingPriority {
	ERROR, WARNING, INFO;

	public SettingPriority cmp(SettingPriority priority)
	{
		if (priority == null)
			return this;

		if (this == ERROR || priority == ERROR)
			return ERROR;
		if (this == WARNING || priority == WARNING)
			return WARNING;
		return INFO;
	}
}
