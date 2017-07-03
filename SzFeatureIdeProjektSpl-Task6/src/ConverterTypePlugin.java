import java.util.List; 

public  interface  ConverterTypePlugin {
	
	
	public double convert(double val, String sourceType, String destinationType) throws NotSupportedException;

	
	public List<String> getTypeNames();
	public Enum<?>[] getConverterTypesEnum();

	
	public String getName();


}
