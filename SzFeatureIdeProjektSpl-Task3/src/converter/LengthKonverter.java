package converter;
//#if Length 

import java.util.ArrayList;
import java.util.List;

public class LengthKonverter extends KonverterType {
	
	public enum LengthType {
	    m, km, mm, cm 
	} 

	@Override
	protected double operator(double operand, String sourceType, String destinationType) throws NotSupportedException {
		System.out.println("operand "+operand + " sourceType " + sourceType + " destinationType " + destinationType);
		if(operand < 0) {
			System.err.println("Value needs to be >= 0: " + destinationType + " not defined");
		}
		
		if(sourceType.equals(LengthType.m.name())) {
			return this.convM(operand, destinationType);
		} 
		else if(sourceType.equals(LengthType.km.name())){
			return this.convKm(operand, destinationType); 
		}
		//System.err.println("No supported conversion operation for sourceType: " + sourceType);
		throw new NotSupportedException("No supported conversion operation for sourceType: " + sourceType);
		//return -1;
	}

	@Override
	protected double operator(double operand1, double operand2, String sourceType, String destinationType) throws NotSupportedException {
		throw new NotSupportedException("NotSupportedException");
		//return -1.0;
	}
	
	private double convKm(double value, String destinationType) {
		return this.convM(value, destinationType, 1000);
	}
	
	private double convM(double value, String destinationType) {
		return this.convM(value, destinationType, 1.0);
	}
	
	private double convM(double value, String destinationType, double faktor) {
		//value = value / faktor;
		switch (LengthType.valueOf(destinationType)) {
		case m:
			return value * faktor;
		case km:
			return value * 0.001 * faktor;
		case mm:
			return value * (1/0.001) * faktor;
		case cm: 
			return value * (1/0.01) * faktor;

		default:
			System.err.println("Destination Type: " + destinationType + " not defined");
			return -1.0;
		}
	}
	
	@Override
	public List<String> getTypeNames() {
		List<String> names = new ArrayList<>();
		for (LengthType type : LengthType.values()) {
			names.add(type.name());
		}
		return names;
	}

}
//#endif
