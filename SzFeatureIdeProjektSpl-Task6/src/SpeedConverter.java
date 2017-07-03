import java.util.ArrayList;
import java.util.List;

public class SpeedConverter implements ConverterTypePlugin {
	
	public enum Type {
	    kmh, ms
	} 

	@Override
	public double convert(double operand, String sourceType, String destinationType) throws NotSupportedException {
		if(sourceType.equals(Type.kmh.name())) {
			return this.convFromKmh(operand, destinationType);
		} 
		else if(sourceType.equals(Type.ms.name())){
			return this.convFromMs(operand, destinationType); 
		}
		

		throw new NotSupportedException("No supported conversion operation for sourceType: " + sourceType);
	}

	private double convFromKmh(double operand, String destinationType) {
		if(destinationType.equals(Type.ms.name())) {
			return operand * 1000 / 3600;
		} else {
			return operand;
		}
	}

	private double convFromMs(double operand, String destinationType) {
		if(destinationType.equals(Type.kmh.name())) {
			return operand * 3600 / 1000;
		} else {
			return operand;
		}
	}
	
	

	@Override
	public List<String> getTypeNames() {
		List<String> names = new ArrayList<String>();
		for (SpeedConverter.Type type : SpeedConverter.Type.values()) {
			names.add(type.name());
		}
		return names;
	}
	
	@Override
	public String getName() {
		return "Speed";
	}

	@Override
	public Enum<?>[] getConverterTypesEnum() {
		return SpeedConverter.Type.values();
	}
	

}

