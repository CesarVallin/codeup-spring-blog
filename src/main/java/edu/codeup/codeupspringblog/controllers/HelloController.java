package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/world")
    @ResponseBody
    public String helloWorld() {
        System.out.println("Inside of HelloController helloWorld method");
        return "Hello world!";
    }

    @GetMapping("/{name}")
    @ResponseBody
    public String helloName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        /** The return will be the view this will be rendered to */
        return "hello";
    }

    // Serves the view
    @GetMapping("/join")
    public String showJoinForm(Model model) {
        List<Item> shoppingCart = new ArrayList<>();
        shoppingCart.add(new Item("screwdriver"));
        shoppingCart.add(new Item("hammer"));
        shoppingCart.add(new Item("drill"));
        model.addAttribute("shoppingCart", shoppingCart);
        return "join";
    }

    // Handle submission of information
    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }
}
