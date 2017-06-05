package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;



public class ComboBoxTypes implements ActionListener {
	JComboBox<String> cb;
    
	public ComboBoxTypes(List<String> types) {
		Vector<String> typesV = new Vector<>();
		for (String type : types) {
			typesV.add(type);
		}
		
		cb = new JComboBox<String>(typesV);
	}
	
	public void actionPerformed(ActionEvent e) {
        JComboBox<?> cb = (JComboBox<?>)e.getSource();
        String typeStr = (String)cb.getSelectedItem();
        System.out.println("TypeStr " + typeStr);
        //updateLabel(petName);
    }
	
	public JComboBox<String> get() {
		return this.cb;
	}
    
}