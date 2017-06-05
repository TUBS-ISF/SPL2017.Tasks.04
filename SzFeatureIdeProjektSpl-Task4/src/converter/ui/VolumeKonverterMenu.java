package converter.ui;

import java.util.Scanner;

import converter.KonverterTypePlugin;
import converter.NotSupportedException;
import converter.VolumeConverter;

public class VolumeKonverterMenu implements ConsoleUiPlugin {
	private MenuHelper menuHelper;
	
	@Override
	public void setMenuHelper(MenuHelper menuHelper) {
		this.menuHelper = menuHelper;
		
	}

	@Override
	public void showMenu() throws NotSupportedException {
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
		menuHelper.printResult(convertedValue, sourceTypeStr, destTypeStr);
		
		
	}

	@Override
	public String getName() {
		return "Volume";
	}

}
