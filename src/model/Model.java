package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	private int deviceId;
	private NoteList noteList;
	private String title = "";
	private String text = "";
	private String user = "posted on device";
	private int index = 0;
	private int deleteID = -1;

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
		int noteId;
		try {
			while (result.next()) {
				noteId = result.getInt("N_id");
				messageTitle = result.getString("title");
				messageBody = result.getString("text");
				user = result.getString("user");
				noteList.add(new Note(noteId, messageTitle, messageBody, user));
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
		System.out.println("Note List size in model: " + noteList.size());
	}

	public void postNote() {
		System.out.println("Model; note to be posted");
		new NotePoster(deviceId, new Note(-1, title, text, user)).postNote();
		System.out.println("Model; note posted");
	}
	
	// hopefully this works
	public void deleteNote(){
		System.out.println("doing this");
		NoteDeleter nd = new NoteDeleter(deleteID);
		nd.postNote();
	}

	public void setTitle(String title) {
		this.title = title;
		System.out.println("Model; title set");
	}
	
	public void setNoteToBeDeleted(int noteID){
		deleteID = noteID;
	}

	public void setText(String text) {
		this.text = text;
		System.out.println("Model; text set");
	}

	public void setIndex() {
		index = noteList.size() - 1;
	}

	public void setIndex(int new_index) {
		index = new_index;
	}

	public void clearNotes() {
		noteList.clear();
	}

	public int getIndex() {
		System.out.println("Model - the index is: " + index);
		return index;
	}
	
	public int getNoteToDelete(){
		return deleteID;
	}

	public Boolean titleValid() {
		if (title.length() > 100) {
			return false;
		}
		return true;
	}

	public Boolean textValid() {
		if (text.length() > 1000) {
			return false;
		}
		return true;
	}

	public NoteList getNotes() {
		return noteList;
	}
}
