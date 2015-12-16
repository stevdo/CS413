package controller;

import javax.swing.ImageIcon;

import model.NoticeboardImages;

public class ImageCollect {

	// not sure if this class is needed here/ how it should be done
	
	public static ImageIcon getSideImageHomeIcon(){
		ImageIcon home_icon = NoticeboardImages.getSideImageHomeIcon();
		return home_icon;
	}
	
	public static ImageIcon getSideImageNoteIcon(){
		ImageIcon note_icon = NoticeboardImages.getSideImageNoteIcon();
		return note_icon;
	}
	
	public static ImageIcon getSideImageSettingsIcon(){
		ImageIcon settings_icon = NoticeboardImages.getSideImageSettingsIcon();
		return settings_icon;
	}
	
	public static ImageIcon getSideImageWarningIcon(){
		ImageIcon warning_icon = NoticeboardImages.getSideImageWarningIcon();
		return warning_icon;
	}
	
	public static ImageIcon getHomeImageNoteIcon(){
		ImageIcon home_note_icon = NoticeboardImages.getHomeImageNoteIcon();
		return home_note_icon;
	}
	
	public static ImageIcon getHomeImageSettingsIcon(){
		ImageIcon home_settings_icon = NoticeboardImages.getHomeImageSettingsIcon();
		return home_settings_icon;
	}
	
	public static ImageIcon getHomeImageWarningIcon(){
		ImageIcon home_warning_icon = NoticeboardImages.getHomeImageWarningIcon();
		return home_warning_icon;
	}
	
	
}
