public interface ConsoleUiPlugin {

	//public void setMenuHelper(MenuHelper menuHelper);
	public void showMenu() throws NotSupportedException;
	//public String getName();
	
	public void showMenu(ConverterTypePlugin konv) throws NotSupportedException;
	void showMenu(ConverterTypePlugin konv, Enum<?>[] converterEnumTypes) throws NotSupportedException;
}
