public aspect Console {
		
	after(Main m): execution(void Main.start()) && this(m) {
		System.out.println("Aspect Console active");
		ConsoleUi ui = new ConsoleUi(m.getConverterTypes(), null);
		try {
			ui.printMenu();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}