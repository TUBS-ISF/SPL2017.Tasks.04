package converter;

public class VolumeConverter extends KonverterType {
	
	public enum VolumeType {
	    m2, cm2 
	} 

	@Override
	protected double operator(double operand, String sourceType, String destinationType) throws NotSupportedException {
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
	protected double operator(double operand1, double operand2, String sourceType, String destinationType)
			throws NotSupportedException {
		// TODO Auto-generated method stub
		return 0;
	}

}
