import java.lang.System;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NotSupportedException {
		original(args);
		
		System.out.println("Power Feature Active");
		activatedConverterFeatures.konverterList.add(new PowerConverter());
		activatedConverterFeatures.konverterMenuList.add(new PowerConverterMenu());
	}

}
