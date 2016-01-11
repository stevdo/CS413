package controller;

import java.awt.event.ActionListener;

import model.Model;
import model.NoticeboardImages;
import view.MainView;

public class Main {
	
	private static int deviceId = 1;
	private int devicePin;
	
	public static void main(String[] args) {
		
		// open the system on the HomeScreen page
		/*NoticeBoardHomeScreen view = new NoticeBoardHomeScreen();
		view.init_HomeScreen();*/
		
		// the following are tests, to open the system on other pages
		/*NoticeBoardNotesScreen notes_view = new NoticeBoardNotesScreen();
		notes_view.init_SettingsScreen();*/
		
		/*NoticeBoardSettingsScreen settings_view = new NoticeBoardSettingsScreen();
		settings_view.init_SettingsScreen();*/
		
		/*NoticeBoardWarningsScreen warnings_view = new NoticeBoardWarningsScreen();
		warnings_view.init_WarningsScreen();*/
		
//		if (!fileExists) {
//			createFile();
//		}
		
//		if (fileExists) {
//			pin = getId(file);
//			deviceId = new IdRetriever(file).retrieveId();
//		}
		
		 //1 = default deviceId
		Model m = new Model(deviceId);
		m.updateNotes();
		
		NoticeboardImages.setSideImages();
		NoticeboardImages.setHomeImages();
		//NoticeboardColours.setNoticeboardColour("red");
		
		MainView mv = new MainView();
		
		//construct listeners
		ActionListener button_listener = new ButtonListener(mv, m);
		ActionListener keyboard_listener = new KeyboardListener(m);
		
		//add listeners to view
		mv.addButtonListener(button_listener);
		mv.addKeyboardListener(keyboard_listener);
		
		mv.setNotes(m.getNotes());
		mv.init_NoticeboardFrame();
		mv.updateWindow("home");
		
		
		//Cipher.simpleEncrypt("A B C D E F G");
		//Cipher.simpleDecrypt("K L M N O P Q");
		
		/*Cipher.test();
		Cipher.messageEncrypt("Get some milk Maw");
		Cipher.messageDecrypt("Qod cywo wsvu Wkg");*/
		
		// after set amount of time?
		
		//		m.updateNotes();
		//		NoteList newNoteList = m.getNoteList();
		//		if (!(newNoteList.equals(MainView.getNoteList()))) { 
		//			view.updateNoteList(newNoteList);
		//		}
		
		// or do regardless of equality (does it matter? try both ways?)
		
		//		m.updateNotes();
		//		MainView.updateNoteList(m.getNoteList());
		
	}
}