package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import model.Model;
import model.Note;
import model.NoteList;
import model.NoticeboardColours;
import view.MainView;

public class TestCases {

	@Test
	public void modelClassTest() {
		int device_id = 0;
		
		// test the model constructor
		Model m = new Model(device_id);
		
		// assert the getIndex method
		assertEquals(m.getIndex(), 0);
		assertNotEquals(m.getIndex(), 1);
		
		// change the index and then retest getIndex
		m.setIndex(4);
		assertEquals(m.getIndex(), 4);
		assertNotEquals(m.getIndex(), 0);
		
		// set the note to be deleted and then test it
		m.setNoteToBeDeleted(4);
		assertEquals(m.getNoteToDelete(), 4);
		assertNotEquals(m.getNoteToDelete(), 6);
		
		// alter the note to be deleted, again, and then re test
		m.setNoteToBeDeleted(5);
		assertNotEquals(m.getNoteToDelete(), 10);
		assertEquals(m.getNoteToDelete(), 5);
		
		// test the setTitle and setText methods and test their valid methods
		m.setTitle("test title");
		m.setText("test text");
		assertEquals(m.titleValid(), true);
		assertEquals(m.textValid(), true);
		
		// test second branch of titleValid, need string longer than 100 characters
		String title = null;
		for(int i = 0; i < 150; i++){
			title = title + "a";
		}
		m.setTitle(title);
		assertEquals(m.titleValid(), false);
		
		// test second branch of textValid, need string longer than 1000 characters
		String text = null;
		for(int i = 0; i < 1010; i++){
			text = text + "a";
		}
		m.setText(text);
		assertEquals(m.textValid(), false);
		
		// test deleting a note
		m.setNoteToBeDeleted(0);
		m.deleteNote();
		
		// test clearing notes
		m.clearNotes();
		
		// test the postNote() method
		//m.postNote();
		
		// test the second set index method
		m.setIndex();
		
		// test update notes
		m.updateNotes();
	}
	
	@Test
	public void noteClassTest(){
		Note test_note = new Note(5, "Test Note", "Text of Test Note", "chros");
		
		//test the getNoteID() method
		assertEquals(test_note.getNoteID(), 5);
		assertNotEquals(test_note.getNoteID(), 10);
		
		// test the getTitle() method 
		assertEquals(test_note.getTitle(), "Test Note");
		assertNotEquals(test_note.getTitle(), "Title");
		
		// test the getText() method
		assertEquals(test_note.getBody(), "Text of Test Note");
		assertNotEquals(test_note.getBody(), "Body");
		
		// test the getUser() method
		assertEquals(test_note.getUser(), "chros");
		assertNotEquals(test_note.getUser(), "Username");
	}
	
	@Test
	public void NoteListClassTest(){
		// test the constructor 
		NoteList list = new NoteList();
		
		// create some notes to add to the list
		Note n1 = new Note(1, "Title1", "Body1", "User1");
		Note n2 = new Note(2, "Title2", "Body2", "User2");
		Note n3 = new Note(3, "Title3", "Body3", "User3");
		
		// test add note to the addList
		list.add(n1);
		list.add(n2);
		list.add(n3);
		
		// test getting a note
		Note n = list.get(0);
		assertEquals(n.getNoteID(), n1.getNoteID());
		
		// test clear the list and the list size
		assertEquals(list.size(), 3);
		list.clear();
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void NoticeBoardColourTestCase(){
		NoticeboardColours nbc = new NoticeboardColours();
		
		assertEquals(nbc.getNoticeboardColour(), new Color(64, 220, 79));		
		nbc.setNoticeboardColour("blue");
		assertEquals(nbc.getNoticeboardColour(), new Color(86, 200, 249));
	}
	
	@Test
	public void MainViewTextCase(){
		MainView mv = new MainView();
		
		// need to create a note list... note's page fails without one
		NoteList test_list = new NoteList();
		test_list.add(new Note(1, "Title", "Test", "User"));
		mv.setNotes(test_list);
		
		mv.updateWindow("notes");
		mv.updateWindow("settings");
		mv.updateWindow("warnings");
		mv.updateWindow("home");
		mv.updateWindow("write");
		
	}

}
