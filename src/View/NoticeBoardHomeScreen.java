package View;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;

import controller.ExitActionListener;
import controller.ButtonListener;

public class NoticeBoardHomeScreen {	
	
	public void init_HomeScreen(){
		
		java.net.URL stickyPNG = NoticeBoardHomeScreen.class.getResource(
                 "/images/sticky_note.png");
		ImageIcon note_icon = new ImageIcon(stickyPNG);
		java.net.URL settingsPNG = NoticeBoardHomeScreen.class.getResource(
                 "/images/settings.png");
		ImageIcon settings_icon = new ImageIcon(settingsPNG);
		java.net.URL warningPNG = NoticeBoardHomeScreen.class.getResource(
                 "/images/warning.png");
		ImageIcon warning_icon = new ImageIcon(warningPNG);
		
		// create the main frame for the notice board
		JFrame main_frame = new JFrame();
		GraphicsDevice device = main_frame.getGraphicsConfiguration().getDevice();
		main_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main_frame.setUndecorated(true);
		main_frame.setTitle("CS413 NoticeBoard");
		main_frame.setVisible(true);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		// create panel to sit on top of frame
		JPanel main_panel = new JPanel();
		main_panel.setSize(main_frame.getWidth(), main_frame.getHeight());
		main_panel.setBackground(new Color(64, 220, 79));
		main_panel.setVisible(true);	
		main_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER; //adding c makes the content take up the entire row
		c.insets = new Insets(10, 0, 10, 0); //padding
		
		//ActionListener's
		ActionListener exitActionListener;
		exitActionListener = new ExitActionListener();
		ActionListener hmb = new ButtonListener();
		
		// create 3 Buttons for the home_screen
		JButton notes = new JButton(note_icon);
		JButton settings = new JButton(settings_icon);
		JButton warnings = new JButton(warning_icon);
		
		notes.setActionCommand("0");
	    settings.setActionCommand("1");
	    warnings.setActionCommand("2");
		
		// size and location of the buttons
		notes.setBorder(BorderFactory.createEmptyBorder());
		notes.setContentAreaFilled(false);
		notes.addActionListener(hmb);
						
		settings.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
		settings.addActionListener(hmb);
		
		warnings.setBorder(BorderFactory.createEmptyBorder());
		warnings.setContentAreaFilled(false);
		warnings.addActionListener(hmb);
		
		//Exit system button for test purposes		
		JButton exit = new JButton("Exit System");
		exit.addActionListener(exitActionListener);
		
		//Create container for buttons
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(notes);
		horizontalBox.add(Box.createRigidArea(new Dimension(75,0))); //Adds space between buttons
		horizontalBox.add(settings);
		horizontalBox.add(Box.createRigidArea(new Dimension(75,0))); //Adds space between buttons
		horizontalBox.add(warnings);
		
		// add the buttons to the panel
		main_panel.add(horizontalBox, c);
		main_panel.add(exit);
		
		// adds panel to the frame
		main_frame.add(main_panel);		
		
		//Set program as full screen
		device.setFullScreenWindow(main_frame);
	}	
}
