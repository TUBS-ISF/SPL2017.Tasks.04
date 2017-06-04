package plugins.ui;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import converter.KonverterTypePlugin;
//#if Length
import converter.LengthKonverter; //default, preprop directive not needed
//#endif
//#if Volume
import converter.VolumeConverter;
//#endif
//#if Mass
import converter.MassConverter;
//#endif
import converter.NotSupportedException;
import plugins.Plugin;

public class ConsoleUi implements Plugin {
	boolean featureParseType = false; //TODO - default is let user choose
	Map<Integer, String> chosenKonverterFeature;

	private List<String> typeMenuEntries;
	
	public ConsoleUi(){
		init(false);
	}
	
	//#if ParseType 
//@	public ConsoleUi(boolean parseType){
//@		init(parseType);
//@	}
	//#endif
	
	
	private void init(boolean parseType) {
		chosenKonverterFeature = new HashMap<>();
		featureParseType = parseType;
		int counter = 1;
		String lengthEntry = "# " +counter+ ") Length";
		chosenKonverterFeature.put(counter, "Length");
		//#if Volume
		counter += 1;
		String volumeEntry = "# " +counter+ ") Volume";
		chosenKonverterFeature.put(counter, "Volume");
		//#endif
		//#if Mass
		counter += 1;
		String massEntry = "# " +counter+ ") Mass";
		chosenKonverterFeature.put(counter, "Mass");
		//#endif
		typeMenuEntries = new ArrayList<>();
		
		typeMenuEntries.add(lengthEntry);
		//#if Volume
		typeMenuEntries.add(volumeEntry);
		//#endif
		//#if Mass
		typeMenuEntries.add(massEntry);
		//#endif
		
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
		if (chosenKonverterFeature.get(chosenFeature).equals("Length")) {
			this.showLengthMenu();
		}
		//#if Mass
		else if (chosenKonverterFeature.get(chosenFeature).equals("Mass")) {
			this.showMassMenu();
		}
		//#endif
		//#if Volume
		else if (chosenKonverterFeature.get(chosenFeature).equals("Volume")) {
			this.showVolumeMenu();
		}
		//#endif
		
//		switch (chosenFeature) {
//		case 1: 
//			this.showLengthMenu();
//			break;
//		//#if Volume
//		case 2:
//			this.showVolumeMenu();
//			break;
//		//#endif
//		//#if Mass
//		case 2:
//			this.showMassMenu();
//			break;
//		//#endif
//		default:
//			System.err.println("Not available!");
//			break;
//		}
		
	}
	
	//#if Volume
	private void showVolumeMenu() throws NotSupportedException {
		String menuSource = "######################################\n"
				+ "# please provide source type\n"
				+ "# 1) m^2\n"
				+ "# 2) cm^2\n"
				+ "######################################\n";
		System.out.println(menuSource);
		
		Scanner in = new Scanner(System.in);
		int sourceType = in.nextInt();
		String sourceTypeStr;
		switch (sourceType) {
		case 1:
			sourceTypeStr = "m2";
			break;
		case 2:
			sourceTypeStr = "cm2";
			break;
		default:
			sourceTypeStr = "not found";
			break;
		}
		System.out.println("Chosen source type: " + sourceTypeStr);
		
		String menuDest = "######################################\n"
				+ "# please provide output type\n"
				+ "# 1) m^2\n"
				+ "# 2) cm^2\n"
				+ "######################################\n";
		System.out.println(menuDest);
		
		Scanner in2 = new Scanner(System.in);
		int destType = in2.nextInt();
		String destTypeStr;
		switch (destType) {
		case 1:
			destTypeStr = "m2";
			break;
		case 2:
			destTypeStr = "cm2";
			break;
		
		default:
			destTypeStr = "not found";
			break;
		}
		System.out.println("Chosen destination type: " + destTypeStr);
		
		String menuValue = "######################################\n"
				+ "# please provide value to convert (e.g. 100,5) \n"
				+ "# ?\n"
				+ "######################################\n";
		System.out.println(menuValue);
		
		Scanner in3 = new Scanner(System.in);
		double valueToConvert = in3.nextDouble();
		
		KonverterTypePlugin konv = new VolumeConverter();
		double convertedValue = konv.convert(valueToConvert, sourceTypeStr, destTypeStr);
		this.printResult(convertedValue, sourceTypeStr, destTypeStr);
		
	}
	//#endif
	
	//#if Mass
	private void showMassMenu() throws NotSupportedException {
		KonverterTypePlugin konv = new MassConverter();
		String menuSource = generateAvailableConversionTypesMenuLines(konv, true);
		System.out.println(menuSource);
		
		Scanner in = new Scanner(System.in);
		int sourceType = in.nextInt();
		String sourceTypeStr;
		switch (sourceType) { //TODO Refactor more generic
		case 1:
			sourceTypeStr = MassConverter.MassType.g.name();;
			break;
		case 2:
			sourceTypeStr = MassConverter.MassType.kg.name();;
			break;
		default:
			sourceTypeStr = "not found";
			break;
		}
		System.out.println("Chosen source type: " + sourceTypeStr);
		
		String menuDest = generateAvailableConversionTypesMenuLines(konv, false);
		System.out.println(menuDest);
		
		Scanner in2 = new Scanner(System.in);
		int destType = in2.nextInt();
		String destTypeStr;
		switch (destType) {//TODO Refactor more generic
		case 1:
			destTypeStr = MassConverter.MassType.g.name();
			break;
		case 2:
			destTypeStr = MassConverter.MassType.kg.name();
			break;
		
		default:
			destTypeStr = "not found";
			break;
		}
		System.out.println("Chosen destination type: " + destTypeStr);
		
		String menuValue = "######################################\n"
				+ "# please provide value to convert (e.g. 100,5) \n"
				+ "# ?\n"
				+ "######################################\n";
		System.out.println(menuValue);
		
		Scanner in3 = new Scanner(System.in);
		double valueToConvert = in3.nextDouble();
		
		
		double convertedValue = konv.convert(valueToConvert, sourceTypeStr, destTypeStr);
		this.printResult(convertedValue, sourceTypeStr, destTypeStr);
		in.close();
		in2.close();
		in3.close();
				
	}
	//#endif
	
	public void showLengthMenu() throws NotSupportedException{
		KonverterTypePlugin lengthKonv = new LengthKonverter();
		String menuSource = "######################################\n"
				+ "# please provide source type\n"
				+ "# 1) m\n"
				+ "# 2) km\n"
				+ "######################################\n";
		System.out.println(menuSource);
		
		Scanner in = new Scanner(System.in);
		int sourceType = in.nextInt();
		String sourceTypeStr;
		switch (sourceType) {
		case 1:
			sourceTypeStr = LengthKonverter.LengthType.m.name();
			break;
		case 2:
			sourceTypeStr = LengthKonverter.LengthType.km.name();
			break;
		default:
			sourceTypeStr = "not found";
			break;
		}
		System.out.println("Chosen source type: " + sourceTypeStr);
		
		String menuDest = generateAvailableConversionTypesMenuLines(lengthKonv, false);
		System.out.println(menuDest);
		
		Scanner in2 = new Scanner(System.in);
		int destType = in2.nextInt();
		String destTypeStr;
		switch (destType) {
		case 1:
			destTypeStr = "m";
			break;
		case 2:
			destTypeStr = "km";
			break;
		case 3:
			destTypeStr = "mm";
			break;
		case 4:
			destTypeStr = "cm";
			break;

		default:
			destTypeStr = "not found";
			break;
		}
		System.out.println("Chosen destination type: " + destTypeStr);
		
		String menuValue = "######################################\n"
				+ "# please provide value to convert (e.g. 100,5)\n"
				+ "# ?\n"
				+ "######################################\n";
		System.out.println(menuValue);
		
		Scanner in3 = new Scanner(System.in);
		double valueToConvert = in3.nextDouble();
		
		
		double convertedValue = lengthKonv.convert(valueToConvert, sourceTypeStr, destTypeStr);
		this.printResult(convertedValue, sourceTypeStr, destTypeStr);

	}
	
	private void printResult(double convertedValue,  String sourceType, String destType) {
		String menuDest = "######################################\n"
				+ "# The result of conversion (" + sourceType + " > " + destType + ")\n"
				+ "# " + convertedValue + " " + destType + "\n"
				+ "######################################\n";
		System.out.println(menuDest);
	}
	
	private String generateAvailableConversionTypesMenuLines(KonverterTypePlugin konverterType, boolean isSourceType) {
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
}
