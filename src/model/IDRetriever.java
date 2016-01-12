package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IDRetriever {

	private int deviceId;
	private int devicePin;

	public IDRetriever(int devicePin) {
		this.devicePin = devicePin;
		this.deviceId = -1;
	}

	public int retrieveID() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://cs413noticeboard.co.uk/cs413pro_db",
					"cs413pro_db", "n0t1c3b04rd");
			System.out.println("IDRetriever; connection made");
			Statement query = conn.createStatement();
			ResultSet result = query
					.executeQuery("SELECT * FROM Devices WHERE pin = "
							+ devicePin);
			System.out
					.println("IDRetriever; Retrieving devices from database.");
			if (result.next()) {
				deviceId = result.getInt("D_id");
			}
			System.out.println("IDRetriever; D_id retrieved: " + deviceId);
			return deviceId;
		} catch (SQLException se) {
			System.err
					.println("SQLException in IDRetriever; Error connecting to database.");
			se.printStackTrace();
		}
		return -1;
	}

}
