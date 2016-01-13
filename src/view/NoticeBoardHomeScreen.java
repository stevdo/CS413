package view;

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

import controller.ColourCollect;
import controller.ImageCollect;

public class NoticeBoardHomeScreen {

	private JFrame main_frame;
	private ActionListener button_listener;

	public NoticeBoardHomeScreen(JFrame noticeboard_frame) {
		main_frame = noticeboard_frame;
	}

	public void addButtonListener(ActionListener button_listener) {
		this.button_listener = button_listener;
		System.out.println("Home screen; listener added");
	}

	public void init_HomeScreen() {

		main_frame.getContentPane().removeAll();

		ImageIcon note_icon = ImageCollect.getHomeImageNoteIcon();
		ImageIcon settings_icon = ImageCollect.getHomeImageSettingsIcon();
		ImageIcon warning_icon = ImageCollect.getHomeImageWarningIcon();

		// get the colour for the noticeboard
		Color colour = ColourCollect.getCurrentColour();
		System.out.println("Home screen colour; " + colour);

		// create panel to sit on top of frame
		JPanel main_panel = new JPanel();
		main_panel.setSize(main_frame.getWidth(), main_frame.getHeight());
		main_panel.setBackground(colour);
		main_panel.setVisible(true);
		main_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER; // adding c makes the
													// content take up the
													// entire row
		c.insets = new Insets(10, 0, 10, 0); // padding

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
		notes.addActionListener(button_listener);

		settings.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
		settings.addActionListener(button_listener);

		warnings.setBorder(BorderFactory.createEmptyBorder());
		warnings.setContentAreaFilled(false);
		warnings.addActionListener(button_listener);


		// Create container for buttons
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(notes);
		horizontalBox.add(Box.createRigidArea(new Dimension(75, 0))); // Adds
																		// space
																		// between
																		// buttons
		horizontalBox.add(settings);
		horizontalBox.add(Box.createRigidArea(new Dimension(75, 0))); // Adds
																		// space
																		// between
																		// buttons
		horizontalBox.add(warnings);

		// add the buttons to the panel
		main_panel.add(horizontalBox, c);

		// adds panel to the frame
		main_frame.add(main_panel);

	}
}
