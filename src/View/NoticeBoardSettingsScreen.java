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

import controller.ButtonListener;
import controller.ExitActionListener;
import controller.ImageCollect;

public class NoticeBoardSettingsScreen {

	JFrame settings_frame = new JFrame();
	
	public NoticeBoardSettingsScreen(JFrame noticeboard_frame) {
		settings_frame = noticeboard_frame;
	}

	public void init_SettingsScreen(){
		
		settings_frame.getContentPane().removeAll();
		
		// The images for the buttons
		/*java.net.URL homePNG = NoticeBoardNotesScreen.class.getResource(
				"/side_images/home.png");
		ImageIcon home_icon = new ImageIcon(homePNG);
		java.net.URL warningPNG = NoticeBoardHomeScreen.class.getResource(
                "/side_images/warning.png");
		ImageIcon warning_icon = new ImageIcon(warningPNG);
		java.net.URL stickyPNG = NoticeBoardHomeScreen.class.getResource(
                "/side_images/sticky_note.png");
		ImageIcon note_icon = new ImageIcon(stickyPNG);*/
		
		ImageIcon home_icon = ImageCollect.getSideImageHomeIcon();
		ImageIcon note_icon = ImageCollect.getSideImageNoteIcon();
		ImageIcon warning_icon = ImageCollect.getSideImageWarningIcon();
		
		// settings screen frame
		/*GraphicsDevice device = settings_frame.getGraphicsConfiguration().getDevice();
		settings_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		settings_frame.setUndecorated(true);
		settings_frame.setVisible(true);*/
		
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
		
		//temporary exit button
		JButton exit = new JButton("Exit System"); 
		exit.setBounds(200, 200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		// add to the panels
		settings_panel.add(title);
		settings_panel.add(exit);
		options_panel.add(verticalBox, c);
		
		// add to the frame	
		settings_frame.add(options_panel, BorderLayout.LINE_START);
		settings_frame.add(settings_panel, BorderLayout.CENTER);
		
		// Set program as full screen
		//device.setFullScreenWindow(settings_frame);
		
	}
	
}
