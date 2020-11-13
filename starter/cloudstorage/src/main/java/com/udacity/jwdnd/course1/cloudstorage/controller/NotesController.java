package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.HomeForm;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller()
@RequestMapping("/notes")
public class NotesController {
    private NoteService noteService;
    private UserService userService;

    public NotesController(NoteService noteService, UserService userService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @GetMapping()
    public String getNotes(Authentication authentication) {
        return "notes";
    }

    @PostMapping()
    public String postNotes (Note note, Authentication authentication, Model model){
       // note.setNoteTitle(model.getAttribute("notetitle").toString());
      //  note.setNoteDescription(model.getAttribute("notedescription").toString());
      //  note.setUserID(userService.getUserId(authentication.getName()));
       // this.noteService.addNote(note);
        System.out.println("Posted Note");

        return "/home";
    }
}
