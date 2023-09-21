package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Post;
import edu.codeup.codeupspringblog.models.User;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import edu.codeup.codeupspringblog.repositories.PostRepository;
import edu.codeup.codeupspringblog.repositories.UserRepository;
import edu.codeup.codeupspringblog.services.EmailSvc;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    // Constructor Dependency Injection
    private PostRepository postsDao;
    private UserRepository userDao;
    private EmailSvc emailSvc;

    public PostController(PostRepository postsDao, UserRepository userDao, EmailSvc emailSvc) {
        this.postsDao = postsDao;
        this.userDao = userDao;
        this.emailSvc = emailSvc;
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

    @GetMapping("/posts/{id}/edit")
    public String editIndividualPost(@PathVariable long id, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (postsDao.existsById(id)) {
            Post postToEdit = postsDao.findById(id).get();
            if(postToEdit.getUser().getId() != loggedInUser.getId()) {
                return "redirect:/posts";
            }
        }

        if(postsDao.existsById(id)) {
            Post postToEdit = postsDao.findById(id).get();
            model.addAttribute("post", postToEdit);
            return "posts/edit";
        }
        return "redirect:/posts";
    }

    @PostMapping("posts/{id}/edit")
    public String updateEditedPost(@ModelAttribute Post post, @PathVariable long id) {

        Post postToEdit = postsDao.findById(id).get();
        postToEdit.setTitle(post.getTitle());
        postToEdit.setBody(post.getBody());
        postsDao.save(postToEdit);
        return "redirect:/posts/" + postToEdit.getId();
    }



    @GetMapping("/posts/create")
    public String showCreatePostView(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User currentUser = userDao.findById(loggedInUser.getId()).get();

        Post newPost = new Post(
                post.getTitle(),
                post.getBody(),
                currentUser
        );
        postsDao.save(newPost);
        emailSvc.prepareAndSend(newPost, "This is the subject", "This is the body...yay");
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deleteIndividualPost(@ModelAttribute Post post, @PathVariable long id) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(postsDao.existsById(id)) {
            Post postToDelete = postsDao.findById(id).get();
            if(postToDelete.getUser().getId() == loggedInUser.getId()) {
                postsDao.delete(postToDelete);
                return "redirect:/posts";
            }
        }
        return "redirect:/posts";

    }






}
