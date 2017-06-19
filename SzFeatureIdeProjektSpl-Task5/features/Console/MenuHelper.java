public interface MenuHelper {

	public String generateAvailableConversionTypesMenuLines(ConverterTypePlugin konverterType, boolean isSourceType);
	void printResult(double convertedValue,  String sourceType, String destType);
	public void printMenuPleaseProvideValueToConvert();
}
