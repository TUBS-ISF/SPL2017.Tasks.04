
public aspect Speed {
	before(Main main): execution(* *.start()) && this(main) {
		System.out.println("Aspect Speed active");
		main.addConverter(new SpeedConverter());
	}
}