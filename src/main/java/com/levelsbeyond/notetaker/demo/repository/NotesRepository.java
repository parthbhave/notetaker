package com.levelsbeyond.notetaker.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.levelsbeyond.notetaker.demo.model.Note;

public interface NotesRepository extends CrudRepository<Note, Long> {

    Note findById(Long id);
    
    List<Note> findByBodyContainingIgnoreCase(String queryStr);
    
    List<Note> findAll();
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Note n SET n.body = :noteBody WHERE n.id = :noteId")
    int updateNote(@Param("noteId") Long noteId, @Param("noteBody") String noteBody);
    
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Note n WHERE n.id = :noteId")
    int deleteNote(@Param("noteId") Long noteId);
}