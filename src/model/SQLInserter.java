package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInserter {

	private int deviceId;
	private Note note;

	public SQLInserter(int deviceId, Note note) {
		this.deviceId = deviceId;
		this.note = note;
	}

	public void postNote() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://cs413noticeboard.co.uk/cs413pro_db",
					"cs413pro_db", "n0t1c3b04rd");
			Statement query = conn.createStatement();
			ResultSet result = query
					.executeQuery("INSERT INTO Notes (D_id, title, text, user) VALUES ("
							+ deviceId
							+ ","
							+ note.getTitle()
							+ ","
							+ note.getBody() + "," + note.getUser());
			System.out.println("SQLEnquirer; Posting note to database.");
		} catch (SQLException se) {
			System.err
					.println("SQLException in SQLEnquirer; Error connecting to database.");
			se.printStackTrace();
		}
	}

}
