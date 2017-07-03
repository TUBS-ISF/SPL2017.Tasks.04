
public aspect Power {
	before(Main main): execution(* *.start()) && this(main) {
		System.out.println("Aspect Power active");
		main.addConverter(new PowerConverter());
	}
}