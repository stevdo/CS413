package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class KeyboardListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed.getText() == "Return") {
			// Needs to print to selected JTextField
			System.out.println("Key pressed: rtn");
		} else if (buttonPressed.getText() == "Backspace") {
			// Needs to print to selected JTextField
			System.out.println("Key pressed: bsp");
		} else if (buttonPressed.getText() == "Shift") {
			// Needs to print to selected JTextField
			System.out.println("Key pressed: sft");
		} else if (buttonPressed.getText() == "Space") {
			// Needs to print to selected JTextField
			System.out.println("Key pressed: spc");
		} else {
			// Needs to print to selected JTextField
			System.out.println("Key pressed: " + buttonPressed.getClientProperty("buttonPressed"));
		}
	}
}
