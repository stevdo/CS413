package controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import model.DeviceRegistrar;
import model.PinWriter;
import model.IDRetriever;
import model.Model;
import model.NoticeboardImages;
import model.PinGenerator;
import view.MainView;

public class Main {

	private static int deviceId = -1;
	private static int devicePin = -1;
	private static int oldSize = -1;
	private static String colour = null;
	private static String filePath = "/Users/adam/Desktop/Device/pin.txt";

	public static void main(String[] args) {

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

		if (colour != null) {
			System.out.println("Main; setting colour: " + colour);
			ColourCollect.setCurrentColour(colour);
		}

		Model m = new Model(deviceId);
		m.setPath(filePath);
		m.updateNotes();

		NoticeboardImages.setSideImages();
		NoticeboardImages.setHomeImages();

		MainView mv = new MainView();

		// construct listeners
		ActionListener button_listener = new ButtonListener(mv, m);
		ActionListener keyboard_listener = new KeyboardListener(m);
		MouseListener notes_listener = new NotesListener(m);

		// add listeners to view
		mv.addButtonListener(button_listener);
		mv.addKeyboardListener(keyboard_listener);
		mv.addNotesListener(notes_listener);
		m.setIndex();
		mv.setPin(devicePin);
		mv.setIndex(m.getNotes().size() - 1);
		mv.setNotes(m.getNotes());
		mv.init_NoticeboardFrame();
		mv.updateWindow("home");
		update(m, mv);

		// Cipher.simpleEncrypt("A B C D E F G");
		// Cipher.simpleDecrypt("K L M N O P Q");

		/*
		 * Cipher.test(); Cipher.messageEncrypt("Get some milk Maw");
		 * Cipher.messageDecrypt("Qod cywo wsvu Wkg");
		 */

	}

	private static void update(Model m, MainView mv) {
		try {
			while (true) {
				System.out.println("Main; updating notes..");
				int old = m.getNotes().size();
				m.clearNotes();
				m.updateNotes();
				m.setIndex();
				mv.setIndex(m.getNotes().size() - 1);
				if (m.getNotes().size() == 0 && oldSize > 0) {
					Thread.sleep(10 * 1000);
					System.out
							.println("Error updating notes in Main; re-trying..");
					update(m, mv);
				} else {
					oldSize = old;
					mv.setNotes(m.getNotes());
					if (mv.getWindow() == "notes") {
						mv.updateCurrentIndex(m.getIndex());
						mv.setIndex(m.getIndex());
						mv.updateWindow("notes");
						mv.update();
					}
					System.out.println("Main; notes updated");
					Thread.sleep(60 * 1000);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedException in Main; line 125");
		}
	}

	private static int getPin(String filePath) {
		String line = "";
		int pin = -1;
		try (InputStream fis = new FileInputStream(filePath);
				InputStreamReader isr = new InputStreamReader(fis,
						Charset.forName("UTF-8"));
				BufferedReader br = new BufferedReader(isr);) {
			line = br.readLine();
			pin = Integer.parseInt(line);
			line = br.readLine();
			if (line != null) {
				setColour(line);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("FileNotFoundException in Main; line 128");
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.err.println("IOException in Main; line 131");
			ioe.printStackTrace();
		}
		System.out.println("Main; pin retrieved from file: " + pin);
		System.out.println("Main; colour retrieved from file: " + line);
		return pin;
	}

	private static void createFile() {
		System.out.println("Main; creating file");
		new PinWriter(filePath, Integer.toString(new PinGenerator()
				.generatePin())).write();
	}

	private static void setColour(String new_colour) {
		colour = new_colour;
	}

}