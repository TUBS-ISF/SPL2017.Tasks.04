package converter.ui.graphical;

import converter.TemperatureConverter;
import converter.TemperatureConverter.TemperatureType;

public class TemperatureConverterMenu implements GraphicalUiPlugin {

	@Override
	public String getName() {
		return "Temperature";
	}

	@Override
	public Enum<?> getTypes() { // TODO
		TemperatureConverter tc = new TemperatureConverter();
		TemperatureType[] types = TemperatureType.values();
		return null;
	}

}
