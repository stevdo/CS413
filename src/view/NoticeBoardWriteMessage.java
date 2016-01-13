package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ColourCollect;
import controller.ExitActionListener;
import controller.ImageCollect;
import controller.TextFocusListener;

public class NoticeBoardWriteMessage {

	private JFrame write_frame = new JFrame();
	private ActionListener button_listener;
	private ActionListener keyboard_listener;
	private boolean titleValid;
	private boolean textValid;
	public final static JTextField textField = new JTextField();
	public final static JTextField textField2 = new JTextField();
	public final static JTextArea textArea = new JTextArea();
	public final static JTextArea textArea2 = new JTextArea();

	public NoticeBoardWriteMessage(JFrame notes_frame) {
		write_frame = notes_frame;
	}

	public void addButtonListener(ActionListener button_listener) {
		this.button_listener = button_listener;
		System.out.println("Write screen; button listener added");
	}

	public void addKeyboardListener(ActionListener keyboard_listener) {
		this.keyboard_listener = keyboard_listener;
		System.out.println("Write screen; keyboard listener added");
	}

	public void setTitleInvalid() {
		titleValid = false;
	}

	public void setTextInvalid() {
		textValid = false;
	}

	public void setTitleValid() {
		titleValid = true;
	}

	public void setTextValid() {
		textValid = true;
	}

	public void init_WriteScreen() {

		if (!titleValid) {
			System.out.println("Title not valid");
		}

		if (!textValid) {
			System.out.println("Text not valid");
		}

		write_frame.getContentPane().removeAll();

		// get the colour for the noticeboard
		Color colour = ColourCollect.getCurrentColour();

		BorderLayout border_layout = new BorderLayout();
		write_frame.setLayout(border_layout);

		// get the needed images, may need the fourth icon?
		ImageIcon home_icon = ImageCollect.getSideImageHomeIcon();
		ImageIcon settings_icon = ImageCollect.getSideImageSettingsIcon();
		ImageIcon warning_icon = ImageCollect.getSideImageWarningIcon();

		// Hidden Panel
		final JPanel hidden_panel = new JPanel();
		hidden_panel.setBackground(colour);
		hidden_panel.setLayout(new GridBagLayout());

		// 2 panels for the screen
		final JPanel write_panel = new JPanel();
		write_panel.setBackground(colour);
		write_panel.setLayout(new GridLayout(2, 0, 0, 0));

		// 2 panels to go within write_panel
		final JPanel top_panel = new JPanel();
		final JPanel lower_panel = new JPanel();
		top_panel.setBackground(colour);
		top_panel.setLayout(new GridBagLayout());
		lower_panel.setBackground(colour);
		lower_panel.setLayout(new GridBagLayout());

		// Panel for switching
		final JPanel top_panel_clone = new JPanel();
		top_panel_clone.setBackground(colour);
		top_panel_clone.setLayout(new GridBagLayout());

		// dimensions for components on the screen
		int options_width = (int) (write_frame.getWidth() - (0.88 * write_frame
				.getWidth()));
		
		//Initialise components for keyboard
		JPanel keyboard = new JPanel(new GridLayout(0, 1)); //Keyboard layout
		JPanel[] panel_array;
		JButton[][] keys;
		//Different array for each row on the keyboard
		final String[][] keys_array = {
				{ "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=",
						"Backspace" },
				{ "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "Return" },
				{ "A", "S", "D", "F", "G", "H", "J", "K", "L" },
				{ "Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?" },
				{ "Space" } };

		JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width, write_frame
				.getHeight()));
		options_panel.getPreferredSize();
		options_panel.setBackground(new Color(153, 76, 0));
		options_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER; // adding c makes the
													// content take up the
													// entire row
		c.insets = new Insets(10, 0, 10, 0); // padding

		textField.setColumns(15);
		textField.setBackground(new Color(240, 230, 80));

		textField2.setColumns(15);
		textField2.setBackground(new Color(240, 230, 80));

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JScrollPane scroll2 = new JScrollPane(textArea2);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		textArea.setColumns(60);
		textArea.setRows(5);
		textArea.setBackground(new Color(240, 230, 80));

		textArea2.setColumns(60);
		textArea2.setRows(10);
		textArea2.setBackground(new Color(240, 230, 80));

		// adding focus listeners for the text field and text area
		MouseListener focus = new TextFocusListener();
		textField.addMouseListener(focus);
		textArea.addMouseListener(focus);
		textField.setName("text field");
		textArea.setName("text area");

		// Buttons
		JButton home = new JButton(home_icon);
		JButton settings = new JButton(settings_icon);
		JButton warnings = new JButton(warning_icon);

		JButton add_note = new JButton("Add Note");

		JButton add_note2 = new JButton("Add Note");

		JButton toggle_keyboard = new JButton("Toggle Keyboard");
		toggle_keyboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textArea.getText();
				textArea2.setText(t);
				String t2 = textField.getText();
				textField2.setText(t2);
				hidden_panel.remove(write_panel);
				hidden_panel.add(top_panel_clone);
				hidden_panel.revalidate();
				hidden_panel.repaint();
			}
		});

		JButton toggle_keyboard2 = new JButton("Toggle Keyboard");
		toggle_keyboard2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = textArea2.getText();
				textArea.setText(t);
				String t2 = textField2.getText();
				textField.setText(t2);
				hidden_panel.remove(top_panel_clone);
				hidden_panel.add(write_panel);
				hidden_panel.revalidate();
				hidden_panel.repaint();
			}
		});

		settings.setActionCommand("1");
		warnings.setActionCommand("2");
		home.setActionCommand("3");
		add_note.setActionCommand("13");
		add_note2.setActionCommand("13");

		// Create container for buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(home);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); // Adds
																	// space
																	// between
																	// buttons
		verticalBox.add(settings);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); // Adds
																	// space
																	// between
																	// buttons
		verticalBox.add(warnings);

		add_note.addActionListener(button_listener);
		add_note2.addActionListener(button_listener);

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
		JButton back = new JButton("Back to Notes");
		JButton back2 = new JButton("Back to Notes");
		back.setBounds(0, 0, 150, 100);
		back.addActionListener(button_listener);
		back2.setBounds(0, 0, 150, 100);
		back2.addActionListener(button_listener);
		back.setActionCommand("17");
		back2.setActionCommand("17");		

		//5 string arrays so need to create JPanel with value 5
		panel_array = new JPanel[5];
		//Creates a new button for each element in the keys_array(s)
		for (int across = 0; across < keys_array.length; across++) {
			panel_array[across] = new JPanel();
			//Colour needs to match the rest of the panel.
			panel_array[across].setBackground(colour);
			//Set to 5 as there are 5 rows at most. Set to 13 as there are 13 buttons at most in any row.
			keys = new JButton[5][13];
			for (int vertical = 0; vertical < keys_array[across].length; vertical++) {
				keys[across][vertical] = new JButton(
						keys_array[across][vertical]);
				//Adds keyboard listener to each individual key, listener looks for the letter in the key.
				keys[across][vertical].addActionListener(keyboard_listener);
				//Used in the listener
				keys[across][vertical].putClientProperty("buttonPressed",
						keys_array[across][vertical]);
				//Adds key to the appropriate panel / row
				panel_array[across].add(keys[across][vertical]);
			}
			//Adds the row to the keyboard
			keyboard.add(panel_array[across]);
		}
		lower_panel.add(keyboard, c);

		// add to the panel
		top_panel.add(textField, c);
		top_panel.add(scroll, c);
		top_panel.add(back);
		top_panel.add(add_note);
		top_panel.add(toggle_keyboard);

		top_panel_clone.add(textField2, c);
		top_panel_clone.add(scroll2, c);
		top_panel_clone.add(back2);
		top_panel_clone.add(add_note2);
		top_panel_clone.add(toggle_keyboard2);

		hidden_panel.add(top_panel_clone);

		write_panel.add(top_panel);
		write_panel.add(lower_panel);

		options_panel.add(verticalBox, c);

		// add to the frame
		write_frame.add(options_panel, BorderLayout.LINE_START);
		write_frame.add(hidden_panel, BorderLayout.CENTER);
	}
}
