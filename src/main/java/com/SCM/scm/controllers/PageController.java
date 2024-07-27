package com.SCM.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SCM.scm.forms.UserForm;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
// @RequestMapping("/api/v1/home")
public class PageController {

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
     public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
         return new String("register");
     }

     @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {
        System.out.println("Processing registration");
        // fetch form data
        // UserForm
        System.out.println(userForm);

        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }

    
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Fdurgesh_sir.35c6cb78.webp&w=1920&q=75");

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        // message = "Registration Successful"

        // add the message:

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message", message);

        // redirectto login page
        return "redirect:/register";
    }
     
     
     

}
