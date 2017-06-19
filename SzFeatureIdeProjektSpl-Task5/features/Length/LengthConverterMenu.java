import java.util.Scanner;

public class LengthConverterMenu implements ConsoleUiPlugin {
	private MenuHelper menuHelper;
	
	public LengthConverterMenu() {
		//this.menuHelper = menuHelper;
	}
	

	@Override
	public void showMenu() throws NotSupportedException {
		ConverterTypePlugin lengthKonv = new LengthConverter();
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
			sourceTypeStr = LengthConverter.LengthType.m.name();
			break;
		case 2:
			sourceTypeStr = LengthConverter.LengthType.km.name();
			break;
		default:
			sourceTypeStr = "not found";
			break;
		}
		System.out.println("Chosen source type: " + sourceTypeStr);
		
		String menuDest = menuHelper.generateAvailableConversionTypesMenuLines(lengthKonv, false);
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
		menuHelper.printResult(convertedValue, sourceTypeStr, destTypeStr);
		//in1.close();
		in2.close();
		in3.close();
		
	}


	@Override
	public void setMenuHelper(MenuHelper menuHelper) {
		this.menuHelper = menuHelper;
	}


	@Override
	public String getName() {
		return "Length";
	}
	
	

}
