package converter.ui;

import converter.KonverterTypePlugin;

public interface MenuHelper {

	public String generateAvailableConversionTypesMenuLines(KonverterTypePlugin konverterType, boolean isSourceType);
	void printResult(double convertedValue,  String sourceType, String destType);
	public void printMenuPleaseProvideValueToConvert();
}
