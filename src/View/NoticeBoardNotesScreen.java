package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ExitActionListener;
import controller.ButtonListener;

public class NoticeBoardNotesScreen {

	public void init_SettingsScreen(){
		
		// images
		java.net.URL homePNG = NoticeBoardNotesScreen.class.getResource(
				"/images/home.png");
		ImageIcon home_icon = new ImageIcon(homePNG);
		java.net.URL settingsPNG = NoticeBoardHomeScreen.class.getResource(
                "/images/settings.png");
		ImageIcon settings_icon = new ImageIcon(settingsPNG);
		java.net.URL warningPNG = NoticeBoardHomeScreen.class.getResource(
                "/images/warning.png");
		ImageIcon warning_icon = new ImageIcon(warningPNG);
		
		// settings screen frame
		JFrame settings_frame = new JFrame();
		// do we need the GraphicsDevice line?
		settings_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		settings_frame.setUndecorated(true);
		settings_frame.setVisible(true);		
		
		
		/*
		 * need int for settings panel, exact size needs to be 
		 * experimented with
		 */
		int settings_width = (int) (settings_frame.getWidth() -
				(0.12 * settings_frame.getWidth()));
		int options_width = (int) (settings_frame.getWidth() -
				(0.88 * settings_frame.getWidth()));
		
		JPanel settings_panel = new JPanel();		
		settings_panel.setSize(settings_width, settings_frame.getHeight());
		settings_panel.setBackground(new Color(64, 220, 79));
		
		// options panel allows user to navigate between screens
		JPanel options_panel = new JPanel();
		options_panel.setSize(options_width, settings_frame.getHeight());
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
		verticalBox.add(Box.createRigidArea(new Dimension(0, 75))); //Adds space between buttons
		verticalBox.add(settings);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 75))); //Adds space between buttons
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
		exit.setBounds(200,200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		// add components to the panel
		settings_panel.add(exit);
		options_panel.add(verticalBox, c);
		
		// add the panels to the frame
		settings_frame.add(options_panel);
		settings_frame.add(settings_panel);		
		
	}
	
}
