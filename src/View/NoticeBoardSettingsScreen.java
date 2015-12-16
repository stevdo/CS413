package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;







import controller.ButtonListener;
import controller.ExitActionListener;

public class NoticeBoardSettingsScreen {

	public void init_SettingsScreen(){
		
		// The images for the buttons
		java.net.URL homePNG = NoticeBoardNotesScreen.class.getResource(
				"/images/home.png");
		ImageIcon home_icon = new ImageIcon(homePNG);
		java.net.URL warningPNG = NoticeBoardHomeScreen.class.getResource(
                "/images/warning.png");
		ImageIcon warning_icon = new ImageIcon(warningPNG);
		java.net.URL stickyPNG = NoticeBoardHomeScreen.class.getResource(
                "/images/sticky_note.png");
		ImageIcon note_icon = new ImageIcon(stickyPNG);
		
		// settings screen frame
		JFrame settings_frame = new JFrame();
		GraphicsDevice device = settings_frame.getGraphicsConfiguration().getDevice();
		settings_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		settings_frame.setUndecorated(true);
		settings_frame.setVisible(true);
		
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
		settings_panel.setBackground(new Color(64, 220, 79));
		
		JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width, settings_frame.getHeight()));
		options_panel.getPreferredSize();
		options_panel.setBackground(new Color(153, 76, 0));
		
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
		
		//temporary exit button
		JButton exit = new JButton("Exit System"); 
		exit.setBounds(200, 200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		// add to the panels
		settings_panel.add(title);
		settings_panel.add(exit);
		options_panel.add(home);
		options_panel.add(notes);
		options_panel.add(warnings);
		
		// add to the frame	
		settings_frame.add(options_panel, BorderLayout.LINE_START);
		settings_frame.add(settings_panel, BorderLayout.CENTER);
		
		// Set program as full screen
		device.setFullScreenWindow(settings_frame);
		
	}
	
}
