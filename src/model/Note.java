package model;

public class Note {

	private int noteId;
	private String title;
	private String body;
	private String user;

	public Note(int noteId, String title, String body, String user) {
		this.noteId = noteId;
		this.title = title;
		this.body = body;
		this.user = user;
	}

	public int getNoteID() {
		return noteId;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public String getUser() {
		return user;
	}
}
