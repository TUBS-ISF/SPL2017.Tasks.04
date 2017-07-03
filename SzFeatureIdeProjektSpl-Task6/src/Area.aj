

public aspect Area {
	before(Main main): execution(* *.start()) && this(main) {
		System.out.println("Aspect Area active");
		main.addConverter(new AreaConverter());
	}
	
}