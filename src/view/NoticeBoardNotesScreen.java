package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Note;
import model.NoteList;
import controller.ColourCollect;
import controller.ImageCollect;

public class NoticeBoardNotesScreen {

	private JFrame notes_frame;
	private NoteList noteList;
	private ActionListener button_listener;
	private MouseListener note_listener;
	public static int current_index = -1;
	public static int max_index = -1;

	public NoticeBoardNotesScreen(JFrame noticeboard_frame) {
		notes_frame = noticeboard_frame;
	}

	public void addButtonListener(ActionListener button_listener) {
		this.button_listener = button_listener;
		System.out.println("Notes screen; listener added");
	}

	public void addNoteListener(MouseListener notes_listener) {
		this.note_listener = notes_listener;
	}

	public void setNotes(NoteList noteList) {
		this.noteList = noteList;
		System.out.println("Notes Screen; Notes retrieved.");
	}

	public void setIndex(int index) {
		if (current_index < 0) {
			current_index = index;
		}
		max_index = index;
		System.out.println("max index is now: " + max_index);
	}

	public void updateCurrentIndex(int index) {
		current_index = index;
	}

	public void init_NotesScreen() {

		notes_frame.getContentPane().removeAll();

		// get the needed images
		ImageIcon home_icon = ImageCollect.getSideImageHomeIcon();
		ImageIcon settings_icon = ImageCollect.getSideImageSettingsIcon();
		ImageIcon warning_icon = ImageCollect.getSideImageWarningIcon();

		// get the colour for the noticeboard
		Color colour = ColourCollect.getCurrentColour();

		/*
		 * need int for settings panel, exact size needs to be experimented with
		 */
		int settings_width = (int) (notes_frame.getWidth() - (0.12 * notes_frame
				.getWidth()));
		int options_width = (int) (notes_frame.getWidth() - (0.88 * notes_frame
				.getWidth()));

		int title_font_size = (int) (0.05 * notes_frame.getWidth());

		// JLabel for the title of the current screen
		JLabel title = new JLabel("Notice Board");
		// title.setPreferredSize(new Dimension (title_width, title_height));
		title.setFont(new Font("Serif", Font.BOLD, title_font_size));

		JPanel notes_panel = new JPanel();
		notes_panel.setSize(settings_width, notes_frame.getHeight());
		notes_panel.setBackground(colour);
		notes_panel.setLayout(new GridBagLayout());

		// options panel allows user to navigate between screens
		JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width, notes_frame
				.getHeight()));
		options_panel.getPreferredSize();
		options_panel.setBackground(new Color(153, 76, 0));
		options_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER; // adding c makes the
													// content take up the
													// entire row
		c.insets = new Insets(10, 0, 10, 0); // padding

		// ActionListener's

		// create 3 Buttons for the notes screen
		JButton home = new JButton(home_icon);
		JButton settings = new JButton(settings_icon);
		JButton warnings = new JButton(warning_icon);

		/*
		 * Need to add the action command
		 */
		settings.setActionCommand("1");
		warnings.setActionCommand("2");
		home.setActionCommand("3");

		// Create container for buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(home);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); // Adds
																	// space
																	// between
																	// buttons
		verticalBox.add(settings);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); // Adds
																	// space
																	// between
																	// buttons
		verticalBox.add(warnings);

		home.setBorder(BorderFactory.createEmptyBorder());
		home.setContentAreaFilled(false);
		home.addActionListener(button_listener);

		settings.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
		settings.addActionListener(button_listener);

		warnings.setBorder(BorderFactory.createEmptyBorder());
		warnings.setContentAreaFilled(false);
		warnings.addActionListener(button_listener);

		/*
		 * This button is made to allow the user to put new messages on the
		 * database. Need to include it... if it works
		 */
		JButton write = new JButton("Write Message");
		write.setActionCommand("4");
		write.addActionListener(button_listener);

		JButton next_notes = new JButton("Next Note");
		next_notes.addActionListener(button_listener);
		next_notes.setActionCommand("14");

		JButton previous_notes = new JButton("Previous Note");
		previous_notes.addActionListener(button_listener);
		previous_notes.setActionCommand("15");

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(previous_notes);
		horizontalBox.add(Box.createRigidArea(new Dimension(20, 0))); // Adds
																		// space
																		// between
																		// buttons
		horizontalBox.add(write);
		horizontalBox.add(Box.createRigidArea(new Dimension(20, 0))); // Adds
																		// space
																		// between
																		// buttons
		horizontalBox.add(next_notes);

		// add components to the panel
		JButton delete_note = new JButton("delete");
		delete_note.addActionListener(button_listener);
		delete_note.setActionCommand("16");

		Box horizBox2 = Box.createHorizontalBox();
		if (noteList.size() > 0) {
			for (int i = 0; i < 3; i++) {
				if (current_index - i >= 0) {
					JTextArea note_area = new JTextArea();
					note_area.setBackground(new Color(240, 230, 80));
					note_area.setEditable(false);
					note_area.setPreferredSize(new Dimension((int) (notes_frame
							.getWidth() * 0.2),
							(int) (notes_frame.getHeight() * 0.4)));
					Note n = this.noteList.get(current_index - i);
					note_area.setText(n.getTitle() + "\n\n" + n.getBody()
							+ "\n\n" + n.getUser());
					int noteID = n.getNoteID();
					String s = Integer.toString(noteID);
					note_area.setName(s);

					note_area.setLineWrap(true);
					note_area.setWrapStyleWord(true);

					note_area.addMouseListener(note_listener);
					horizBox2.add(note_area);
					if (i < 2) {
						horizBox2
								.add(Box.createRigidArea(new Dimension(30, 0))); // Adds
																					// space
																					// between
																					// buttons
					}
				} else {
					System.out.println("not adding the note");
				}
			}
		} else {
			JTextArea note_area = new JTextArea();
			note_area.setBackground(new Color(240, 230, 80));
			note_area.setEditable(false);
			note_area.setPreferredSize(new Dimension((int) (notes_frame
					.getWidth() * 0.2), (int) (notes_frame.getHeight() * 0.4)));
			note_area.setText("No messages available.");
			horizBox2.add(note_area);
			previous_notes.setVisible(false);
			next_notes.setVisible(false);
			delete_note.setVisible(false);
		}

		notes_panel.add(title, c);
		notes_panel.add(horizBox2, c);
		notes_panel.add(horizontalBox, c);
		notes_panel.add(delete_note);
		options_panel.add(verticalBox, c);

		// add the panels to the frame
		notes_frame.add(options_panel, BorderLayout.LINE_START);
		notes_frame.add(notes_panel);

	}

}
