package model;


public class Warnings {
	
	public static String washing_warning_on = "NO";
	public static String windows_warning_on = "NO";
	
	
	public Warnings(){
		// not sure if a constructor is actually needed here
	}
	
	public static void toogleWashingWarningOn(){
		System.out.println("switching washing warning on");
		washing_warning_on = "YES";		
	}
	
	public static void toogleWashingWarningOff(){
		System.out.println("switching washing warning off");
		washing_warning_on = "NO";
	}
	
	public static void toogleWindowWarningOn(){
		System.out.println("switching window warning on");
		windows_warning_on = "YES";
	}
	
	public static void toogleWindowWarningOff(){
		System.out.println("switching window warning off");
		windows_warning_on = "NO";
	}
	
	public static String getWindowWarningCondition(){
		return windows_warning_on;
	}
	
	public static String getWashingWarningCondition(){
		return washing_warning_on;
	}
}
