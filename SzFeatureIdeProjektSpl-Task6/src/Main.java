import java.util.ArrayList;
import java.util.List;

public class Main {
	private List<ConverterTypePlugin> konverterList = new ArrayList<>();
	
	public void addConverter(ConverterTypePlugin converter){
		this.konverterList.add(converter);
	}
	
	public List<ConverterTypePlugin> getConverterTypes() {
		return this.konverterList;
	}
	
	
	public void start() {
		System.out.println("Started Application");
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.start();

	}

}
