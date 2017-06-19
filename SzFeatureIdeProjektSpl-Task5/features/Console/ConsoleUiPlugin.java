public interface ConsoleUiPlugin {

	public void setMenuHelper(MenuHelper menuHelper);
	public void showMenu() throws NotSupportedException;
	public String getName();
}
