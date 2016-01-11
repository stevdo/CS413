package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

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
import controller.ExitActionListener;
import controller.ImageCollect;

public class NoticeBoardNotesScreen {
	
	private JFrame notes_frame;
	private NoteList noteList;
	private ActionListener button_listener;
	public static int current_index = -1 ;
	public static int max_index = -1;

	public NoticeBoardNotesScreen(JFrame noticeboard_frame){
		notes_frame = noticeboard_frame;
	}
	
	public void addButtonListener(ActionListener button_listener) {
		this.button_listener = button_listener;
		System.out.println("Notes screen; listener added");
	}
	
	public void setNotes(NoteList noteList) {
		this.noteList = noteList;
		System.out.println("Notes Screen; Notes retrieved.");
	}
	
	public void setIndex(int index) {
		if(current_index < 0){
			current_index = index;
		}
		max_index = index;
		System.out.println("max index is now: " + max_index);
	}
	
	public static void updateCurrentIndex(int index){
		current_index = index;
	}
	
	public void init_NotesScreen(){
		
		String messageTitle;
		String messageBody;
		String user;

		System.out.println("recalled init. noteList size: " + noteList.size());
		for (int i = 0; i < this.noteList.size(); i++) {
			Note n = this.noteList.get(i);
			messageTitle = n.getTitle();
			messageBody = n.getBody();
			user = n.getUser();
			//display on screen rather than console
//			System.out.println("list index: " + i);
//			System.out.println(messageTitle);
//			System.out.println(messageBody);
//			System.out.println(user);
		}
		
		notes_frame.getContentPane().removeAll();
		
		// get the needed images
		ImageIcon home_icon = ImageCollect.getSideImageHomeIcon();
		ImageIcon settings_icon = ImageCollect.getSideImageSettingsIcon();
		ImageIcon warning_icon = ImageCollect.getSideImageWarningIcon();
		
		// get the colour for the noticeboard
		Color colour = ColourCollect.getCurrentColour();
		
		
		/*
		 * need int for settings panel, exact size needs to be 
		 * experimented with
		 */
		int settings_width = (int) (notes_frame.getWidth() -
				(0.12 * notes_frame.getWidth()));
		int options_width = (int) (notes_frame.getWidth() -
				(0.88 * notes_frame.getWidth()));
		
		int title_font_size = (int) (0.05 * notes_frame.getWidth());
		
		// JLabel for the title of the current screen
		JLabel title = new JLabel("Notice Board");
		//title.setPreferredSize(new Dimension (title_width, title_height));
		title.setFont(new Font("Serif", Font.BOLD, title_font_size));
		
		JPanel notes_panel = new JPanel();		
		notes_panel.setSize(settings_width, notes_frame.getHeight());
		notes_panel.setBackground(colour);
		notes_panel.setLayout(new GridBagLayout());
		
		// options panel allows user to navigate between screens
		JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width, notes_frame.getHeight()));
		options_panel.getPreferredSize();
		options_panel.setBackground(new Color(153, 76, 0));
		options_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER; //adding c makes the content take up the entire row
		c.insets = new Insets(10, 0, 10, 0); //padding
		
		// ActionListener's
		ActionListener exitActionListener = new ExitActionListener();
//		ActionListener button_listener = new ButtonListener(mv);
		
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
		
		//Create container for buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(home);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); //Adds space between buttons
		verticalBox.add(settings);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); //Adds space between buttons
		verticalBox.add(warnings);
		
		// temporary
		home.setBorder(BorderFactory.createEmptyBorder());
		home.setContentAreaFilled(false);
//		home.addActionListener(button_listener);
		home.addActionListener(button_listener);
		
		settings.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
//		settings.addActionListener(button_listener);
		settings.addActionListener(button_listener);
		
		warnings.setBorder(BorderFactory.createEmptyBorder());
		warnings.setContentAreaFilled(false);
//		warnings.addActionListener(button_listener);
		warnings.addActionListener(button_listener);
		
		// temporary close button
		JButton exit = new JButton("Exit System");
		exit.setBounds(200, 200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		/*
		 * This button is made to allow the user to put new messages
		 * on the database. Need to include it... if it works
		 */
		JButton write = new JButton("Write Message");
//		write.setPreferredSize(new Dimension(300, 100));
//		write.setFont(new Font("Serif", Font.BOLD, (int)(0.02 * notes_frame.getWidth())));
//		write.setBackground(new Color(240, 230, 80));
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
		horizontalBox.add(Box.createRigidArea(new Dimension(20,0))); //Adds space between buttons
		horizontalBox.add(write);
		horizontalBox.add(Box.createRigidArea(new Dimension(20,0))); //Adds space between buttons
		horizontalBox.add(next_notes);
		
		Box horizBox2 = Box.createHorizontalBox();
		System.out.println("Current Index before adding notes: " + current_index);
		for(int i = 0; i < 3; i++) {
			if(current_index-i >= 0){
			JTextArea note_area = new JTextArea();
			note_area.setBackground(new Color(240, 230, 80));
			note_area.setEditable(false);
			note_area.setPreferredSize(new Dimension((int)(notes_frame.getWidth() * 0.2), (int)(notes_frame.getHeight() * 0.4)));
			System.out.println("current index is: " +(current_index-i));
			Note n = this.noteList.get(current_index-i);
			note_area.setText(n.getTitle() + "\n\n" + n.getBody() + "\n\n" + n.getUser());
			horizBox2.add(note_area);
			if(i < 2){
				horizBox2.add(Box.createRigidArea(new Dimension(30,0))); //Adds space between buttons
			}
			}
			else {
				System.out.println("not adding the note");
			}
		}
		
		
		// add components to the panel
		notes_panel.add(title, c);
		notes_panel.add(exit, c);
		notes_panel.add(horizBox2, c);
		notes_panel.add(horizontalBox);
		options_panel.add(verticalBox, c);
		
		// add the panels to the frame
		notes_frame.add(options_panel, BorderLayout.LINE_START);
		notes_frame.add(notes_panel);	
		
		// Set program as full screen
		//device.setFullScreenWindow(notes_frame);
		
		//notes_frame.validate();	
		
	}
	
}
