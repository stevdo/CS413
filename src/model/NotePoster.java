package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NotePoster {

	private int deviceId;
	private Note note;

	public NotePoster(int deviceId, Note note) {
		this.deviceId = deviceId;
		this.note = note;
	}

	public void postNote() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://cs413noticeboard.co.uk/cs413pro_db",
					"cs413pro_db", "n0t1c3b04rd");
			System.out.println("NotePoster; connection made");
			Statement query = conn.createStatement();
			query.execute("INSERT INTO Notes (D_id, title, text, user) VALUES ("
					+ deviceId
					+ ","
					+ "'"
					+ note.getTitle()
					+ "'"
					+ ","
					+ "'"
					+ note.getBody()
					+ "'"
					+ ","
					+ "'"
					+ note.getUser()
					+ "'"
					+ ")");
			System.out.println("NotePoster; Posting note to database.");
			conn.close();
		} catch (SQLException se) {
			System.err
					.println("SQLException in NotePoster; Error connecting to database.");
			se.printStackTrace();
		}
	}
}
