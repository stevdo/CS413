package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeviceRegistrar {

	private int devicePin = -1;

	public DeviceRegistrar(int devicePin) {
		this.devicePin = devicePin;
	}

	public void registerDevice() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://cs413noticeboard.co.uk/cs413pro_db",
					"cs413pro_db", "n0t1c3b04rd");
			System.out.println("NotePoster; connection made");
			Statement query = conn.createStatement();
			query.execute("INSERT INTO Devices (pin) VALUES (" + devicePin
					+ ")");
			System.out.println("DeviceRegistrar; adding device to database.");
			conn.close();
		} catch (SQLException se) {
			System.out
					.println("SQLException in DeviceRegistrar; Error connecting to database.");
		}
	}
}
