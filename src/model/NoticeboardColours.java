package model;

import java.awt.Color;
import java.util.HashMap;

/**
 * 
 * @author Group 3
 * 
 * Not sure if this class should be in here or if this class
 * should be made as part of the view. Can change later if 
 * needed. 
 *
 */

public class NoticeboardColours {

	private static Color current_colour;
	private static HashMap<String, Color> colour_from_String = new HashMap<String, Color>();
	
	public NoticeboardColours(){
		current_colour = new Color(64, 220, 79);
		colour_from_String.put("red", new Color(233, 63, 63));
		colour_from_String.put("blue", new Color(86, 200, 249));
		colour_from_String.put("orange", new Color(246, 130, 41));
	}
	
	/*
	 * May need to change this method, may need this to work
	 * passing in a string and then having a hashmap to change 
	 * the string to a colour
	 */
	public void setNoticeboardColour(String new_colour){
		System.out.println("settings colour to: " + new_colour);
		current_colour = getColourFromString(new_colour);		
	}
	
	public Color getNoticeboardColour(){
		return current_colour;
	}
	
	private Color getColourFromString(String new_colour){
		return colour_from_String.get(new_colour);
	}
	
	
}
