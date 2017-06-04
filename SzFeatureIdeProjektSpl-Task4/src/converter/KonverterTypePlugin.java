package converter;

import java.util.List;

public interface KonverterTypePlugin {
	
	public double convert(double val, String sourceType, String destinationType) throws NotSupportedException;
	public List<String> getTypeNames();

}
