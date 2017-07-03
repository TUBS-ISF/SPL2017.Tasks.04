
public aspect Volume {
	before(Main main): execution(* *.start()) && this(main) {
		System.out.println("Aspect Volume active");
		main.addConverter(new VolumeConverter());
	}
}