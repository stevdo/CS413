package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomeButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int buttonPress = Integer.parseInt(e.getActionCommand());
		switch(buttonPress){
		case 0:
			// need to change the functionality here
			System.exit(0);
			break;
		case 1:
			// need to change the functionality here
			System.exit(0);
			break;
		case 2:
			// need to change the functionality here
			System.exit(0);
			break;
		}		
	}	
}
