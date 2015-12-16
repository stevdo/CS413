package View;

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

import controller.ExitActionListener;
import controller.ButtonListener;

public class NoticeBoardNotesScreen {

	// rename this, not sure why i called everything settings?
	public void init_SettingsScreen(){
		
		// images
		java.net.URL homePNG = NoticeBoardNotesScreen.class.getResource(
				"/side_images/home.png");
		ImageIcon home_icon = new ImageIcon(homePNG);
		java.net.URL settingsPNG = NoticeBoardHomeScreen.class.getResource(
                "/side_images/settings.png");
		ImageIcon settings_icon = new ImageIcon(settingsPNG);
		java.net.URL warningPNG = NoticeBoardHomeScreen.class.getResource(
                "/side_images/warning.png");
		ImageIcon warning_icon = new ImageIcon(warningPNG);
		
		// settings screen frame
		JFrame notes_frame = new JFrame();
		GraphicsDevice device = notes_frame.getGraphicsConfiguration().getDevice();
		notes_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		notes_frame.setUndecorated(true);
		notes_frame.setVisible(true);		
		
		
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
		notes_panel.setBackground(new Color(64, 220, 79));
		
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
		ActionListener button_listener = new ButtonListener();
		
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
		home.addActionListener(button_listener);
		
		settings.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
		settings.addActionListener(button_listener);
		
		warnings.setBorder(BorderFactory.createEmptyBorder());
		warnings.setContentAreaFilled(false);
		warnings.addActionListener(button_listener);
		
		// temporary close button
		JButton exit = new JButton("Exit System");
		exit.setBounds(200, 200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		// add components to the panel
		notes_panel.add(title);
		notes_panel.add(exit);
		options_panel.add(verticalBox, c);
		
		// add the panels to the frame
		notes_frame.add(options_panel, BorderLayout.LINE_START);
		notes_frame.add(notes_panel);	
		
		// Set program as full screen
		device.setFullScreenWindow(notes_frame);
		
	}
	
}
