

import java.util.ArrayList;
import java.util.List;

public class TemperatureConverter implements ConverterTypePlugin {
	
	public enum TemperatureType {
	    Celsius, Fahrenheit, Kelvin
	} 

	@Override
	public double convert(double operand, String sourceType, String destinationType) throws NotSupportedException {
		if(sourceType.equals(TemperatureType.Celsius.name())) {
			return this.convFromCelsius(operand, destinationType);
		} 
		else if(sourceType.equals(TemperatureType.Fahrenheit.name())){
			return this.convFromFahrenheit(operand, destinationType); 
		}
		else if(sourceType.equals(TemperatureType.Kelvin.name())){
			return this.convFromKelvin(operand, destinationType);
		}

		throw new NotSupportedException("No supported conversion operation for sourceType: " + sourceType);
	}

	private double convFromCelsius(double operand, String destinationType) {
		if(destinationType.equals(TemperatureType.Celsius.name())) {
			return operand;
		}
		else if(destinationType.equals(TemperatureType.Kelvin.name())) {
			return operand + 273.15;
		} else {
			double fahrenheit = operand * 1.8 + 32;
			return fahrenheit;
		}
	}

	private double convFromFahrenheit(double operand, String destinationType) {
		double celsius = (operand - 32) * 5/9;
		if(destinationType.equals(TemperatureType.Fahrenheit.name())) {
			return operand;
		}
		else if(destinationType.equals(TemperatureType.Kelvin.name())) {
			return celsius + 273.15;
		}
		
		return celsius;
	}
	
	private double convFromKelvin(double operand, String destinationType) {
		if(destinationType.equals(TemperatureType.Kelvin.name())) {
			return operand;
		}
		else if(destinationType.equals(TemperatureType.Celsius.name())) {
			return operand - 273.15;
		}
		else if(destinationType.equals(TemperatureType.Fahrenheit.name())) {
			return convFromCelsius(operand - 273.15, destinationType) ;
		}
		return -1.0;
	}

	@Override
	public List<String> getTypeNames() {
		List<String> names = new ArrayList<String>();
		for (TemperatureConverter.TemperatureType type : TemperatureConverter.TemperatureType.values()) {
			names.add(type.name());
		}
		return names;
	}
	
	@Override
	public String getName() {
		return "Temperature";
	}
	
	@Override
	public Enum<?>[] getConverterTypesEnum() {
		return TemperatureType.values();
	}

}

