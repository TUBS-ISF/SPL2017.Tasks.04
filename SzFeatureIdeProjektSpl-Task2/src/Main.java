import java.lang.System;

import converter.NotSupportedException;
import properties.PropertyManager;
import ui.ConsoleUi;


public class Main {
	


	public static void main(String[] args) throws NotSupportedException {
		System.out.println("Start...");
		boolean converterLength = PropertyManager.getProperty("Length");
		boolean converterVolume = PropertyManager.getProperty("Volume");
		System.out.println("converterLength " + converterLength);
		System.out.println("converterVolume " + converterVolume);
		
		boolean letUserChoose = PropertyManager.getProperty("LetUserChoose");
		boolean parseType = PropertyManager.getProperty("ParseType");
		
		
		boolean ioSingleValueOutputSingle = PropertyManager.getProperty("OutputSingle");
		//boolean ioSingleValueOutputMultiple = PropertyManager.getProperty("OutputMultiple");
		//boolean ioMultipleValues = PropertyManager.getProperty("MultipleValues");

		boolean uiTypeConsole = PropertyManager.getProperty("Console");
		//boolean uiTypeGraphical = PropertyManager.getProperty("Graphical");
		
		if(uiTypeConsole && ioSingleValueOutputSingle && letUserChoose) {
			System.out.println("uiTypeConsole && ioSingleValueOutputSingle");
			ConsoleUi ui = new ConsoleUi(converterLength, converterVolume, false);
			ui.printMenu();
		} 
		else if(uiTypeConsole && ioSingleValueOutputSingle && parseType) {
			System.out.println("uiTypeConsole && ioSingleValueOutputSingle");
			ConsoleUi ui = new ConsoleUi(converterLength, converterVolume, true);
			ui.printMenu();
		} 
//		else if(uiTypeConsole && ioSingleValueOutputMultiple) {
//			throw new NotSupportedException();
//		}
//		else if(uiTypeConsole && ioMultipleValues) {
//			throw new NotSupportedException();
//		}
//		else if(uiTypeGraphical) {
//			throw new NotSupportedException();
//		}

		System.out.println("The End");
	}

}
