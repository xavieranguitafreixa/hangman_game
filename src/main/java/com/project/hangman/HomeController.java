package com.project.hangman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home Controller
 */
@Controller
public class HomeController
{
	
	@Autowired
	private GameRepository repository;
	
    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String table(Model model)
    {
        model.addAttribute("games", repository.findAll());
        return "admin";
    }
}