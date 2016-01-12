package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import model.Model;
import model.NoticeboardColours;
import model.Warnings;
import view.MainView;
import view.NoticeBoardNotesScreen;
import view.NoticeBoardSettingsScreen;
import view.NoticeBoardWarningsScreen;

public class ButtonListener implements ActionListener {

	private MainView mv;
	private Model m;

	public ButtonListener(MainView mv, Model m) {
		this.mv = mv;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NoticeboardColours nc = new NoticeboardColours();
		int buttonPress = Integer.parseInt(e.getActionCommand());
		switch (buttonPress) {
		case 0:
			System.out.println("Notes pressed");
			mv.updateWindow("notes");
			mv.update();
			break;
		case 1:
			System.out.println("Settings pressed");
			mv.updateWindow("settings");
			mv.update();
			break;
		case 2:
			System.out.println("Warnings pressed");
			mv.updateWindow("warnings");
			mv.update();
			break;
		case 3:
			System.out.println("Home pressed");
			mv.updateWindow("home");
			mv.update();
			break;
		case 4:
			System.out.println("Write pressed");
			mv.updateWindow("write");
			mv.update();
			break;
		case 5:
			String selectedColour = new String("");
			selectedColour = ComboListener.editString();
			System.out.println("Selected colour is: " + selectedColour);
			m.setColour(selectedColour.toLowerCase());
			if (selectedColour == "Green") {
				nc.setNoticeboardColour("green");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Red") {
				nc.setNoticeboardColour("red");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Blue") {
				nc.setNoticeboardColour("blue");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Orange") {
				nc.setNoticeboardColour("orange");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Purple") {
				nc.setNoticeboardColour("purple");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Pink") {
				nc.setNoticeboardColour("pink");
				mv.updateWindow("settings");
				mv.update();
			}
			break;
		case 6:
			try {
				Runtime.getRuntime().exec("systemctl poweroff");
			} catch (IOException e1) {
				System.out.println("IOException systemctl poweroff");
			}
			System.exit(0);
			break;
		case 7:
			try {
				Runtime.getRuntime().exec("systemctl reboot");
			} catch (IOException e1) {
				System.out.println("IOException systemctl reboot");
			}
			System.exit(0);
			break;
		case 8:
			Socket socket = new Socket();
			// Tests connection by checking if www.cs413noticeboard.co.uk can be
			// accessed with port 80
			InetSocketAddress url = new InetSocketAddress(
					"www.cs413noticeboard.co.uk", 80);
			try {
				// set timeout to 1000ms
				socket.connect(url, 1000);
				// if connection is successful it will print "You are connected"
				NoticeBoardSettingsScreen.connectedLabel2.setVisible(false);
				NoticeBoardSettingsScreen.connectedLabel1.setVisible(true);
			} catch (Exception ex) {
				// if connection is not successful it will print
				// "You are not connected"
				NoticeBoardSettingsScreen.connectedLabel1.setVisible(false);
				NoticeBoardSettingsScreen.connectedLabel2.setVisible(true);
			} finally {
				// Close the socket
				try {
					socket.close();
				} catch (Exception ex) {
				}
			}
			break;
		case 9:
			System.out.println("windows on Button clicked");
			// set the warning in the model
			Warnings.toogleWindowWarningOn();
			NoticeBoardWarningsScreen.windows_on.setBackground(new Color(51,
					255, 51));
			NoticeBoardWarningsScreen.windows_off.setBackground(new Color(204,
					0, 0));
			break;
		case 10:
			System.out.println("windows off button clicked");
			// unset the warning in the model
			Warnings.toogleWindowWarningOff();
			NoticeBoardWarningsScreen.windows_off.setBackground(new Color(51,
					255, 51));
			NoticeBoardWarningsScreen.windows_on.setBackground(new Color(204,
					0, 0));
			break;
		case 11:
			System.out.println("washing on button clicked");
			// set the warning in the model
			Warnings.toogleWashingWarningOn();
			NoticeBoardWarningsScreen.washing_on.setBackground(new Color(51,
					255, 51));
			NoticeBoardWarningsScreen.washing_off.setBackground(new Color(204,
					0, 0));
			break;
		case 12:
			System.out.println("washing off button clicked");
			// unset the warning in the model
			Warnings.toogleWashingWarningOff();
			NoticeBoardWarningsScreen.washing_off.setBackground(new Color(51,
					255, 51));
			NoticeBoardWarningsScreen.washing_on.setBackground(new Color(204,
					0, 0));
			break;
		case 13:
			System.out.println("Add note button pressed");
			boolean titleValid = m.titleValid();
			boolean textValid = m.textValid();
			if (titleValid && textValid) {
				System.out.println("Note valid");
				m.postNote();
				m.clearNotes();
				m.updateNotes();
				m.setIndex(m.getNotes().size() - 1);
				mv.setTitleValid();
				mv.setTextValid();
				mv.setIndex(m.getIndex());
				mv.setNotes(m.getNotes());
				mv.updateWindow("notes");
			} else if (!titleValid || !textValid) {
				if (!titleValid) {
					mv.setTitleInvalid();
				}
				if (!titleValid) {
					mv.setTextInvalid();
				}
				mv.updateWindow("write");
			} else {
				System.out
						.println("ButtonListener; unexpected execution line 191");
			}
			mv.update();
			break;
		case 14:
			if ((NoticeBoardNotesScreen.current_index - 3) >= 0) {
				System.out.println("Max index of view: "
						+ NoticeBoardNotesScreen.max_index);
				m.setIndex((m.getIndex()) - 3);
				mv.updateCurrentIndex(m.getIndex());
				mv.updateWindow("notes");
				mv.update();
			}
			break;
		case 15:
			if ((NoticeBoardNotesScreen.current_index + 3) <= NoticeBoardNotesScreen.max_index) {
				m.setIndex((m.getIndex()) + 3);
				mv.updateCurrentIndex(m.getIndex());
				mv.updateWindow("notes");
				mv.update();
			}
			break;
		case 16:
			System.out.println("Delete note button pressed");
			if (m.getNoteToDelete() >= 0) {
				System.out.println("Button Listener; note to delete "
						+ m.getNoteToDelete());
				m.deleteNote();
				m.clearNotes();
				m.updateNotes();
				m.setIndex(m.getNotes().size() - 1);
				m.setNoteToBeDeleted(-1);
				mv.setTitleValid();
				mv.setTextValid();
				mv.setIndex(m.getIndex());
				mv.updateCurrentIndex(m.getIndex());
				mv.setNotes(m.getNotes());
				mv.updateWindow("notes");
				mv.update();
			} else {
				System.out.println("No note selected");
			}
			break;
		case 17:
			mv.updateWindow("notes");
			mv.update();
		}
	}
}
