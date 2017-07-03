import java.util.Scanner;

public class GenericConverterMenu implements ConsoleUiPlugin {
	private MenuHelper menuHelper;
	private Enum<?>[] converterEnumTypes;
	
	GenericConverterMenu(MenuHelper menuHelper) {
		this.menuHelper = menuHelper;
	}

	@Override
	public void showMenu(ConverterTypePlugin konv, Enum<?>[] converterEnumTypes) throws NotSupportedException {
		//ConverterTypePlugin konv = new SpeedConverter();
		Enum<?>[] types = converterEnumTypes;
		
		String menuSource = menuHelper.generateAvailableConversionTypesMenuLines(konv, true);
		System.out.println(menuSource);
		
		Scanner in = new Scanner(System.in);
		int sourceTypeInt = in.nextInt() - 1;
		
		if (types.length < sourceTypeInt) {
			System.err.println("sourceType not found: " + sourceTypeInt);
			System.exit(-1);
		}
		
		Enum<?> sourceType = types[sourceTypeInt];
		System.out.println("Chosen source type: " + sourceType.name());
		
		String menuDest = menuHelper.generateAvailableConversionTypesMenuLines(konv, false);
		System.out.println(menuDest);
		
		Scanner in2 = new Scanner(System.in);
		int destTypeInt = in2.nextInt() - 1; //Numbering in menu starts at 1;
				
		if (types.length < destTypeInt) {
			System.err.println("destType not found: " + destTypeInt);
			System.exit(-1);
		}
		
		Enum<?> destType = types[destTypeInt];
		System.out.println("Chosen destination type: " + destType.name());
		
		menuHelper.printMenuPleaseProvideValueToConvert();
		
		Scanner in3 = new Scanner(System.in);
		double valueToConvert = in3.nextDouble();
		
		double convertedValue = konv.convert(valueToConvert, sourceType.name(), destType.name());
		menuHelper.printResult(convertedValue, sourceType.name(), destType.name());
		in.close();
		in2.close();
		in3.close();
		
	}

	@Override
	public void showMenu() throws NotSupportedException {
		throw new NotSupportedException();
		
	}

	@Override
	public void showMenu(ConverterTypePlugin konv) throws NotSupportedException {
		throw new NotSupportedException();
		
	}

}