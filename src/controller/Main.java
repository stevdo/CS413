package controller;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import model.DeviceRegistrar;
import model.FileWriterToo;
import model.IDRetriever;
import model.Model;
import model.NoticeboardImages;
import model.PinGenerator;
import view.MainView;

public class Main {

	private static int deviceId = 1;
	private static int devicePin = 1;
	private static String filePath = "/Users/Chris/Desktop/Device/pin.txt";

	// //

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

		try {
			InputStream fis = new FileInputStream(filePath);
			fis.close();
			fileExists = true;
			System.out.println("Main; file present");
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException in Main; line 57");
		} catch (IOException ioe) {
			System.out.println("IOException in Main; line 59");
			ioe.printStackTrace();
		}

		if (!fileExists) {
			System.out.println("Main; file not present");
			createFile();
			fileExists = true;
			System.out.println("Main; registering device");
			devicePin = getPin(filePath);
			new DeviceRegistrar(devicePin).registerDevice();
		}

		if (fileExists) {
			System.out.println("Main; retrieving pin from file");
			devicePin = getPin(filePath);
			System.out.println("Main; retrieving D_id");
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
		m.setIndex();
		mv.setIndex(m.getNotes().size()-1);
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

	private static int getPin(String filePath) {
		String line;
		int pin = -1;
		try (InputStream fis = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(fis,
						Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(isr);) {
			line = br.readLine();
			pin = Integer.parseInt(line);
		} catch (FileNotFoundException fnfe) {
			System.err.println("FileNotFoundException in Main; line 128");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.err.println("IOException in Main; line 131");
			ioe.printStackTrace();
		}
		System.out.println("Main; pin retrieved from file");
		return pin;
	}

	private static void createFile() {
		System.out.println("Main; creating file");
		new FileWriterToo(filePath, Integer.toString(new PinGenerator()
				.generatePin())).write();
	}
}