package com.SCM.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
// @RequestMapping("/api/v1/home")
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "depp");
        model.addAttribute("subject", "coding");
        System.out.println("home page handler");
        return "index";
    }
}
