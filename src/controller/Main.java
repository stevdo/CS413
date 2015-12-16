package controller;

import View.MainView;
import View.NoticeBoardNotesScreen;
import View.NoticeBoardHomeScreen;
import View.NoticeBoardSettingsScreen;
import View.NoticeBoardWarningsScreen;

public class Main {
	public static void main(String[] args) {
		
		// open the system on the HomeScreen page
		/*NoticeBoardHomeScreen view = new NoticeBoardHomeScreen();
		view.init_HomeScreen();*/
		
		// the following are tests, to open the system on other pages
		/*NoticeBoardNotesScreen notes_view = new NoticeBoardNotesScreen();
		notes_view.init_SettingsScreen();*/
		
		/*NoticeBoardSettingsScreen settings_view = new NoticeBoardSettingsScreen();
		settings_view.init_SettingsScreen();*/
		
		/*NoticeBoardWarningsScreen warnings_view = new NoticeBoardWarningsScreen();
		warnings_view.init_WarningsScreen();*/
		
		MainView mv = new MainView();
		mv.init_NoticeboardFrame();
		mv.updateWindow("home");
	}
}
