package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLEnquirer {

	private int deviceId;

	public SQLEnquirer(int deviceId) {
		this.deviceId = deviceId;
	}

	public ResultSet getRows() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://cs413noticeboard.co.uk/cs413pro_db",
					"cs413pro_db", "n0t1c3b04rd");
			Statement query = conn.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM Notes WHERE D_id = " + deviceId);
			System.out.println("SQLEnquirer; Retrieving notes from database.");
			return result;
		} catch (SQLException se) {
			System.err.println("SQLException in SQLEnquirer; Error connecting to database.");
			se.printStackTrace();
		}
		return null;
	}

}
