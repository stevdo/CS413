package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import model.Model;
import model.NoticeboardColours;
import model.Warnings;
import view.MainView;
import view.NoticeBoardSettingsScreen;
import view.NoticeBoardWarningsScreen;

public class ButtonListener implements ActionListener {

	private MainView mv;
	private Model m;

	public ButtonListener(MainView mv, Model m) {
		this.mv = mv;
		this.m = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		NoticeboardColours nc = new NoticeboardColours();
		int buttonPress = Integer.parseInt(e.getActionCommand());
		switch (buttonPress) {
		case 0:
			// need to change the functionality here
			System.out.println("Notes pressed");
			mv.updateWindow("notes");
			mv.update();
			// System.exit(0);
			break;
		case 1:
			// need to change the functionality here
			System.out.println("Settings pressed");
			mv.updateWindow("settings");
			mv.update();
			// System.exit(0);
			break;
		case 2:
			// need to change the functionality here
			System.out.println("Warnings pressed");
			mv.updateWindow("warnings");
			mv.update();
			// System.exit(0);
			break;
		case 3:
			// need to change the functionality here
			System.out.println("Home pressed");
			mv.updateWindow("home");
			mv.update();
			// System.exit(0);
			break;
		case 4:
			System.out.println("Write pressed");
			mv.updateWindow("Write");
			mv.update();
			break;
		case 5:
			String selectedColour = new String("");
			selectedColour = ComboListener.editString();
			System.out.println("Button listener colour is: " + selectedColour);
			if (selectedColour == "Green") {
				nc.setNoticeboardColour("green");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Red") {
				nc.setNoticeboardColour("red");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Blue") {
				nc.setNoticeboardColour("blue");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Orange") {
				nc.setNoticeboardColour("orange");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Purple") {
				nc.setNoticeboardColour("purple");
				mv.updateWindow("settings");
				mv.update();
			} else if (selectedColour == "Pink") {
				nc.setNoticeboardColour("pink");
				mv.updateWindow("settings");
				mv.update();
			}
			break;
		case 6:
			try {
				Runtime.getRuntime().exec("systemctl poweroff");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
			break;
		case 7:
			try {
				Runtime.getRuntime().exec("systemctl reboot");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
			break;
		case 8:
			Socket socket = new Socket();
			// Tests connection by checking if www.cs413noticeboard.co.uk can be
			// accessed with port 80
			InetSocketAddress url = new InetSocketAddress(
					"www.cs413noticeboard.co.uk", 80);
			try {
				// set timeout to 1000ms
				socket.connect(url, 1000);
				// if connection is successful it will print "You are connected"
				NoticeBoardSettingsScreen.connectedLabel2.setVisible(false);
				NoticeBoardSettingsScreen.connectedLabel1.setVisible(true);
			} catch (Exception ex) {
				// if connection is not successful it will print
				// "You are not connected"
				NoticeBoardSettingsScreen.connectedLabel1.setVisible(false);
				NoticeBoardSettingsScreen.connectedLabel2.setVisible(true);
			} finally {
				// Close the socket
				try {
					socket.close();
				} catch (Exception ex) {
				}
			}
			break;
		case 9:
			System.out.println("windows on Button clicked");
			// put code here to set the warning in the model
			Warnings.toogleWindowWarningOn();
			NoticeBoardWarningsScreen.windows_on.setBackground(new Color(51,
					255, 51));
			NoticeBoardWarningsScreen.windows_off.setBackground(new Color(204,
					0, 0));
			break;
		case 10:
			System.out.println("windows off button clicked");
			// put code here to unset the warning in the model
			Warnings.toogleWindowWarningOff();
			NoticeBoardWarningsScreen.windows_off.setBackground(new Color(51,
					255, 51));
			NoticeBoardWarningsScreen.windows_on.setBackground(new Color(204,
					0, 0));
			break;
		case 11:
			System.out.println("washing on button clicked");
			// put code her to set the warning in the model
			Warnings.toogleWashingWarningOn();
			NoticeBoardWarningsScreen.washing_on.setBackground(new Color(51,
					255, 51));
			NoticeBoardWarningsScreen.washing_off.setBackground(new Color(204,
					0, 0));
			break;
		case 12:
			System.out.println("washing off button clicked");
			// put code here to unset the warning in the model
			Warnings.toogleWashingWarningOff();
			NoticeBoardWarningsScreen.washing_off.setBackground(new Color(51,
					255, 51));
			NoticeBoardWarningsScreen.washing_on.setBackground(new Color(204,
					0, 0));
			break;
		case 13:
			System.out.println("Add note button pressed");
			m.postNote();
		}
	}
}
