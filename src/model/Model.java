package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	private int deviceId;
	private NoteList noteList;

	public Model(int deviceId) {
		this.deviceId = deviceId;
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
				// change text in Notes to body as makes more sense
				noteList.add(new Note(messageTitle, messageBody, user));
				// can also add N_id to Note class if needed
			}
		} catch (SQLException e) {
			System.err.println("SQLException in Model");
			e.printStackTrace();
			
		}
		 catch (NullPointerException npe) {
			 System.out.println("Note retrieval finished");
		}
	}

	public NoteList getNotes() {
		return noteList;
	}
}
