

public aspect OutputSingle {
	void print() {
		System.out.println("Aspect OutputSingle activated");
	}
	
	pointcut P1(Main s): execution(* *.start*()) && this(s);
	
	 before(Main s): P1(s) {
	        print();
    }
	 

}