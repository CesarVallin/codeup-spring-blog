package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String landingPage() {
        return "/home";
    }

    // thyme leaf knows its supposed to render this method cause of the return "home" it has to be named identically to work
    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

}
