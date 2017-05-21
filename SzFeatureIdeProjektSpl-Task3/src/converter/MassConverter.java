package converter;

import java.util.ArrayList;
import java.util.List;

//#if Mass 
public class MassConverter extends KonverterType {
	
	public enum MassType {
	    g, kg
	} 

	@Override
	protected double operator(double operand, String sourceType, String destinationType) throws NotSupportedException {
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
	protected double operator(double operand1, double operand2, String sourceType, String destinationType)
			throws NotSupportedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getTypeNames() {
		List<String> names = new ArrayList<>();
		for (MassConverter.MassType massType : MassConverter.MassType.values()) {
			names.add(massType.name());
		}
		return names;
	}
	
	

}
//#endif
