package view;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.ButtonListener;
import controller.ExitActionListener;
import controller.ImageCollect;

public class NoticeBoardWriteMessage {

	JFrame write_frame = new JFrame();
	
	public NoticeBoardWriteMessage(JFrame notes_frame){
		write_frame = notes_frame;
	}
	
	public void init_WriteScreen(){
		/* don't want to void the noticeboard screen? want to
		 * pass it in an put a layer over the top of it?
		 */
		
		write_frame.getContentPane().removeAll();		
		
		BorderLayout border_layout = new BorderLayout();
		write_frame.setLayout(border_layout);
		
		// get the needed images, may need the fourth icon?
		ImageIcon home_icon = ImageCollect.getSideImageHomeIcon();
		ImageIcon settings_icon = ImageCollect.getSideImageSettingsIcon();
		ImageIcon warning_icon = ImageCollect.getSideImageWarningIcon();
		
		// dimensions for components on the screen
		int write_width = (int) (write_frame.getWidth() -
				(0.12 * write_frame.getWidth()));
		int options_width = (int) (write_frame.getWidth() - 
				(0.88 * write_frame.getWidth()));
		int title_height = (int)  (write_frame.getHeight() - 
				0.9 * write_frame.getHeight());
		int text_height = (int)  (write_frame.getHeight() - 
				0.7 * write_frame.getHeight());
		int text_area_width = (int) (write_frame.getWidth() - 
				0.25 * write_frame.getWidth());
		int title_y = (int)(write_frame.getWidth() - 
				0.9375 * write_frame.getWidth());
		int text_y = (int) (write_frame.getHeight() - 
				0.425 * write_frame.getWidth());
		int text_area_x = (int) (write_frame.getWidth() - 
				0.9 * write_frame.getWidth());
		int add_note_x = (int) (write_frame.getWidth() - 
				0.5 * write_frame.getWidth())-150;
		
		// 2 panels for the screen		    		
		JPanel write_panel = new JPanel();
	    write_panel.setBounds(100, 100, write_width, write_frame.getHeight());
	    write_panel.setBackground(new Color(64, 220, 79));	    
	    write_panel.setLayout(null);
	    
	    JPanel options_panel = new JPanel();
		options_panel.setPreferredSize(new Dimension(options_width, write_frame.getHeight()));
		options_panel.getPreferredSize();
		options_panel.setBackground(new Color(153, 76, 0));
		options_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER; //adding c makes the content take up the entire row
		c.insets = new Insets(10, 0, 10, 0); //padding
	    
	    // 2 JLabels's
	    
	    // 2 Text Area's
	    JTextArea title = new JTextArea();
	    title.setBounds(text_area_x, title_y, text_area_width, title_height);
	    title.setBackground(new Color(240, 230, 80));
	    
	    JTextArea text = new JTextArea();
	    text.setBounds(text_area_x, text_y, text_area_width, text_height);
	    text.setBackground(new Color(240, 230, 80));
	    
	    // 2 scroll panes for the text area's
	    JScrollPane title_pane = new JScrollPane(title);
	    title_pane.setBounds(text_area_x, title_y, text_area_width, title_height);
	    
	    JScrollPane text_pane = new JScrollPane(text);
	    text_pane.setBounds(text_area_x, text_y, text_area_width, text_height);
	  	    
	    // ActionListener's
	    ActionListener exitActionListener = new ExitActionListener();
	    ActionListener button_listener = new ButtonListener();
	    
	    // 4 buttons needed
	    JButton home = new JButton(home_icon);
		JButton settings = new JButton(settings_icon);
		JButton warnings = new JButton(warning_icon);
		
		JButton add_note = new JButton("Add Note");
		add_note.setBounds(add_note_x, 0, 150, 100);
		add_note.setBackground(Color.red);
		
			    
	    // set the action commands for the buttons
		settings.setActionCommand("1");
		warnings.setActionCommand("2");
		home.setActionCommand("3");
		
		//Create container for buttons
		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(home);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); //Adds space between buttons
		verticalBox.add(settings);
		verticalBox.add(Box.createRigidArea(new Dimension(0, 80))); //Adds space between buttons
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
	    
	    // add to the panel
		write_panel.add(title_pane);
		write_panel.add(text_pane);
		write_panel.add(exit);
		write_panel.add(add_note);
		options_panel.add(verticalBox, c);
	    
	    // add to the frame
	    write_frame.add(options_panel, BorderLayout.LINE_START);
	    write_frame.add(write_panel, BorderLayout.CENTER);	    		
	}	
}
