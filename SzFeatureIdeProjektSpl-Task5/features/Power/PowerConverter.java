import java.util.ArrayList;
import java.util.List;

public class PowerConverter implements ConverterTypePlugin {
	
	public enum PowerType {
	    W, kW, MW, PS
	} 

	@Override
	public double convert(double operand, String sourceType, String destinationType) throws NotSupportedException {
		if(sourceType.equals(PowerType.W.name())) {
			return this.convFromWatt(operand, destinationType);
		} 
		else if(sourceType.equals(PowerType.kW.name())){
			return this.convFromKiloWatt(operand, destinationType); 
		}
		
		else if(sourceType.equals(PowerType.MW.name())){
			return this.convFromMegaWatt(operand, destinationType); 
		}
		
		else if(sourceType.equals(PowerType.PS.name())){
			return this.convFromPs(operand, destinationType); 
		}
		

		throw new NotSupportedException("No supported conversion operation for sourceType: " + sourceType);
	}

	private double convFromWatt(double operand, String destinationType) {
		
		if(destinationType.equals(PowerType.kW.name())) {
			return operand / 1000; 
		}
		else if(destinationType.equals(PowerType.MW.name())) {
			return operand / (1000 * 1000);
		}
		else if(destinationType.equals(PowerType.PS.name())) {
			return convFromKiloWatt(operand / 1000, destinationType);
		} else {
			return operand;
		}
		
	}

	private double convFromKiloWatt(double operand, String destinationType) {
		if(destinationType.equals(PowerType.W.name())) {
			return operand * 1000; 
		}
		else if (destinationType.equals(PowerType.MW.name())) {
			return operand / 1000;
		}
		else if (destinationType.equals(PowerType.PS.name())) {
			return operand * 1.35962;
		} else {
			return operand;
		}
	}
	
	private double convFromMegaWatt(double operand, String destinationType) {
		if(destinationType.equals(PowerType.W.name())) {
			return operand / (1000*1000); 
		}
		else if (destinationType.equals(PowerType.kW.name())) {
			return operand / 1000;
		}
		else if (destinationType.equals(PowerType.PS.name())) {
			return convFromKiloWatt(operand * 1000, destinationType);
		} else {
			return operand;
		}
	}
	
	private double convFromPs(double operand, String destinationType) {
		if(destinationType.equals(PowerType.W.name())) {
			return operand * 1000 / 1.35962; 
		}
		else if (destinationType.equals(PowerType.kW.name())) {
			return operand / 1.35962;
		}
		else if (destinationType.equals(PowerType.MW.name())) {
			return operand * 1.35962 / 1000;
		} else {
			return operand;
		}
	}
	
	

	@Override
	public List<String> getTypeNames() {
		List<String> names = new ArrayList<String>();
		for (PowerType type : PowerType.values()) {
			names.add(type.name());
		}
		return names;
	}
	
	@Override
	public String getName() {
		return "Power";
	}
	

}

