package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TextFocusListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		String name = e.getComponent().getName();
		System.out.println("Text Field Clicked  " +  name);
		switch(name){
		case "text area":
			CurrentTextComponent.setCurrentFocusedTextComponent(name);
			break;
		case "text field":
			CurrentTextComponent.setCurrentFocusedTextComponent(name);
			break;
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
		
		
}
