package converter;

import java.util.ArrayList;
import java.util.List;

public class MassConverter implements KonverterTypePlugin {
	
	public enum MassType {
	    g, kg
	} 

	@Override
	public double convert(double operand, String sourceType, String destinationType) throws NotSupportedException {
		if(sourceType.equals(MassType.g.name())) {
			return this.convG(operand, destinationType);
		} 
		else if(sourceType.equals(MassType.kg.name())){
			return this.convKg(operand, destinationType); 
		}

		throw new NotSupportedException("No supported conversion operation for sourceType: " + sourceType);
	}

	private double convKg(double operand, String destinationType) {
		double dummy = 42*42;
		return dummy;
	}

	private double convG(double operand, String destinationType) {
		double dummy = 42;
		return dummy;
	}

	@Override
	public List<String> getTypeNames() {
		List<String> names = new ArrayList<>();
		for (MassConverter.MassType massType : MassConverter.MassType.values()) {
			names.add(massType.name());
		}
		return names;
	}
	
	@Override
	public String getName() {
		return "Mass";
	}
	

}

