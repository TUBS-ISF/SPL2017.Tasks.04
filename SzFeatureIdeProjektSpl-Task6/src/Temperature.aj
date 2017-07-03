
public aspect Temperature {
	before(Main main): execution(* *.start()) && this(main) {
		System.out.println("Aspect Temperature active");
		main.addConverter(new TemperatureConverter());
	}
}