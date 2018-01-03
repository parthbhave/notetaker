package com.levelsbeyond.notetaker.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levelsbeyond.notetaker.demo.model.Note;
import com.levelsbeyond.notetaker.demo.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService {

	@Autowired
	NotesRepository notesRepo;
	
	@Override
	public List<Note> getNotesContainingStringIgnoreCase(String queryStr) {
		return notesRepo.findByBodyContainingIgnoreCase(queryStr);
	}
	
	@Override
	public List<Note> getAllNotes() {
		List<Note> allNotes = notesRepo.findAll();
		return allNotes;  
	}
	
	@Override
	public Note getNoteById(Long id) {
		return notesRepo.findById(id);
	}

	@Override
	public Note save(String note) {
		return notesRepo.save(new Note(note));
	}

}
