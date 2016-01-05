package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import view.NoticeBoardSettingsScreen;

public class ComboListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		 JComboBox cb = (JComboBox)e.getSource();
	        String selectedColour = (String)cb.getSelectedItem();
	        System.out.println(selectedColour);
	}
}
