import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static ActivatedConverterFeatures activatedConverterFeatures = new ActivatedConverterFeatures();

	public static void main(String[] args) throws NotSupportedException {
		System.out.println("Start...");
		//TODO Implement GUI (Refactor Console Menu Classes)
		System.out.println("Graphical Feature Active");
		original(args);
		
		
		
		//GraphicalUi graphicalUi = new GraphicalUi(activatedConverterFeatures.konverterList.get(0));

		System.out.println("The End");
		
		
	}
}
