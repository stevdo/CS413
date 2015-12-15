package View;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ExitActionListener;

public class NoticeBoardNotesScreen {

	// need to include the images here
	
	public void init_SettingsScreen(){
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
		
		JPanel settings_panel = new JPanel();		
		settings_panel.setSize(settings_width, settings_frame.getHeight());
		settings_panel.setBackground(new Color(64, 220, 79));
		
		
		// ActionListener's
		ActionListener exitActionListener = new ExitActionListener();
		// need to make SettingsScreenListner class
		
		// temporary close button
		JButton exit = new JButton("Exit System");
		exit.setBounds(200,200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		// add components to the panel
		settings_panel.add(exit);
		
		// add the panel to the frame
		settings_frame.add(settings_panel);
		
		
	}
	
}
