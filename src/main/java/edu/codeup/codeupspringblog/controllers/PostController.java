package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    public String indexPage(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("Amazing Title", "Cool description, kadjflkdajfds lkadjklafdjskjfd kldjfkadsjfkldj");
        Post post2 = new Post("Great Title", "Awesome description, kldajkdlsjfad kadjfkl;adsjf adkladjkladsjf adldkjalkdsjfdksljf");

        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id, Model model) {
        Post post1 = new Post("this is the title", "this is the description kdsj;kladjkldasjk;llkd lkajfkldasjlkfdj lakdjflkasdjli;fj alaskdjfklasdjf lakdjfkadjfkldjf ");
        model.addAttribute("post1", post1);
        return "posts/show";
    }

    @GetMapping("/create")
    @ResponseBody
    public String showCreatePostView() {
        return "view the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }

//    @PostMapping("/create")
//    @ResponseBody
//    public String greetUser(@RequestParam(name = "username") String username, @RequestParam(name = "email") String email) {
//        System.out.println(username + " " + email);
//        return String.format("Hello %s %s", username, email);
//    }


}
