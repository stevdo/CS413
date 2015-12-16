package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ExitActionListener;

public class NoticeBoardWarningsScreen {
	
	public void init_WarningsScreen(){
		
		// The images for the buttons
		
		// Frame for the window
		JFrame warnings_frame = new JFrame();
		GraphicsDevice device = warnings_frame.getGraphicsConfiguration().getDevice();
		warnings_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		warnings_frame.setUndecorated(true);
		warnings_frame.setVisible(true);
		
		// border layout
		BorderLayout frame_layout = new BorderLayout();
		warnings_frame.setLayout(frame_layout);
		
		// The dimensions to be used for settings sizes
		int warnings_width = (int) (warnings_frame.getWidth() -
				(0.12 * warnings_frame.getWidth()));
		int options_width = (int) (warnings_frame.getWidth() - 
				(0.88 * warnings_frame.getWidth()));
		int title_font_size = (int) (0.05 * warnings_frame.getWidth());
				
		// Label for the title
		JLabel title = new JLabel("Warnings");
		title.setFont(new Font("Serif", Font.BOLD, title_font_size));
		
		// 2 Panels
		JPanel warnings_panel = new JPanel();
		warnings_panel.setSize(warnings_width, warnings_frame.getHeight());
		warnings_panel.setBackground(new Color(64, 220, 79));
		
		JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width, warnings_frame.getHeight()));
		options_panel.getPreferredSize();
		options_panel.setBackground(new Color(153, 76, 0));
		
		// ActionListener's
		ActionListener exitActionListener = new ExitActionListener();
		
		// 3 buttons for the screen
		
		// temporary exit button
		JButton exit = new JButton("Exit System");
		// set bounds probably has no effect anymore?
		exit.setBounds(200, 200, 150, 100);
		exit.addActionListener(exitActionListener);
		
		// add the components to the panels
		warnings_panel.add(title);
		warnings_panel.add(exit);
		
		// add the panels to the frame
		warnings_frame.add(options_panel, BorderLayout.LINE_START);
		warnings_frame.add(warnings_panel, BorderLayout.CENTER);
		
		// Set program as full screen
		device.setFullScreenWindow(warnings_frame);
		
	}

}
