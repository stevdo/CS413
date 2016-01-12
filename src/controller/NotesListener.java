package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Model;

public class NotesListener implements MouseListener{

	private Model m;
	
	public NotesListener(Model m){
		this.m = m;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String name = e.getComponent().getName();
		int noteID = Integer.parseInt(name);		
		System.out.println("A note has been clicked with id " + noteID);
		m.setNoteToBeDeleted(noteID);
		
		
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
