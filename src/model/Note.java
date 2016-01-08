package model;

public class Note {

	private String title;
	private String body;
	private String user;

	public Note(String title, String body, String user) {
		this.title = title;
		this.body = body;
		this.user = user;
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
