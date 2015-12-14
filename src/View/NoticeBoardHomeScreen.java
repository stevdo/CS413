package View;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ExitActionListener;

public class NoticeBoardHomeScreen {	
	
	public void init_HomeScreen(){
		
		ImageIcon note_icon = new ImageIcon("sticky_note.png");
		ImageIcon settings_icon = new ImageIcon("settings.png");
		ImageIcon warning_icon = new ImageIcon("warning.png");
		
		int notes_width = note_icon.getIconWidth();
		int notes_height = note_icon.getIconHeight();
		int settings_width = settings_icon.getIconWidth();
		int settings_height = settings_icon.getIconHeight();
		int warning_width = warning_icon.getIconWidth();
		int warning_height = warning_icon.getIconHeight();		
		
		// create the main frame for the notice board
		JFrame main_frame = new JFrame();
		main_frame.setSize(1000, 700);
		main_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main_frame.setUndecorated(true);
		main_frame.setTitle("CS413 NoticeBoard");
		main_frame.setVisible(true);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setLayout(null);
		main_frame.setResizable(false);
				
		// create panel to sit on top of frame
		JPanel main_panel = new JPanel();
		main_panel.setSize(main_frame.getWidth(), main_frame.getHeight());
		main_panel.setBackground(new Color(64, 220, 79));
		main_panel.setVisible(true);
		main_panel.setLayout(null);		
				
		// create 3 Buttons for the home_screen
		JButton notes = new JButton(note_icon);
		JButton settings = new JButton(settings_icon);
		JButton warnings = new JButton(warning_icon);
		
		//Exit system button for test purposes		
		JButton exit = new JButton("Exit System");
		exit.setBounds(6, 6, 100, 20);
		ActionListener exitActionListener;
		exitActionListener = new ExitActionListener();
		
		exit.addActionListener(exitActionListener);
		
		// size and location of the buttons
		notes.setBounds(100, 225, notes_width, notes_height);
		notes.setBorder(BorderFactory.createEmptyBorder());
		notes.setContentAreaFilled(false);
				
		settings.setBounds(425, 225, settings_width, settings_height);
		settings.setBorder(BorderFactory.createEmptyBorder());
		settings.setContentAreaFilled(false);
		
		warnings.setBounds(750, 225, warning_width, warning_height);
		warnings.setBorder(BorderFactory.createEmptyBorder());
		warnings.setContentAreaFilled(false);
		
		// add the buttons to the panel
		main_panel.add(notes);
		main_panel.add(settings);
		main_panel.add(warnings);
		main_panel.add(exit);
		
		// add the components to the frame
		main_frame.add(main_panel);
		
	}

	public static void main(String[] args) {
		NoticeBoardHomeScreen view = new NoticeBoardHomeScreen();
		view.init_HomeScreen();

	}
}
