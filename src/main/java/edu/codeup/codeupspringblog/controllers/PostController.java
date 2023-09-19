package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    // Constructor Dependency Injection
    private PostRepository postsDao;
    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String indexPage(Model model) {

        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        if(postsDao.existsById(id)) {
            Post foundPost = postsDao.findById(id).get();
            model.addAttribute("post", foundPost);
            return "posts/show";
        }
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreatePostView() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam("title") String title,
            @RequestParam("body") String body
    ) {
        Post newPost = new Post(
                title,
                body
        );
        postsDao.save(newPost);

        return "redirect:/posts";
    }

//    @PostMapping("/create")
//    @ResponseBody
//    public String greetUser(@RequestParam(name = "username") String username, @RequestParam(name = "email") String email) {
//        System.out.println(username + " " + email);
//        return String.format("Hello %s %s", username, email);
//    }


}
