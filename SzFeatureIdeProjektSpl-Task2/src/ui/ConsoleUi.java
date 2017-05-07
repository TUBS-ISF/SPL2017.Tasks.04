package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import converter.KonverterType;
import converter.LengthKonverter;
import converter.VolumeConverter;
import converter.NotSupportedException;

public class ConsoleUi {
	boolean featureParseType = false; //TODO - default is let user choose

	private List<String> typeMenuEntries;
	public ConsoleUi(boolean showLength, boolean showVolume, boolean parseType){
		featureParseType = parseType;
		String lengthEntry = "# 1) Length";
		String volumeEntry = "# 2) Volume";
		typeMenuEntries = new ArrayList<>();
		if(showLength) {
			typeMenuEntries.add(lengthEntry);
		}
		if(showVolume) {
			typeMenuEntries.add(volumeEntry);
		}
		
		
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
		switch (chosenFeature) {
		case 1: 
			this.showLengthMenu();
			break;
		case 2:
			this.showVolumeMenu();
			break;
		default:
			System.err.println("Not available!");
			break;
		}
		
	}
	
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
		
		KonverterType konv = new VolumeConverter();
		double convertedValue = konv.convert(valueToConvert, sourceTypeStr, destTypeStr);
		this.printResult(convertedValue, sourceTypeStr, destTypeStr);
		
	}

	public void showLengthMenu() throws NotSupportedException{
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
			sourceTypeStr = "m";
			break;
		case 2:
			sourceTypeStr = "km";
			break;
		default:
			sourceTypeStr = "not found";
			break;
		}
		System.out.println("Chosen source type: " + sourceTypeStr);
		
		String menuDest = "######################################\n"
				+ "# please provide output type\n"
				+ "# 1) m\n"
				+ "# 2) km\n"
				+ "# 3) mm\n"
				+ "# 4) cm\n"
				+ "######################################\n";
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
		
		KonverterType lengthKonv = new LengthKonverter();
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
}
