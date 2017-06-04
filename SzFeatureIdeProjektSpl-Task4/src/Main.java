import java.lang.System;

import converter.NotSupportedException;
import plugins.Plugin;
import plugins.ui.ConsoleUi;

public class Main {
	
	/**
	 * The preprocessor antenna is used to activate the plugins
	 * 
	 * 
	 */


	public static void main(String[] args) throws NotSupportedException {
		System.out.println("Start...");
		Plugin plugin;
		
		boolean uiTypeConsole = false;
		boolean uiTypeGraphical = false;
		boolean ioSingleValueOutputSingle = false;
		boolean ioSingleValueOutputMultiple = false;
		boolean ioMultipleValues = false;
		boolean letUserChoose = false;
		boolean parseType = false;
		boolean converterLength = false;
		boolean converterVolume = false;
		boolean converterMass = false;
		
		//============= Plugin activation =============
		//#if Console 
		uiTypeConsole = true;
		System.out.println("Console Plugin Active");
		plugin = new plugins.ui.ConsoleUi();
		//#endif
		
		//#if Graphical 
//@		uiTypeGraphical = true;
//@		System.out.println("Graphical Plugin Active");
		//#endif
		
		//#if OutputSingle 
		ioSingleValueOutputSingle = true;
		System.out.println("OutputSingle Plugin Active");
		//#endif
		
		//#if OutputMultiple 
//@		ioSingleValueOutputMultiple = true;
//@		System.out.println("OutputMultiple Plugin Active");
		//#endif
		
		//#if MultipleValues 
//@		ioMultipleValues = true;
//@		System.out.println("MultipleValues Plugin Active");
		//#endif
		
		//#if LetUserChoose 
		letUserChoose = true;
		System.out.println("LetUserChoose Plugin Active");
		//#endif
		
		//#if ParseType 
//@		parseType = true;
//@		System.out.println("ParseType Plugin Active");
		//#endif
		
		//#if Length 
		converterLength = true;
		System.out.println("Length Plugin Active");
		//#endif
		
		//#if Volume 
		converterVolume = true;
		System.out.println("Volume Plugin Active");
		//#endif
		
		//#if Mass 
		converterMass = true;
		System.out.println("Mass Plugin Active");
		//#endif
		//============= Plugin activation /> =============
		
		
		//#if Console 
		//#if LetUserChoose
		//#if OutputSingle
		ConsoleUi ui = new ConsoleUi();
		ui.printMenu();
		//#endif
		//#endif
		//#endif
			
		//#if Console 
		//#if LetUserChoose
		//#if OutputSingle
		//#if ParseType 
//@		ConsoleUi ui = new ConsoleUi(parseType);
//@		ui.printMenu();
		//#endif
		//#endif
		//#endif
		//#endif
		
		//#if Console 
		//#if LetUserChoose
		//#if OutputMultiple 
//@		throw new NotSupportedException();
		//#endif
		//#endif
		//#endif
		
		//#if Console 
		//#if LetUserChoose
		//#if MultipleValues 
//@		throw new NotSupportedException();
		//#endif
		//#endif
		//#endif
		
		//#if Graphical 
//@		throw new NotSupportedException();
		//#endif

		System.out.println("The End");
	}

}
