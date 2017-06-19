import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NotSupportedException {
		original(args);
		
		System.out.println("Temperature Feature Active");
		activatedConverterFeatures.konverterList.add(new TemperatureConverter());
		activatedConverterFeatures.konverterMenuList.add(new TemperatureConverterMenu());
	}

}
