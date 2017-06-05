package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import converter.KonverterTypePlugin;
import converter.LengthKonverter;
import converter.NotSupportedException;
import converter.TemperatureConverter;

public class GraphicalUi extends JFrame{
	private static final long serialVersionUID = 1520725678693523956L;
	private TemperatureConverter temperatureConverter = new TemperatureConverter();

	public GraphicalUi() {
		super();
		this.setTitle("Converter");
		init(false);
		
	}

	private void init(boolean b) {
		this.getContentPane().setLayout(new FlowLayout());
		this.setBounds(200, 200, 280, 240);
		
		JTextField textFieldInput = createTextFieldInput();
		JTextField textFieldOutput = createTextFieldOutput();
		this.add(textFieldInput);
		this.add(createComboBoxInputType());
		this.add(textFieldOutput);
		this.add(createComboBoxOutputType());
		
		this.add(createButtonCalculate(textFieldInput, textFieldOutput));
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private JTextField createTextFieldInput() {
		JTextField txt = new JTextField();
		txt.setColumns(15);
		
		return txt;
	}
	
	private JTextField createTextFieldOutput() {
		JTextField txt = new JTextField();
		txt.setColumns(15);
		txt.setEditable(false);
		return txt;
	}
	
	private JComboBox<?> createComboBoxInputType() {
		ComboBoxTypes cbt = new ComboBoxTypes(temperatureConverter.getTypeNames());
		return cbt.get();
	}
	
	private JComboBox<?> createComboBoxOutputType() {
		ComboBoxTypes cbt = new ComboBoxTypes(temperatureConverter.getTypeNames());
		return cbt.get();
	}
	
	private JButton createButtonCalculate(JTextField textFieldInput, JTextField textFieldOutput) {
		JButton b = new JButton();
		b.setText("Calculate");
		//b.setBounds(40, 40, 100, 30);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double operand = Double.valueOf(textFieldInput.getText());
				try {
					double result = temperatureConverter.convert(operand, 
							TemperatureConverter.TemperatureType.Celsius.name(), 
							TemperatureConverter.TemperatureType.Kelvin.name());
					
					textFieldOutput.setText(String.valueOf(result));
				} catch (NotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		return b;
	}


}

