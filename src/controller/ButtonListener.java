package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.MainView;
import View.NoticeBoardNotesScreen;


public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MainView mv = new MainView();
		int buttonPress = Integer.parseInt(e.getActionCommand());
		switch(buttonPress){
		case 0:
			// need to change the functionality here
			System.out.println("Notes pressed");
			mv.updateWindow("notes");
			mv.update();
			//System.exit(0);
			break;
		case 1:
			// need to change the functionality here
			System.out.println("Settings pressed");
			mv.updateWindow("settings");
			mv.update();
			//System.exit(0);
			break;
		case 2:
			// need to change the functionality here
			System.out.println("Warnings pressed");
			mv.updateWindow("warnings");
			mv.update();
			//System.exit(0);
			break;
		case 3: 
			// need to change the functionality here
			System.out.println("Home pressed");
			mv.updateWindow("home");
			mv.update();
			//System.exit(0);			
			break;
		}		
	}	
}
