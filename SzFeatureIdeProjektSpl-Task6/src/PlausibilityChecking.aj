

public aspect PlausibilityChecking {
	after(): execution(void Main.start()) {
		System.out.println("Aspect PlausibilityChecking active");
	}
	before(): call(* ConverterTypePlugin.convert(*,*,*)) {
		
		System.out.println("Checking Plausibility");
	}
	
}