package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    @ResponseBody
    public String indexPage() {
        return "posts index page";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String postId(@PathVariable long id) {
        return String.format("view an individual post from id %s", id);
    }

    @GetMapping("/create")
    @ResponseBody
    public String createForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String postForm() {
        return "create a new post";
    }

}