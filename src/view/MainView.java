package view;

import java.awt.GraphicsDevice;

import javax.swing.JFrame;

public class MainView {		

	private static JFrame noticeboard_frame = new JFrame();
	GraphicsDevice device = noticeboard_frame.getGraphicsConfiguration().getDevice();
	
	public void updateWindow(String screen){
		
		//noticeboard_frame.removeAll();
		
		if(screen.equals("notes")){
			NoticeBoardNotesScreen notes_view = new NoticeBoardNotesScreen(noticeboard_frame);
			notes_view.init_NotesScreen();			
		}
		else if(screen.equals("settings")){
			NoticeBoardSettingsScreen settings_view = new NoticeBoardSettingsScreen(noticeboard_frame);
			settings_view.init_SettingsScreen();
		}
		else if(screen.equals("warnings")){
			NoticeBoardWarningsScreen warning_view = new NoticeBoardWarningsScreen(noticeboard_frame);
			warning_view.init_WarningsScreen();
		}
		else if(screen.equals("home")){
			NoticeBoardHomeScreen home_view = new NoticeBoardHomeScreen(noticeboard_frame);
			home_view.init_HomeScreen();
		}
		else if(screen.equals("Write")){
			NoticeBoardWriteMessage write_view = new NoticeBoardWriteMessage(noticeboard_frame);
			write_view.init_WriteScreen();
		}
		else{
			System.out.println("Error: Screen not recognised.");
		}
		
		//Set program as full screen
		device.setFullScreenWindow(noticeboard_frame);
		
	}
	
	public static JFrame getMainFrame(){
		return noticeboard_frame;
	}
	
	public void init_NoticeboardFrame(){
		 //JFrame noticeboard_frame = new JFrame();
		// may need to add the code to make this frame the device		
		noticeboard_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		noticeboard_frame.setUndecorated(true);
		
	}
	
	public void update(){
		noticeboard_frame.validate();
		noticeboard_frame.repaint();
		noticeboard_frame.setVisible(true);
	}
}
