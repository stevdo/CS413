package model;

import javax.swing.ImageIcon;

import view.NoticeBoardHomeScreen;
import view.NoticeBoardNotesScreen;

public class NoticeboardImages {

	private static ImageIcon home_icon;
	private static ImageIcon note_icon;
	private static ImageIcon warning_icon;
	private static ImageIcon settings_icon;
	private static ImageIcon home_note_icon;
	private static ImageIcon home_warning_icon;
	private static ImageIcon home_settings_icon;
	
	// need a class to initialise the images for the sideImages
	public static void setSideImages(){
		java.net.URL stickyPNG = NoticeBoardHomeScreen.class.getResource(
                "/side_images/sticky_note.png");
		note_icon = new ImageIcon(stickyPNG);
		
		java.net.URL settingsPNG = NoticeBoardHomeScreen.class.getResource(
                "/side_images/settings.png");
		settings_icon = new ImageIcon(settingsPNG);
		
		java.net.URL warningPNG = NoticeBoardHomeScreen.class.getResource(
                "/side_images/warning.png");
		warning_icon = new ImageIcon(warningPNG);
		
		java.net.URL homePNG = NoticeBoardNotesScreen.class.getResource(
				"/side_images/home.png");
		home_icon = new ImageIcon(homePNG);
	}
	
	// need a class to initilaise the images for the home screen
	public static void setHomeImages(){
		java.net.URL stickyPNG = NoticeBoardHomeScreen.class.getResource(
                "/home_images/sticky_note.png");
		home_note_icon = new ImageIcon(stickyPNG);
		
		java.net.URL settingsPNG = NoticeBoardHomeScreen.class.getResource(
                "/home_images/settings.png");		
		home_settings_icon = new ImageIcon(settingsPNG);
		
		java.net.URL warningPNG = NoticeBoardHomeScreen.class.getResource(
                "/home_images/warning.png");
		home_warning_icon = new ImageIcon(warningPNG);
	}
	
	// get methods to get the images
	public static ImageIcon getSideImageHomeIcon(){
		return home_icon;
	}
	
	public static ImageIcon getSideImageNoteIcon(){
		return note_icon;
	}
	
	public static ImageIcon getSideImageSettingsIcon(){
		return settings_icon;
	}
	
	public static ImageIcon getSideImageWarningIcon(){
		return warning_icon;
	}
	
	public static ImageIcon getHomeImageNoteIcon(){
		return home_note_icon;
	}
	
	public static ImageIcon getHomeImageSettingsIcon(){
		return home_settings_icon;
	}
	
	public static ImageIcon getHomeImageWarningIcon(){
		return home_warning_icon;
	}
	
}
