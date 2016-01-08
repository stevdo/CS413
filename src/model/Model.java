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
		System.out.println("Notes retrieved from database.");
		String messageTitle;
		String messageBody;
		try {
			while (result.next()) {
				messageTitle = result.getString("title");
				messageBody = result.getString("text");
				// change text in Notes to body as makes more sense
				noteList.add(new Note(messageTitle, messageBody));
				// can also add N_id to Note class if needed
			}
		} catch (SQLException e) {
			System.err.println("SQLException in Model");
			e.printStackTrace();
			
		}
//		} catch (NullPointerException npe) {
//			System.err.println("NullPointerException in Model");
//			npe.printStackTrace();
//		}
	}

	public NoteList getNotes() {
		return noteList;
	}
}
