package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDicePage(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String rollDiceWithRandomNumber(@PathVariable int number, Model model) {
        int randomNumber = (int) (Math.floor(Math.random() * 6) + 1);
        model.addAttribute("guessedNumber", number);
        model.addAttribute("randomNumber", randomNumber);
        return "roll-dice";
    }
}
