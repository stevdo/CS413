package controller;

import View.NoticeBoardNotesScreen;
import View.NoticeBoardHomeScreen;
import View.NoticeBoardSettingsScreen;

public class Main {
	public static void main(String[] args) {
		
		// open the system on the HomeScreen page
		/*NoticeBoardHomeScreen view = new NoticeBoardHomeScreen();
		view.init_HomeScreen();*/
		
		// the following are tests, to open the system on other pages
		/*NoticeBoardNotesScreen settings_view = new NoticeBoardNotesScreen();
		settings_view.init_SettingsScreen();*/
		NoticeBoardSettingsScreen settings_view = new NoticeBoardSettingsScreen();
		settings_view.init_SettingsScreen();
	}
}
