package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NoteRetriever {

	private int deviceId;

	public NoteRetriever(int deviceId) {
		this.deviceId = deviceId;
	}

	public ResultSet getNotes() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://cs413noticeboard.co.uk/cs413pro_db",
					"cs413pro_db", "n0t1c3b04rd");
			System.out.println("NoteRetriever; connection made");
			Statement query = conn.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM Notes WHERE D_id = " + deviceId);
			System.out.println("NoteRetriever; Retrieving notes from database.");
			return result;
		} catch (SQLException se) {
			System.err.println("SQLException in NoteRetriever; Error connecting to database.");
			se.printStackTrace();
		}
		return null;
	}

}
