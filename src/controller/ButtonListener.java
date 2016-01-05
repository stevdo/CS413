package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import model.NoticeboardColours;
import view.MainView;
import view.NoticeBoardNotesScreen;
import view.NoticeBoardWriteMessage;
import view.NoticeBoardSettingsScreen;


public class ButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MainView mv = new MainView();
		NoticeboardColours nc = new NoticeboardColours();
		int buttonPress = Integer.parseInt(e.getActionCommand());
		switch(buttonPress){
		case 0:
			// need to change the functionality here
			System.out.println("Notes pressed");
			mv.updateWindow("notes");
			mv.update();
			//System.exit(0);
			break;
		case 1:
			// need to change the functionality here
			System.out.println("Settings pressed");
			mv.updateWindow("settings");
			mv.update();
			//System.exit(0);
			break;
		case 2:
			// need to change the functionality here
			System.out.println("Warnings pressed");
			mv.updateWindow("warnings");
			mv.update();
			//System.exit(0);
			break;
		case 3: 
			// need to change the functionality here
			System.out.println("Home pressed");
			mv.updateWindow("home");
			mv.update();
			//System.exit(0);			
			break;
		case 4:
			System.out.println("Write pressed");
			mv.updateWindow("Write");
			mv.update();
			break;
		case 5:
			System.out.println("Red pressed");
			nc.setNoticeboardColour("red");
			mv.updateWindow("settings");
			mv.update();
			break;
		case 6:
			System.out.println("Blue pressed");
			nc.setNoticeboardColour("blue");
			mv.updateWindow("settings");
			mv.update();
			break;
		case 7:
			System.out.println("Orange pressed");
			nc.setNoticeboardColour("orange");
			mv.updateWindow("settings");
			mv.update();
			break;
		case 8:
		    	try {
					Runtime.getRuntime().exec("shutdown -h now");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    System.exit(0);
			break;
		case 9:
			try {
				Runtime.getRuntime().exec("reboot");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    System.exit(0);
			break;
		case 10:
			Socket socket = new Socket();
        	//Tests connection by checking if www.cs413noticeboard.co.uk can be accessed with port 80
        	InetSocketAddress url = new InetSocketAddress("www.cs413noticeboard.co.uk", 80);
        	try {
        		//set timeout to 1000ms
        		socket.connect(url, 1000);
        		//if connection is successful it will print "You are connected"
        		NoticeBoardSettingsScreen.connectedLabel2.setVisible(false);
        		NoticeBoardSettingsScreen.connectedLabel1.setVisible(true);
        	} catch(Exception ex) {
        		//if connection is not successful it will print "You are not connected"
        		NoticeBoardSettingsScreen.connectedLabel1.setVisible(false);
        		NoticeBoardSettingsScreen.connectedLabel2.setVisible(true);
        	} finally {
        		//Close the socket
        		try {socket.close();}
        		catch (Exception ex) {}
        	}
			break;
		}		
	}	
}
