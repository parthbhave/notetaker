package com.levelsbeyond.notetaker.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.levelsbeyond.notetaker.demo.model.Note;
import com.levelsbeyond.notetaker.demo.services.NotesService;

@RestController
@Component

//Ideally, I would let this class implement an interface

public class NotesController {
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    NotesService notesService;
    
    @RequestMapping(value="/api/notes", method=RequestMethod.GET)
    public List<Note> getNotes(@RequestParam(name="query", defaultValue="") String queryStr) {
        List<Note> notes = new ArrayList(); 
        if(StringUtils.isEmpty(queryStr)) {
        	notes = notesService.getAllNotes();
        } else {
        	notes = notesService.getNotesContainingStringIgnoreCase(queryStr);
        }
        return notes;
    }
    
    @RequestMapping(value="/api/notes/{id}", method=RequestMethod.GET)
    public List<Note> getNoteById(@PathVariable Long id) {
        List<Note> allNotes = notesService.getAllNotes();
        return allNotes;
    }

    @RequestMapping(value="/api/notes", method=RequestMethod.POST)
    public Note saveNote(@RequestBody String note) {
        ObjectMapper mapper = new ObjectMapper();
        Note savedNote = null;
        JsonNode noteBody;
		try {
			noteBody = mapper.readTree(note);
			savedNote = notesService.save(noteBody.get("body").asText());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return savedNote;
    }
    
}