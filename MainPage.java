package com.example.wordlepal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainPage {
    
    // need to add a method to clear the message when clicking the Clear button
    //private Message msgObj = new Message();
    private String inputWord;

    @GetMapping("/")
    public String mainPage(Model model) {

        // this only runs once, on the initial GET request
        model.addAttribute("msg", new Word());
        //System.out.println(inputWord);
        return "mainpage";
    }

    @PostMapping("/")
    public String submit(@ModelAttribute Word word, Model model) {
        model.addAttribute("msg", word);
        //inputWord = message.getMessage();
        //System.out.println(message.getMessage());
        return "mainpage";
    }

    @GetMapping("/reset")
    public String reset(Model model) {
        return "redirect:/";
    }
}

