package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import view.NoticeBoardSettingsScreen;
import controller.ButtonListener;

public class ComboListener implements ActionListener {
	
	public static String colour = new String();
	
	public void actionPerformed(ActionEvent e) {
		 JComboBox cb = (JComboBox)e.getSource();
	        colour = (String)cb.getSelectedItem();
	        System.out.println("Combo listener colour is: " + colour);
	}
	
	static String editString() {
		return colour;
	}
}
