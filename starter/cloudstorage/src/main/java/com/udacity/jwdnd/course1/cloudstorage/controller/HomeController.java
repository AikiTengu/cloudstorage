package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller

public class HomeController {

    private NoteService noteService;
    private UserService userService;

    public HomeController(UserService userService, NoteService noteService) {
        this.userService = userService;
        this.noteService = noteService;
    }

    @GetMapping(value = "/home")
    public ModelAndView getHomePage(Authentication authentication){
        ModelAndView mav = new ModelAndView("home");
        int userId = userService.getUserId(authentication.getName());
        List<Note> notelist = noteService.getNotes(userId);

        mav.addObject("notelist", notelist);


        return mav;
    }
}