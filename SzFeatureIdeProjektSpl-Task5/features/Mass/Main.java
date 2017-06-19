import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NotSupportedException {
		original(args);
		
		System.out.println("Mass Feature Active");
		activatedConverterFeatures.konverterList.add(new MassConverter());
		activatedConverterFeatures.konverterMenuList.add(new MassKonverterMenu());
	}

}
