

public aspect Mass {
//	pointcut test():
//        call(void ConsoleTest.print());
	
	before(Main main): execution(* *.start()) && this(main) {
		System.out.println("Aspect Mass active");
		main.addConverter(new MassConverter());
	}
	
	
	
}