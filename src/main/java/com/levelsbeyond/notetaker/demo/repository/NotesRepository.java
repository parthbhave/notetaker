package com.levelsbeyond.notetaker.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.levelsbeyond.notetaker.demo.model.Note;

public interface NotesRepository extends CrudRepository<Note, Long> {

    Note findById(Long id);
    
    List<Note> findByBodyContainingIgnoreCase(String queryStr);
    
    List<Note> findAll();
}