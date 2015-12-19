package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
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

import controller.ButtonListener;
import controller.ColourCollect;
import controller.ExitActionListener;
import controller.ImageCollect;

public class NoticeBoardSettingsScreen {

	JFrame settings_frame = new JFrame();
	
	public NoticeBoardSettingsScreen(JFrame noticeboard_frame) {
		settings_frame = noticeboard_frame;
	}

	public void init_SettingsScreen(){
		
		settings_frame.getContentPane().removeAll();
		
		// get the imaged needed
		ImageIcon home_icon = ImageCollect.getSideImageHomeIcon();
		ImageIcon note_icon = ImageCollect.getSideImageNoteIcon();
		ImageIcon warning_icon = ImageCollect.getSideImageWarningIcon();

		// get the colour for the noticeboard
		Color colour = ColourCollect.getCurrentColour();
		
		// testing border layout
		BorderLayout frame_layout = new BorderLayout();
		
		settings_frame.setLayout(frame_layout);
		
		/*
		 * need int for settings panel, exact size might need experimented with
		 */
		int settings_width = (int) (settings_frame.getWidth() -
				(0.12 * settings_frame.getWidth()));
		int options_width = (int) (settings_frame.getWidth() - 
				(0.88 * settings_frame.getWidth()));
		int title_font_size = (int) (0.05 * settings_frame.getWidth());
				
		// JLabel for the title of the current screen
		JLabel title = new JLabel("Settings");
		title.setFont(new Font("Serif", Font.BOLD, title_font_size));
		
		// create the two panels needed for the screen
		JPanel settings_panel = new JPanel();
		settings_panel.setSize(settings_width, settings_frame.getHeight());
		settings_panel.setBackground(colour);
		
		JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width, settings_frame.getHeight()));
		options_panel.getPreferredSize();
		options_panel.setBackground(new Color(153, 76, 0));
		options_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER; //adding c makes the content take up the entire row
		c.insets = new Insets(10, 0, 10, 0); //padding
		
		// ActionListener's
		ActionListener exitActionListener = new ExitActionListener();
		ActionListener button_listener = new ButtonListener();
		
		// 3 buttons for the screen
		JButton home = new JButton(home_icon);
		JButton notes = new JButton(note_icon);
		JButton warnings = new JButton(warning_icon);
		
		home.setActionCommand("3");
		notes.setActionCommand("0");
		warnings.setActionCommand("2");
		
		
		// these buttons have been made to change colour, will need style added though
		JButton red = new JButton("Red");
		JButton blue = new JButton("Blue");
		JButton orange = new JButton("Orange");
		
		/* will eventually add some more colours, this is
		 * just a test range of colours currently
		 */
		/*red.setBounds(300, 300, 150, 50);
		blue.setBounds(450, 300, 150, 50);
		orange.setBounds(600, 300, 150, 50);*/
		
		red.setForeground(new Color(233, 63, 63));
		blue.setForeground(new Color(86, 200, 249));
		orange.setForeground(new Color(246, 130, 41));
		
		// may want to change these to colour names and make new action listener
		red.setActionCommand("5");
		blue.setActionCommand("6");
		orange.setActionCommand("7");
		
		//Create container for buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(home);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); //Adds space between buttons
		verticalBox.add(notes);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); //Adds space between buttons
		verticalBox.add(warnings);
		
		home.setBorder(BorderFactory.createEmptyBorder());
		home.setContentAreaFilled(false);
		home.addActionListener(button_listener);
		
		notes.setBorder(BorderFactory.createEmptyBorder());
		notes.setContentAreaFilled(false);
		notes.addActionListener(button_listener);
		
		warnings.setBorder(BorderFactory.createEmptyBorder());
		warnings.setContentAreaFilled(false);
		warnings.addActionListener(button_listener);
		
		red.addActionListener(button_listener);
		blue.addActionListener(button_listener);
		orange.addActionListener(button_listener);
		
		//temporary exit button
		JButton exit = new JButton("Exit System"); 
		exit.setBounds(200, 200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		// add to the panels
		settings_panel.add(title);
		settings_panel.add(exit);
		settings_panel.add(red);
		settings_panel.add(blue);
		settings_panel.add(orange);
		options_panel.add(verticalBox, c);
		
		// add to the frame	
		settings_frame.add(options_panel, BorderLayout.LINE_START);
		settings_frame.add(settings_panel, BorderLayout.CENTER);
		
		// Set program as full screen
		//device.setFullScreenWindow(settings_frame);
		
	}
	
}
