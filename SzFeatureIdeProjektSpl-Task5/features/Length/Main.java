import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class Main {
	

	public static void main(String[] args) throws NotSupportedException {
		
		
		System.out.println("Length Feature Active");
		activatedConverterFeatures.konverterList.add(new LengthKonverter());
		activatedConverterFeatures.konverterMenuList.add(new LengthKonverterMenu());
	}

}
