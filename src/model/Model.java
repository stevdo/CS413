package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	private int deviceId;
	private NoteList noteList;
	private String title = "";
	private String text = "";
	private String user = "posted on device";

	public Model(int deviceId) {
		this.deviceId = deviceId;
		noteList = new NoteList();
		System.out.println("Model initialised.");
	}

	public void updateNotes() {
		ResultSet result = new NoteRetriever(deviceId).getNotes();
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

	public void postNote() {
		System.out.println("Model; note to be posted");
		if (title != "" || text != "") {
			new NotePoster(deviceId, new Note(title, text, user)).postNote();
			System.out.println("Model; note posted");
		} else {
			System.out.println("Model; text and title fields empty");
		}
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("Model; title set");
	}

	public void setText(String text) {
		this.text = text;
		System.out.println("Model; text set");
	}

	public NoteList getNotes() {
		return noteList;
	}
}
