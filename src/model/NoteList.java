package model;

import java.util.ArrayList;

public class NoteList {

	private ArrayList<Note> noteList;

	public NoteList() {
		noteList = new ArrayList<Note>();
	}

	public void add(Note n) {
		noteList.add(n);
	}

	public Note get(int i) {
		return noteList.get(i);
	}
	
	public int size() {
		return noteList.size();
	}
}
