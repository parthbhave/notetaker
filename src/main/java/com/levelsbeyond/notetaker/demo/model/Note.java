package com.levelsbeyond.notetaker.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Note {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String body;
	
	public Note() {
		
	}
	
	public Note(String note) {
        this.body = note;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return body;
	}

	public void setNote(String note) {
		this.body = note;
	}
	
}
