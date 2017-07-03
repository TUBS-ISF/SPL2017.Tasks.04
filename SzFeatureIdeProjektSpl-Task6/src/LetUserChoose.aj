
public aspect LetUserChoose {
	void print() {
		System.out.println("LetUserChoose Aspect activated");
	}
	pointcut P1(Main s, ConsoleUi ui): call(* ConsoleUi.printMenu(*)) && this(s) && target(ui);
	
//	after(): call(void ConsoleUi.new()) {
//		this.print();
//	}
}