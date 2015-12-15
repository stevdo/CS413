package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int buttonPress = Integer.parseInt(e.getActionCommand());
		switch(buttonPress){
		case 0:
			// need to change the functionality here
			System.out.println("Notes pressed");
			System.exit(0);
			break;
		case 1:
			// need to change the functionality here
			System.out.println("Settings pressed");
			System.exit(0);
			break;
		case 2:
			// need to change the functionality here
			System.out.println("Warnings pressed");
			System.exit(0);
			break;
		case 3: 
			// need to change the functionality here
			System.out.println("Home pressed");
			System.exit(0);			
			break;
		}		
	}	
}
