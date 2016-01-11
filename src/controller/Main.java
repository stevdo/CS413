package controller;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import model.IDRetriever;
import model.Model;
import model.NoticeboardImages;
import view.MainView;

public class Main {

	private static int deviceId = 1;
	private static int devicePin = 1;
//	private static File file = new File("/Users/adam/Documents/FolioTracker");
	final File file = new File("/Users/adam/Documents/FolioTracker");

	public static void main(String[] args) {

		// open the system on the HomeScreen page
		/*
		 * NoticeBoardHomeScreen view = new NoticeBoardHomeScreen();
		 * view.init_HomeScreen();
		 */

		// the following are tests, to open the system on other pages
		/*
		 * NoticeBoardNotesScreen notes_view = new NoticeBoardNotesScreen();
		 * notes_view.init_SettingsScreen();
		 */

		/*
		 * NoticeBoardSettingsScreen settings_view = new
		 * NoticeBoardSettingsScreen(); settings_view.init_SettingsScreen();
		 */

		/*
		 * NoticeBoardWarningsScreen warnings_view = new
		 * NoticeBoardWarningsScreen(); warnings_view.init_WarningsScreen();
		 */

		boolean fileExists = false;
		
//		if (file there) {
//			fileExists = true;
//		}
		
		if (!fileExists) {
			createFile();
			fileExists = true;
		}

		 if (fileExists) {
//		 devicePin = getPin(file);
		 deviceId = new IDRetriever(devicePin).retrieveID();
		 }

		// 1 = default deviceId
		Model m = new Model(deviceId);
		m.updateNotes();

		NoticeboardImages.setSideImages();
		NoticeboardImages.setHomeImages();
		// NoticeboardColours.setNoticeboardColour("red");

		MainView mv = new MainView();

		// construct listeners
		ActionListener button_listener = new ButtonListener(mv, m);
		ActionListener keyboard_listener = new KeyboardListener(m);

		// add listeners to view
		mv.addButtonListener(button_listener);
		mv.addKeyboardListener(keyboard_listener);

		mv.setNotes(m.getNotes());
		mv.init_NoticeboardFrame();
		mv.updateWindow("home");

		// Cipher.simpleEncrypt("A B C D E F G");
		// Cipher.simpleDecrypt("K L M N O P Q");

		/*
		 * Cipher.test(); Cipher.messageEncrypt("Get some milk Maw");
		 * Cipher.messageDecrypt("Qod cywo wsvu Wkg");
		 */

		// after set amount of time?

		// m.updateNotes();
		// NoteList newNoteList = m.getNoteList();
		// if (!(newNoteList.equals(MainView.getNoteList()))) {
		// view.updateNoteList(newNoteList);
		// }

		// or do regardless of equality (does it matter? try both ways?)

		// m.updateNotes();
		// MainView.updateNoteList(m.getNoteList());

	}

	private static int getPin(File file) {
		String line;
		int pin = -1;
		try (InputStream fis = new FileInputStream(file.getName());
				InputStreamReader isr = new InputStreamReader(fis,
						Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				pin = Integer.parseInt(line);
			}
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException in Main");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IOException in Main");
			e.printStackTrace();
		}
		return pin;
	}
	
	private static void createFile() {
		
	}
}