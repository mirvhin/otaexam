package com.ota.exam.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ota.exam.exceptions.NotFoundException;
import com.ota.exam.models.Note;

@RestController
public class NotesController {
	ArrayList<Note> notes = new ArrayList<Note>();
	
	@GetMapping("/notes")
	public List<Note> notes() {
		return notes;
	}
	
	@PostMapping("/notes")
	public Note create(@RequestBody Note note) {
		note.setId(UUID.randomUUID().toString());
		notes.add(note);
		return note;
	}
	
	@GetMapping("/notes/{noteID}")
    public Note get(@PathVariable String noteID) {
		return notes.stream()
		  .filter(item -> noteID.equals(item.getId()))
		  .findAny()
		  .orElseThrow(NotFoundException::new);
	}
	
	@PutMapping("/notes/{noteID}")
    public Note update(@PathVariable String noteID, @RequestBody Note note ) {
		return notes.stream()
		  .filter(item -> noteID.equals(item.getId()))
		  .findFirst()
		  .map(noteItem -> { noteItem.setBody(
				  	note.getBody()); 
		  			noteItem.setTitle(note.getTitle());
		  			return noteItem;
		  		})
		  .orElseThrow(NotFoundException::new);
	}
	
	@DeleteMapping("/notes/{noteID}")
    public String update(@PathVariable String noteID) {
		return notes.stream()
		  .filter(item -> noteID.equals(item.getId()))
		  .findFirst()
		  .map(noteItem -> {
			  notes.remove(noteItem);
			  return "Successfully deleted " + noteItem.getId();
		  	})
		  .orElseThrow(NotFoundException::new);
	}
}
