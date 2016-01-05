package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.NoticeBoardWriteMessage;

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
			//System.out.println("Key pressed: " + buttonPressed.getClientProperty("buttonPressed"));
			String component_to_update = CurrentTextComponent.getCurrentComponent();
			System.out.println(component_to_update);
			if(component_to_update.equals("text area")){
				System.out.println("Updating text area");
				//System.out.println("Current Text Area contents: " + NoticeBoardWriteMessage.textArea2.getText());
				NoticeBoardWriteMessage.textArea.setText(NoticeBoardWriteMessage.textArea.getText() +
						(String) buttonPressed.getClientProperty("buttonPressed"));
			}
			else if(component_to_update.equals("text field")){
				System.out.println("Updating text field");
				NoticeBoardWriteMessage.textField.setText(NoticeBoardWriteMessage.textField.getText() + 
						(String) buttonPressed.getClientProperty("buttonPressed"));
			}
		}
	}
}
