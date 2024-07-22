package com.SCM.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
// @RequestMapping("/api/v1/home")
public class HomeController {

    @RequestMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("name", "depp");
        model.addAttribute("subject", "coding");
        System.out.println("home page handler");
        return "home";
    }

    //about route
    @GetMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLogin", false);
        System.out.println("about page loading");
        return "about";
    }

     //services page
     @GetMapping("/services")
     public String servicesPage(){
         System.out.println("service page loading");
         return "services";
     }

    //  conatct page
     @GetMapping("/contact")
     public String contactPage(){
         System.out.println("contact page loading");
         return "contact";
     }

     @GetMapping("/login")
     public String login() {
         return new String("login");
     }

     @GetMapping("/register")
     public String register() {
         return new String("register");
     }
     
     
     

}
