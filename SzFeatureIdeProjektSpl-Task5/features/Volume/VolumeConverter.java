

import java.util.ArrayList;
import java.util.List;

public class VolumeConverter implements ConverterTypePlugin {
	
	public enum VolumeType {
	    m2, cm2 
	} 

	@Override
	public double convert(double operand, String sourceType, String destinationType) throws NotSupportedException {
		if(sourceType.equals(VolumeType.m2.name())) {
			return this.convM2(operand, destinationType);
		} 
		else if(sourceType.equals(VolumeType.cm2.name())){
			return this.convCm2(operand, destinationType); 
		}

		throw new NotSupportedException("No supported conversion operation for sourceType: " + sourceType);
	}

	private double convCm2(double operand, String destinationType) {
		double dummy = 42;
		return dummy;
	}

	private double convM2(double operand, String destinationType) {
		double dummy = 42;
		return dummy;
	}

	@Override
	public List<String> getTypeNames() {
		List<String> names = new ArrayList<String>();
		for (VolumeType type : VolumeType.values()) {
			names.add(type.name());
		}
		return names;
	}
	
	@Override
	public String getName() {
		return "Volume";
	}
}
