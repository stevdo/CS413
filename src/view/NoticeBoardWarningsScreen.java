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

public class NoticeBoardWarningsScreen {
	
	JFrame warnings_frame = new JFrame();
	public static JButton windows_on = new JButton("ON");
	public static JButton windows_off = new JButton("OFF");
	public static JButton washing_on = new JButton("ON");
	public static JButton washing_off = new JButton("OFF");
	
	public NoticeBoardWarningsScreen(JFrame noticeboard_frame) {
		warnings_frame = noticeboard_frame;
	}

	public void init_WarningsScreen(){
		
		warnings_frame.getContentPane().removeAll();
		
		// get the images needed		
		ImageIcon home_icon = ImageCollect.getSideImageHomeIcon();
		ImageIcon note_icon = ImageCollect.getSideImageNoteIcon();
		ImageIcon settings_icon = ImageCollect.getSideImageSettingsIcon();
		
		// get the colour for the noticeboard
		Color colour = ColourCollect.getCurrentColour();
		
		// Frame for the window
		/*GraphicsDevice device = warnings_frame.getGraphicsConfiguration().getDevice();
		warnings_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		warnings_frame.setUndecorated(true);
		warnings_frame.setVisible(true);*/
		
		// border layout
		BorderLayout frame_layout = new BorderLayout();
		warnings_frame.setLayout(frame_layout);
		
		// The dimensions to be used for settings sizes
		int warnings_width = (int) (warnings_frame.getWidth() -
				(0.12 * warnings_frame.getWidth()));
		int options_width = (int) (warnings_frame.getWidth() - 
				(0.88 * warnings_frame.getWidth()));
		int title_font_size = (int) (0.05 * warnings_frame.getWidth());
		int warning_font = (int) (0.02 * warnings_frame.getWidth());
				
		// Label for the title
		JLabel title = new JLabel("Warnings");
		title.setFont(new Font("Serif", Font.BOLD, title_font_size));
		
		// 2 Panels
		JPanel warnings_panel = new JPanel();
		warnings_panel.setSize(warnings_width, warnings_frame.getHeight());
		warnings_panel.setBackground(colour);
		warnings_panel.setLayout(new GridBagLayout());
		
		JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width, warnings_frame.getHeight()));
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
		JButton settings = new JButton(settings_icon);
		JButton notes = new JButton(note_icon);
		
		home.setActionCommand("3");
		notes.setActionCommand("0");
		settings.setActionCommand("1");
		
		//Create container for buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(home);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); //Adds space between buttons
		verticalBox.add(notes);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); //Adds space between buttons
		verticalBox.add(settings);
		
		home.setBorder(BorderFactory.createEmptyBorder());
		home.setContentAreaFilled(false);
		home.addActionListener(button_listener);
		
		notes.setBorder(BorderFactory.createEmptyBorder());
		notes.setContentAreaFilled(false);
		notes.addActionListener(button_listener);
		
		settings.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
		settings.addActionListener(button_listener);
		
		// temporary exit button
		JButton exit = new JButton("Exit System");
		// set bounds probably has no effect anymore?
		exit.setBounds(200, 200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		
		// JLabels for the warnings
		JLabel windows_warning = new JLabel();
		windows_warning.setText("Windows have been opened");
		windows_warning.setFont(new Font("Serif", Font.BOLD, warning_font));
				
		JLabel washing_warning = new JLabel();
		washing_warning.setText("Washing has been put outside");
		washing_warning.setFont(new Font("Serif", Font.BOLD, warning_font));
				
		// JButtons for switching on and off		
		washing_on.setBackground(new Color(204, 0, 0));		
		washing_off.setBackground(new Color(51, 255, 51));		
		windows_on.setBackground(new Color(204, 0, 0));		
		windows_off.setBackground(new Color(51, 255, 51));
		
		// action commands
		windows_on.setActionCommand("9");
		windows_off.setActionCommand("10");
		washing_on.setActionCommand("11");
		washing_off.setActionCommand("12");
		
		// add action listeners
		windows_on.addActionListener(button_listener);
		windows_off.addActionListener(button_listener);
		washing_on.addActionListener(button_listener);
		washing_off.addActionListener(button_listener);
		
		// add the components to the panels
		warnings_panel.add(title);		
		warnings_panel.add(exit, c);
		warnings_panel.add(windows_warning);
		warnings_panel.add(windows_on);
		warnings_panel.add(windows_off, c);
		warnings_panel.add(washing_warning);
		warnings_panel.add(washing_on);
		warnings_panel.add(washing_off, c);
		options_panel.add(verticalBox, c);
		
		// add the panels to the frame
		
		warnings_frame.add(options_panel, BorderLayout.LINE_START);
		warnings_frame.add(warnings_panel, BorderLayout.CENTER);
		
		// Set program as full screen
		//device.setFullScreenWindow(warnings_frame);		
	}

}
