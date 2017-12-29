package com.sec.cybersecurityproject.controller;

import com.sec.cybersecurityproject.model.Note;
import com.sec.cybersecurityproject.repository.AccountRepository;
import com.sec.cybersecurityproject.repository.NoteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepo;

    @Autowired
    private AccountRepository accountRepo;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<Note> getNotesFromUser(@PathVariable Long userId) {
        List<Note> list = noteRepo.findByAccountId(userId);
                return list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable Long id) {
        noteRepo.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Note addNote(@RequestBody Note note) {
        return noteRepo.save(note);
    }

}
