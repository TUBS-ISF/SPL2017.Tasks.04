

public aspect Length {
	//declare parents : LengthConverter implements ConverterTypePlugin;
	before(Main main): execution(* *.start()) && this(main) {
		System.out.println("Aspect Length active");
		main.addConverter(new LengthConverter());
	}
	
}