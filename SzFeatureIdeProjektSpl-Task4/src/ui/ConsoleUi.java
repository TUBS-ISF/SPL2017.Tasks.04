package ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import converter.KonverterTypePlugin;
import converter.NotSupportedException;
import converter.ui.console.ConsoleUiPlugin;
import converter.ui.console.MenuHelper;

public class ConsoleUi implements MenuHelper {
	boolean featureParseType = false; //TODO - default is let user choose
	Map<Integer, ConsoleUiPlugin> chosenKonverterFeature;

	private List<String> typeMenuEntries;
	
//	private List<KonverterTypePlugin> konverterList; 
//	private List<ConsoleUiPlugin> konverterMenuList;
	
	public ConsoleUi(List<KonverterTypePlugin> konverterList, List<ConsoleUiPlugin> konverterMenuList){
		init(false, konverterList, konverterMenuList);
	}
	

	public ConsoleUi(boolean parseType){
		init(parseType, null, null);
	}

	
	
	private void init(boolean parseType, 
			List<KonverterTypePlugin> konverterList, 
			List<ConsoleUiPlugin> konverterMenuList) 
	{
		
//		this.konverterList = konverterList;
//		this.konverterMenuList = konverterMenuList;
		
		chosenKonverterFeature = new HashMap<>();
		typeMenuEntries = new ArrayList<>();
		
		int counter = 1;
		for (ConsoleUiPlugin consoleUiPlugin : konverterMenuList) {
			String entry = "# " +counter+ ") " + consoleUiPlugin.getName();
			chosenKonverterFeature.put(counter, consoleUiPlugin);
			typeMenuEntries.add(entry);
			consoleUiPlugin.setMenuHelper(this);
			counter += 1;
		}
		
//		for (KonverterTypePlugin konverterPlugin : konverterList) {
//			
//		}
				
		featureParseType = parseType;
	}
	

	
	
	public void printMenu() throws NotSupportedException{
		String types = "";
		for (String entry : typeMenuEntries) {
			types += entry +"\n";
		}
		
		String menu = "######################################\n"
				+ "# Choose Conversion Type: <and press Enter>\n"
				+ types
				+ "######################################\n";
		
		System.out.println(menu);
		
		Scanner in = new Scanner(System.in);
		int chosenFeature = in.nextInt();
		
		showConversionTypeMenu(chosenFeature);
	}
	
	public void showConversionTypeMenu(int chosenFeature) throws NotSupportedException {
		if (chosenKonverterFeature.get(chosenFeature) == null) {
			System.err.println("Not available!");
		}
		ConsoleUiPlugin uiPlugin = chosenKonverterFeature.get(chosenFeature);
		uiPlugin.showMenu();
	}
	
	@Override
	public void printResult(double convertedValue,  String sourceType, String destType) {
		String menuDest = "######################################\n"
				+ "# The result of conversion (" + sourceType + " > " + destType + ")\n"
				+ "# " + convertedValue + " " + destType + "\n"
				+ "######################################\n";
		System.out.println(menuDest);
	}
	
	@Override
	public String generateAvailableConversionTypesMenuLines(KonverterTypePlugin konverterType, boolean isSourceType) {
		String typeTypeStr;
		if (isSourceType) {
			typeTypeStr = "source";
		} else {
			typeTypeStr = "destination";
		}
		String menuTop = "######################################\n"
						+ "# please provide " + typeTypeStr + " type\n";
				
				
		String menuBottom = "######################################\n";
		
		String typeLines = "";
		int i = 0;
		for (String typeName : konverterType.getTypeNames()) {
			i  += 1;
			typeLines += "# "+i+") "+ typeName +"\n";
		}
		
		String menu = menuTop + typeLines + menuBottom;
		return menu;	
	}
	
	@Override
	public void printMenuPleaseProvideValueToConvert() {
		String menuValue = "######################################\n"
				+ "# please provide value to convert (e.g. 100) \n"
				+ "# ?\n"
				+ "######################################\n";
		System.out.println(menuValue);
	}
}
