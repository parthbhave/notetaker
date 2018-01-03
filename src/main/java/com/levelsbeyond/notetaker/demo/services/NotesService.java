package com.levelsbeyond.notetaker.demo.services;

import java.util.List;

import com.levelsbeyond.notetaker.demo.model.Note;

public interface NotesService {
	
	List<Note> getNotesContainingStringIgnoreCase(String queryStr);
	
	List<Note> getAllNotes();
	
	Note getNoteById(Long id);

	Note save(String note);

	int update(Long id, String body);
	
	int delete(Long id);
	
}
