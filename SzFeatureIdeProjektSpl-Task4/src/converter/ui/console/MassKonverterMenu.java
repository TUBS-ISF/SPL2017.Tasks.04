package converter.ui.console;

import java.util.Scanner;

import converter.KonverterTypePlugin;
import converter.MassConverter;
import converter.NotSupportedException;

public class MassKonverterMenu implements ConsoleUiPlugin {
	private MenuHelper menuHelper;
	
	@Override
	public void setMenuHelper(MenuHelper menuHelper) {
		this.menuHelper = menuHelper;
		
	}

	@Override
	public void showMenu() throws NotSupportedException {
		KonverterTypePlugin konv = new MassConverter();
		String menuSource = menuHelper.generateAvailableConversionTypesMenuLines(konv, true);
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
		
		String menuDest = menuHelper.generateAvailableConversionTypesMenuLines(konv, false);
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
		menuHelper.printResult(convertedValue, sourceTypeStr, destTypeStr);
		in.close();
		in2.close();
		in3.close();
		
	}

	@Override
	public String getName() {
		return "Mass";
	}

}