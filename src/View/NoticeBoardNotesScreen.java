package View;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
				(0.1 * settings_frame.getWidth()));
		int options_width = (int) (settings_frame.getWidth() -
				(0.9 * settings_frame.getWidth()));
		
		JPanel settings_panel = new JPanel();		
		settings_panel.setSize(settings_width, settings_frame.getHeight());
		settings_panel.setBackground(new Color(64, 220, 79));
		
		// options panel allows user to navigate between screens
		JPanel options_panel = new JPanel();
		options_panel.setSize(options_width, settings_frame.getHeight());
		options_panel.setBackground(new Color(153, 76, 0));
		
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
		
		
		// temporary
		home.setBounds(0, 0, 150, 150);
		home.setBorder(BorderFactory.createEmptyBorder());
		home.setContentAreaFilled(false);
		home.addActionListener(button_listener);
		
		// temporary close button
		JButton exit = new JButton("Exit System");
		exit.setBounds(200,200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		// add components to the panel
		settings_panel.add(exit);
		options_panel.add(home);
		
		// add the panels to the frame
		settings_frame.add(options_panel);
		settings_frame.add(settings_panel);		
		
	}
	
}
