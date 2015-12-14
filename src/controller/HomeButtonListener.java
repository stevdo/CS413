package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case("notes"):
			// need to change the functionality here
			System.exit(0);
		case("settings"):
			// need to change the functionality here
			System.exit(0);
		case("warning"):
			// need to change the functionality here
			System.exit(0);
		}		
	}	
}
