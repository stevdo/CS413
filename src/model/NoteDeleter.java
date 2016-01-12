package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NoteDeleter {

	private int noteId;

	public NoteDeleter(int noteId) {
		this.noteId = noteId;
	}

	public void postNote() {
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://cs413noticeboard.co.uk/cs413pro_db",
					"cs413pro_db", "n0t1c3b04rd");
			System.out.println("NoteDeleter; connection made");
			Statement query = conn.createStatement();
			query.execute("DELETE FROM Notes WHERE N_id = " + noteId);
			System.out.println("NoteDeleter; Deleting note from database.");
			conn.close();
		} catch (SQLException se) {
			System.out
					.println("SQLException in NoteDeleter; Error connecting to database.");
		}
	}
}
