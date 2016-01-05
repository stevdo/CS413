package controller;

public class CurrentTextComponent {
	
	public static String current_text_component;

	public static void setCurrentFocusedTextComponent(String name){
		current_text_component = name;
	}
	
	public static String getCurrentComponent(){
		return current_text_component;
	}
	
}
