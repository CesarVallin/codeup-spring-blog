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
@RequestMapping("/posts")
public class PostController {
    // Constructor Dependency Injection
    private PostRepository postsDao;
    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("")
    public String indexPage(Model model) {


        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post post1 = new Post("this is the title", "this is the description kdsj;kladjkldasjk;llkd lkajfkldasjlkfdj lakdjflkasdjli;fj alaskdjfklasdjf lakdjfkadjfkldjf ");
        model.addAttribute("post1", post1);
        return "posts/show";
    }

    @GetMapping("/create")
    public String showCreatePostView() {
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
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
