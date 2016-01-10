package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.Model;
import view.NoticeBoardWriteMessage;

public class KeyboardListener implements ActionListener {
	private Model m;

	public KeyboardListener(Model m) {
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		String component_to_update = CurrentTextComponent.getCurrentComponent();

		if (buttonPressed.getText() == "Return") {
			// Needs to print to selected JTextField
			System.out.println("Key pressed: rtn");
			if (component_to_update.equals("text area")) {
				System.out.println();
				NoticeBoardWriteMessage.textArea.append("\n");
				m.setText(NoticeBoardWriteMessage.textArea.getText());
			}
		} else if (buttonPressed.getText() == "Backspace") {
			// Needs to print to selected JTextField
			System.out.println("Key pressed: bsp");
			if (component_to_update.equals("text area")) {
				String text_area_content = NoticeBoardWriteMessage.textArea
						.getText();
				NoticeBoardWriteMessage.textArea.setText(text_area_content
						.substring(0, text_area_content.length() - 1));
				m.setText(NoticeBoardWriteMessage.textArea.getText());
			} else if (component_to_update.equals("text field")) {
				String text_area_content = NoticeBoardWriteMessage.textField
						.getText();
				NoticeBoardWriteMessage.textField.setText(text_area_content
						.substring(0, text_area_content.length() - 1));
				m.setTitle(NoticeBoardWriteMessage.textField.getText());
			}
		} else if (buttonPressed.getText() == "Shift") {
			// Needs to print to selected JTextField
			System.out.println("Key pressed: sft");
		} else if (buttonPressed.getText() == "Space") {
			// Needs to print to selected JTextField
			System.out.println("Key pressed: spc");
			if (component_to_update.equals("text area")) {
				NoticeBoardWriteMessage.textArea.append(" ");
				m.setText(NoticeBoardWriteMessage.textArea.getText());
			} else if (component_to_update.equals("text field")) {
				NoticeBoardWriteMessage.textField
						.setText(NoticeBoardWriteMessage.textField.getText()
								+ " ");
				m.setTitle(NoticeBoardWriteMessage.textField.getText());
			}
		} else {
			// CAL1UM W4S HeR3 !!!!11!1!
			// Needs to print to selected JTextField
			// System.out.println("Key pressed: " +
			// buttonPressed.getClientProperty("buttonPressed"));
			System.out.println(component_to_update);
			if (component_to_update.equals("text area")) {
				System.out.println("Updating text area");
				// System.out.println("Current Text Area contents: " +
				// NoticeBoardWriteMessage.textArea2.getText());
				NoticeBoardWriteMessage.textArea
						.setText(NoticeBoardWriteMessage.textArea.getText()
								+ (String) buttonPressed
										.getClientProperty("buttonPressed"));
				m.setText(NoticeBoardWriteMessage.textArea.getText());
			} else if (component_to_update.equals("text field")) {
				System.out.println("Updating text field");
				NoticeBoardWriteMessage.textField
						.setText(NoticeBoardWriteMessage.textField.getText()
								+ (String) buttonPressed
										.getClientProperty("buttonPressed"));
				m.setTitle(NoticeBoardWriteMessage.textField.getText());
			}
		}
	}
}
