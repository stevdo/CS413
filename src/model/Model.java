package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	private int deviceId;
	private NoteList noteList;

	public Model(int deviceId) {
		this.deviceId = deviceId;
		noteList = new NoteList();
		System.out.println("Model initialised.");
	}

	public void updateNotes() {
		ResultSet result = new SQLEnquirer(deviceId).getRows();
		String user;
		String messageTitle;
		String messageBody;
		try {
			while (result.next()) {
				messageTitle = result.getString("title");
				messageBody = result.getString("text");
				user = result.getString("user");
				noteList.add(new Note(messageTitle, messageBody, user));
			}
			System.out.println("Model; Notes retrieved");
		} catch (SQLException e) {
			System.err
					.println("SQLException in Model; Error reading from SQL result");
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.err
					.println("NullPointerException in Model; Error reading from SQL result");
			npe.printStackTrace();
		}
	}

	public NoteList getNotes() {
		return noteList;
	}
}
