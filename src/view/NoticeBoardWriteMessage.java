package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.ButtonListener;
import controller.ColourCollect;
import controller.ExitActionListener;
import controller.KeyboardListener;
import controller.ImageCollect;

public class NoticeBoardWriteMessage {

	JFrame write_frame = new JFrame();

	public NoticeBoardWriteMessage(JFrame notes_frame) {
		write_frame = notes_frame;
	}

	public void init_WriteScreen() {
		
		write_frame.getContentPane().removeAll();
		
		// get the colour for the noticeboard
		Color colour = ColourCollect.getCurrentColour();

		BorderLayout border_layout = new BorderLayout();
		write_frame.setLayout(border_layout);

		// get the needed images, may need the fourth icon?
		ImageIcon home_icon = ImageCollect.getSideImageHomeIcon();
		ImageIcon settings_icon = ImageCollect.getSideImageSettingsIcon();
		ImageIcon warning_icon = ImageCollect.getSideImageWarningIcon();
		
		// 2 panels for the screen
		JPanel write_panel = new JPanel();
		write_panel.setBackground(colour);
		write_panel.setLayout(new GridLayout(2, 0, 0, 0));

		// 2 panels to go within write_panel
		JPanel top_panel = new JPanel();
		JPanel lower_panel = new JPanel();
		top_panel.setBackground(colour);
		top_panel.setLayout(new GridBagLayout());
		lower_panel.setBackground(colour);
		lower_panel.setLayout(new GridBagLayout());

		// dimensions for components on the screen
		int options_width = (int) (write_frame.getWidth() - (0.88 * write_frame.getWidth()));

		JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width, write_frame.getHeight()));
		options_panel.getPreferredSize();
		options_panel.setBackground(new Color(153, 76, 0));
		options_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER; // adding c makes the content take up the entire row
		c.insets = new Insets(10, 0, 10, 0); // padding

		JTextField textField = new JTextField();
		textField.setColumns(15);
		textField.setBackground(new Color(240, 230, 80));
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setColumns(60);
		textArea2.setRows(5);
		textArea2.setBackground(new Color(240, 230, 80));
		
		// ActionListener's
		ActionListener exitActionListener = new ExitActionListener();
		ActionListener button_listener = new ButtonListener();
		ActionListener keyboard_listener = new KeyboardListener();

		// 4 buttons needed
		JButton home = new JButton(home_icon);
		JButton settings = new JButton(settings_icon);
		JButton warnings = new JButton(warning_icon);

		JButton add_note = new JButton("Add Note");
		add_note.setBackground(Color.red);

		// set the action commands for the buttons
		settings.setActionCommand("1");
		warnings.setActionCommand("2");
		home.setActionCommand("3");

		// Create container for buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(home);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); // Adds space between buttons
		verticalBox.add(settings);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); // Adds space between buttons
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

		// temporary exit button
		JButton exit = new JButton("Exit System");
		exit.setBounds(0, 0, 150, 100);
		exit.addActionListener(exitActionListener);

		// Touch Keyboard
		JPanel keyboard = new JPanel(new GridLayout(0, 1));
		JPanel[] panel_array;
		JButton[][] keys;
		final String[][] keys_array = { { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "Backspace" },
				{ "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "Return" },
				{ "A", "S", "D", "F", "G", "H", "J", "K", "L" },
				{ "Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?" }, { "Space" } };

		panel_array = new JPanel[5];
		for (int across = 0; across < keys_array.length; across++) {
			panel_array[across] = new JPanel();
			panel_array[across].setBackground(new Color(64, 220, 79));
			keys = new JButton[20][20];
			for (int vertical = 0; vertical < keys_array[across].length; vertical++) {
				keys[across][vertical] = new JButton(keys_array[across][vertical]);
				keys[across][vertical].addActionListener(keyboard_listener);
				keys[across][vertical].putClientProperty("buttonPressed", keys_array[across][vertical]);
				panel_array[across].add(keys[across][vertical]);
			}
			keyboard.add(panel_array[across]);
		}
		lower_panel.add(keyboard, c);

		// add to the panel
		top_panel.add(textField, c);
		top_panel.add(textArea2, c);
		top_panel.add(exit);
		top_panel.add(add_note);
		write_panel.add(top_panel);
		write_panel.add(lower_panel);
		options_panel.add(verticalBox, c);

		// add to the frame
		write_frame.add(options_panel, BorderLayout.LINE_START);
		write_frame.add(write_panel, BorderLayout.CENTER);
	}
}
