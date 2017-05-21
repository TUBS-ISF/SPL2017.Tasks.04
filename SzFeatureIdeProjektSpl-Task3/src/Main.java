import java.lang.System;

import converter.NotSupportedException;

//#if Console 
import ui.ConsoleUi;
//#endif

public class Main {
	


	public static void main(String[] args) throws NotSupportedException {
		System.out.println("Start...");
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
		
		//============= Feature activation =============
		//#if Console 
		uiTypeConsole = true;
		System.out.println("Console Feature Active");
		//#endif
		
		//#if Graphical 
//@		uiTypeGraphical = true;
//@		System.out.println("Graphical Feature Active");
		//#endif
		
		//#if OutputSingle 
		ioSingleValueOutputSingle = true;
		System.out.println("OutputSingle Feature Active");
		//#endif
		
		//#if OutputMultiple 
//@		ioSingleValueOutputMultiple = true;
//@		System.out.println("OutputMultiple Feature Active");
		//#endif
		
		//#if MultipleValues 
//@		ioMultipleValues = true;
//@		System.out.println("MultipleValues Feature Active");
		//#endif
		
		//#if LetUserChoose 
		letUserChoose = true;
		System.out.println("LetUserChoose Feature Active");
		//#endif
		
		//#if ParseType 
//@		parseType = true;
//@		System.out.println("ParseType Feature Active");
		//#endif
		
		//#if Length 
		converterLength = true;
		System.out.println("Length Feature Active");
		//#endif
		
		//#if Volume 
		converterVolume = true;
		System.out.println("Volume Feature Active");
		//#endif
		
		//#if Mass 
		converterMass = true;
		System.out.println("Mass Feature Active");
		//#endif
		//============= Feature activation /> =============
		
		
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
