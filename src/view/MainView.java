package view;

import java.awt.GraphicsDevice;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import model.NoteList;

public class MainView {

	private static JFrame noticeboard_frame = new JFrame();
	GraphicsDevice device = noticeboard_frame.getGraphicsConfiguration()
			.getDevice();
	private NoteList noteList;
	private ActionListener button_listener;
	private ActionListener keyboard_listener;
	private MouseListener notes_listener;
	private int index;
	private boolean titleValid;
	private boolean textValid;
	private boolean set;
	private boolean update;

	public void updateWindow(String screen) {

		// noticeboard_frame.removeAll();

		if (screen.equals("notes")) {
			NoticeBoardNotesScreen notes_view = new NoticeBoardNotesScreen(
					noticeboard_frame);
			notes_view.addButtonListener(button_listener);
			notes_view.addNoteListener(notes_listener);
			notes_view.setNotes(noteList);
			if (set) {
				notes_view.setIndex(index);
			} else if (update) {
				notes_view.updateCurrentIndex(index);
			}
			notes_view.init_NotesScreen();
		} else if (screen.equals("settings")) {
			NoticeBoardSettingsScreen settings_view = new NoticeBoardSettingsScreen(
					noticeboard_frame);
			settings_view.addButtonListener(button_listener);
			settings_view.init_SettingsScreen();
		} else if (screen.equals("warnings")) {
			NoticeBoardWarningsScreen warning_view = new NoticeBoardWarningsScreen(
					noticeboard_frame);
			warning_view.addButtonListener(button_listener);
			warning_view.init_WarningsScreen();
		} else if (screen.equals("home")) {
			NoticeBoardHomeScreen home_view = new NoticeBoardHomeScreen(
					noticeboard_frame);
			home_view.addButtonListener(button_listener);
			home_view.init_HomeScreen();
		} else if (screen.equals("write")) {
			NoticeBoardWriteMessage write_view = new NoticeBoardWriteMessage(
					noticeboard_frame);
			if (!titleValid) {
				write_view.setTextInvalid();
			} else {
				write_view.setTextValid();
			}
			if (!textValid) {
				write_view.setTextInvalid();
			} else {
				write_view.setTextValid();
			}
			write_view.addButtonListener(button_listener);
			write_view.addKeyboardListener(keyboard_listener);
			write_view.init_WriteScreen();
			setTitleValid();
			setTextValid();
		} else {
			System.out.println("Error: Screen not recognised.");
		}

		// Set program as full screen
		device.setFullScreenWindow(noticeboard_frame);

	}

	public static JFrame getMainFrame() {
		return noticeboard_frame;
	}

	public void init_NoticeboardFrame() {
		// JFrame noticeboard_frame = new JFrame();
		// may need to add the code to make this frame the device
		noticeboard_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		noticeboard_frame.setUndecorated(true);

	}

	public void setNotes(NoteList noteList) {
		this.noteList = noteList;
		System.out.println("View; Notes retrieved.");
	}

	public void addButtonListener(ActionListener button_listener) {
		this.button_listener = button_listener;
		System.out.println("View; Listener added");
	}

	public void addKeyboardListener(ActionListener keyboard_listener) {
		this.keyboard_listener = keyboard_listener;
		System.out.println("View; Listener added");
	}
	
	public void addNotesListener(MouseListener notes_listener){
		this.notes_listener = notes_listener;
		System.out.println("this is happening");
	}

	public void setIndex(int index) {
		this.index = index;
		set = true;
		update = false;
	}

	public void updateCurrentIndex(int index) {
		this.index = index;
		set = false;
		update = true;
	}

	public void setTitleInvalid() {
		titleValid = false;
	}

	public void setTextInvalid() {
		textValid = false;
	}

	public void setTitleValid() {
		titleValid = true;
	}

	public void setTextValid() {
		textValid = true;
	}

	public void update() {
		noticeboard_frame.validate();
		noticeboard_frame.repaint();
		noticeboard_frame.setVisible(true);
	}

}
