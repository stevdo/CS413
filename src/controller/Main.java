package controller;

import java.io.IOException;

import model.Cipher;
import model.Model;
import model.NoticeboardColours;
import model.NoticeboardImages;
import view.MainView;
import view.NoticeBoardHomeScreen;
import view.NoticeBoardNotesScreen;
import view.NoticeBoardSettingsScreen;
import view.NoticeBoardWarningsScreen;

public class Main {
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
		
		 //1 = default deviceId
		Model m = new Model(1);
		m.updateNotes();
		
		NoticeboardImages.setSideImages();
		NoticeboardImages.setHomeImages();
		//NoticeboardColours.setNoticeboardColour("red");
		MainView mv = new MainView();
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
