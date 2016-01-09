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
			System.out.println("Retrieving notes from database.");
			while (result.next()) {
				String messageTitle = result.getString("title");
				String messageBody = result.getString("text");
				String user = result.getString("user");
				// change text in Notes to body as makes more sense
				System.out.println(messageTitle);
				System.out.println(messageBody);
				System.out.println(user);
//				noteList.add(new Note(messageTitle, messageBody, user));
				// can also add N_id to Note class if needed
			}
//			return result;
		} catch (SQLException se) {
			System.err.println("SQLException in SQLEnquirer; Error connecting to database.");
			se.printStackTrace();
		}
		return null;
	}

}
