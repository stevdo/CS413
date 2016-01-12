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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ColourCollect;
import controller.ComboListener;
import controller.ExitActionListener;
import controller.ImageCollect;

public class NoticeBoardSettingsScreen {

	public final static JLabel connectedLabel1 = new JLabel(
			"You are connected to the internet.");
	public final static JLabel connectedLabel2 = new JLabel(
			"You are not connected to the internet.");
	public static JComboBox colourList;
	public static String[] colours = new String[] { "Select...", "Green",
			"Red", "Blue", "Orange", "Purple", "Pink" };

	private JFrame settings_frame = new JFrame();
	private ActionListener button_listener;
	private int device_pin = 1;

	public NoticeBoardSettingsScreen(JFrame noticeboard_frame) {
		settings_frame = noticeboard_frame;
	}

	public void addButtonListener(ActionListener button_listener) {
		this.button_listener = button_listener;
		System.out.println("Settings screen; listener added");
	}

	public void setDevicePin(int device_pin) {
		System.out.println("Settings screen; pin set: " + device_pin);
		this.device_pin = device_pin;
	}

	public void init_SettingsScreen() {

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
		int settings_width = (int) (settings_frame.getWidth() - (0.12 * settings_frame
				.getWidth()));
		int options_width = (int) (settings_frame.getWidth() - (0.88 * settings_frame
				.getWidth()));
		int title_font_size = (int) (0.05 * settings_frame.getWidth());

		// JLabel for the title of the current screen
		JLabel title = new JLabel("Settings");
		title.setFont(new Font("Serif", Font.BOLD, title_font_size));

		// create the two panels needed for the screen
		JPanel settings_panel = new JPanel();
		settings_panel.setSize(settings_width, settings_frame.getHeight());
		settings_panel.setBackground(colour);
		settings_panel.setLayout(new GridBagLayout());

		JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width,
				settings_frame.getHeight()));
		options_panel.getPreferredSize();
		options_panel.setBackground(new Color(153, 76, 0));
		options_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER; // adding c makes the
													// content take up the
													// entire row
		c.insets = new Insets(10, 0, 10, 0); // padding

		// ActionListener's
		ActionListener exitActionListener = new ExitActionListener();
		ActionListener comboListener = new ComboListener();

		// 3 buttons for the screen
		JButton home = new JButton(home_icon);
		JButton notes = new JButton(note_icon);
		JButton warnings = new JButton(warning_icon);

		// Reboot button
		JButton reboot = new JButton("Reboot");
		reboot.setActionCommand("7");
		reboot.addActionListener(button_listener);

		// Shut down button
		JButton shutdown = new JButton("Shut Down");
		shutdown.setActionCommand("6");
		shutdown.addActionListener(button_listener);

		home.setActionCommand("3");
		notes.setActionCommand("0");
		warnings.setActionCommand("2");

		// Testing for connection
		connectedLabel1.setVisible(false);
		connectedLabel2.setVisible(false);

		JLabel pressLabel = new JLabel(
				"Press button to test connection to internet:");
		JButton testConnection = new JButton("Test connection");
		testConnection.addActionListener(button_listener);
		testConnection.setActionCommand("8");

		// Colour chooser
		JLabel label1 = new JLabel("Choose a background colour:");
		JButton chooseColour = new JButton("Choose!");

		colourList = new JComboBox(colours);
		colourList.setSelectedIndex(0);
		colourList.setEditable(false);
		colourList.addActionListener(comboListener);

		chooseColour.setActionCommand("5");

		// Create container for buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(home);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); // Adds
																	// space
																	// between
																	// buttons
		verticalBox.add(notes);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); // Adds
																	// space
																	// between
																	// buttons
		verticalBox.add(warnings);

		// Container for colour buttons
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(label1);
		horizontalBox.add(Box.createRigidArea(new Dimension(10, 0)));
		horizontalBox.add(colourList);
		horizontalBox.add(Box.createRigidArea(new Dimension(10, 0)));
		horizontalBox.add(chooseColour);

		Box horizontalBox2 = Box.createHorizontalBox();
		horizontalBox2.add(pressLabel);
		horizontalBox2.add(Box.createRigidArea(new Dimension(10, 0)));
		horizontalBox2.add(testConnection);

		Box horiBox = Box.createHorizontalBox();
		horiBox.add(reboot);
		horiBox.add(Box.createRigidArea(new Dimension(10, 0)));
		horiBox.add(shutdown);

		home.setBorder(BorderFactory.createEmptyBorder());
		home.setContentAreaFilled(false);
		home.addActionListener(button_listener);

		notes.setBorder(BorderFactory.createEmptyBorder());
		notes.setContentAreaFilled(false);
		notes.addActionListener(button_listener);

		warnings.setBorder(BorderFactory.createEmptyBorder());
		warnings.setContentAreaFilled(false);
		warnings.addActionListener(button_listener);

		JLabel device_pin_label = new JLabel(
				"The device pin for this device is: " + device_pin);

		chooseColour.addActionListener(button_listener);

		// add to the panels
		settings_panel.add(title, c);
		settings_panel.add(horizontalBox, c);
		settings_panel.add(horizontalBox2, c);
		settings_panel.add(connectedLabel1, c);
		settings_panel.add(connectedLabel2, c);
		settings_panel.add(device_pin_label, c);
		settings_panel.add(horiBox, c);
		options_panel.add(verticalBox, c);

		// add to the frame
		settings_frame.add(options_panel, BorderLayout.LINE_START);
		settings_frame.add(settings_panel, BorderLayout.CENTER);

	}

}
