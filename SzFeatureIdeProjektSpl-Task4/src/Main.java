import java.lang.System;
import java.util.ArrayList;
import java.util.List;

import converter.KonverterTypePlugin;
import converter.LengthKonverter;
import converter.MassConverter;
import converter.NotSupportedException;
import converter.SpeedConverter;
import converter.TemperatureConverter;
import converter.VolumeConverter;
import converter.ui.console.ConsoleUiPlugin;
import converter.ui.console.LengthKonverterMenu;
import converter.ui.console.MassKonverterMenu;
import converter.ui.console.SpeedConverterMenu;
import converter.ui.console.TemperatureKonverterMenu;
import converter.ui.console.VolumeKonverterMenu;
import ui.ConsoleUi;
import ui.GraphicalUi;

public class Main {
	
	/**
	 * The preprocessor antenna is used to activate the plugins
	 * 
	 * 
	 */


	public static void main(String[] args) throws NotSupportedException {
		System.out.println("Start...");
	
		List<KonverterTypePlugin> konverterList = new ArrayList<>();
		List<ConsoleUiPlugin> konverterMenuList = new ArrayList<>();
		
		//============= Plugin activation =============
		//#if Console 
		System.out.println("Console Plugin Active");
		//#endif
		
		//#if Graphical 
//@		System.out.println("Graphical Plugin Active");
		//#endif
		
		//#if OutputSingle 
		System.out.println("OutputSingle Plugin Active");
		//#endif
		
		//#if OutputMultiple 
//@		System.out.println("OutputMultiple Plugin Active");
		//#endif
		
		//#if MultipleValues 
//@		System.out.println("MultipleValues Plugin Active");
		//#endif
		
		//#if LetUserChoose 
		System.out.println("LetUserChoose Plugin Active");
		//#endif
		
		//#if ParseType 
//@		System.out.println("ParseType Plugin Active");
		//#endif
		
		//#if Length 
		konverterList.add(new LengthKonverter());
		konverterMenuList.add(new LengthKonverterMenu());
		System.out.println("Length Plugin Active");
		//#endif
		
		//#if Volume 
		konverterList.add(new VolumeConverter());
		konverterMenuList.add(new VolumeKonverterMenu());
		System.out.println("Volume Plugin Active");
		//#endif
		
		//#if Mass 
		konverterList.add(new MassConverter());
		konverterMenuList.add(new MassKonverterMenu());
		System.out.println("Mass Plugin Active");
		//#endif
		
		//#if Temperature 
		konverterList.add(new TemperatureConverter());
		konverterMenuList.add(new TemperatureKonverterMenu());
		System.out.println("Temperature Plugin Active");
		//#endif
		
		//#if Speed 
		konverterList.add(new SpeedConverter());
		konverterMenuList.add(new SpeedConverterMenu());
		System.out.println("Speed Plugin Active");
		//#endif
		//============= Plugin activation /> =============
		
		
		//#if Console 
		//#if LetUserChoose
		//#if OutputSingle
		ConsoleUi consoleUi = new ConsoleUi(konverterList, konverterMenuList);
		consoleUi.printMenu();
		//#endif
		//#endif
		//#endif
			

		
		//#if Graphical
//@		//Currently only one Converter Plugin is used in the graphical UI 
//@		GraphicalUi graphicalUi = new GraphicalUi(konverterList.get(0));
//@		//throw new NotSupportedException();
		//#endif

		System.out.println("The End");
	}

}
