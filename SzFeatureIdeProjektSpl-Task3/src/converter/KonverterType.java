package converter;

import java.util.List;

public abstract class KonverterType {
	
	public double convert(double val, String sourceType, String destinationType) throws NotSupportedException {
		return this.operator(val, sourceType, destinationType);
	}
	
	public double convert(double val1, double val2, String sourceType, String destinationType) throws NotSupportedException {
		return this.operator(val1, val2, sourceType, destinationType);
	}
	
	protected abstract double operator(double operand, String sourceType, String destinationType) throws NotSupportedException;
	protected abstract double operator(double operand1, double operand2, String sourceType, String destinationType) throws NotSupportedException;
	
	public abstract List<String> getTypeNames();

}
