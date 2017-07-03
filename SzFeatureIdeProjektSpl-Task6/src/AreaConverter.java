import java.util.ArrayList;
import java.util.List;

public class AreaConverter implements ConverterTypePlugin {
	
	public enum Type {
	   m2, ha
	} 

	@Override
	public double convert(double operand, String sourceType, String destinationType) throws NotSupportedException {
		if(sourceType.equals(Type.m2.name())) {
			return this.convFromM2(operand, destinationType);
		} 
		else if(sourceType.equals(Type.ha.name())){
			return this.convFromHa(operand, destinationType); 
		}
		

		throw new NotSupportedException("No supported conversion operation for sourceType: " + sourceType);
	}

	private double convFromM2(double operand, String destinationType) {
		if(destinationType.equals(Type.ha.name())) {
			return operand/100;
		} else {
			return operand;
		}
	}

	private double convFromHa(double operand, String destinationType) {
		if(destinationType.equals(Type.m2.name())) {
			return operand * 100;
		} else {
			return operand;
		}
	}
	
	

	@Override
	public List<String> getTypeNames() {
		List<String> names = new ArrayList<String>();
		for (Type type : Type.values()) {
			names.add(type.name());
		}
		return names;
	}
	
	@Override
	public String getName() {
		return "Area";
	}

	@Override
	public Enum<?>[] getConverterTypesEnum() {
		return AreaConverter.Type.values();
	}
	

}

