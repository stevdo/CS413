package controller;

import java.awt.Color;

import model.NoticeboardColours;

public class ColourCollect {
	
	public static Color colour;
	public static NoticeboardColours nc = new NoticeboardColours();
	
	// method to get the colour from the model
	public static Color getCurrentColour(){
		colour = nc.getNoticeboardColour();
		return colour;
	}
}
