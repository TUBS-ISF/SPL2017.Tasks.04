import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static ActivatedConverterFeatures activatedConverterFeatures = new ActivatedConverterFeatures();

	public static void main(String[] args) throws NotSupportedException {
		System.out.println("Start...");
		System.out.println("Console Feature Active");
		original(args);
		
		
		
		ConsoleUi consoleUi = new ConsoleUi(activatedConverterFeatures.konverterList,
											activatedConverterFeatures.konverterMenuList);
		consoleUi.printMenu();

		System.out.println("The End");
		
		
	}
}
