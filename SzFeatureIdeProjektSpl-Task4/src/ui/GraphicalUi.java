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
	private KonverterTypePlugin converterPlugin;
	

	public GraphicalUi(KonverterTypePlugin converterPlugin) {
		super();
		this.setTitle("Converter");
		this.converterPlugin = converterPlugin;
		init(false);
		
	}

	private void init(boolean b) {
		this.getContentPane().setLayout(new FlowLayout());
		this.setBounds(200, 200, 280, 240);
		
		JTextField textFieldInput = createTextFieldInput();
		JTextField textFieldOutput = createTextFieldOutput();
		JComboBox<String> comboBoxInputType = createComboBoxInputType();
		JComboBox<String> comboBoxOutputType = createComboBoxOutputType();
		this.add(textFieldInput);
		this.add(comboBoxInputType);
		this.add(textFieldOutput);
		this.add(comboBoxOutputType);
		
		this.add(createButtonCalculate(textFieldInput, textFieldOutput, comboBoxInputType, comboBoxOutputType));
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
	
	private JComboBox<String> createComboBoxInputType() {
		ComboBoxTypes cbt = new ComboBoxTypes(converterPlugin.getTypeNames());
		
		return cbt.get();
	}
	
	private JComboBox<String> createComboBoxOutputType() {
		ComboBoxTypes cbt = new ComboBoxTypes(converterPlugin.getTypeNames());
		return cbt.get();
	}
	
	private JButton createButtonCalculate(
			JTextField textFieldInput, 
			JTextField textFieldOutput,
			JComboBox<String> comboBoxInputType,
			JComboBox<String> comboBoxOutputType) 
	{
		JButton b = new JButton();
		b.setText("Calculate");
		//b.setBounds(40, 40, 100, 30);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double operand = Double.valueOf(textFieldInput.getText());
				try {
					double result = converterPlugin.convert(operand, 
							comboBoxInputType.getSelectedItem().toString(), 
							comboBoxOutputType.getSelectedItem().toString());
					
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

