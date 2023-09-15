package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDicePage(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{number}")
    public String rollDiceWithRandomNumber(@PathVariable int number, Model model) {
        int randomNumber1 = (int) (Math.floor(Math.random() * 6) + 1);
        int randomNumber2 = (int) (Math.floor(Math.random() * 6) + 1);
        int randomNumber3 = (int) (Math.floor(Math.random() * 6) + 1);
        int randomNumber4 = (int) (Math.floor(Math.random() * 6) + 1);

        List<Integer> diceRolls = new ArrayList<>();
        diceRolls.add(randomNumber1);
        diceRolls.add(randomNumber2);
        diceRolls.add(randomNumber3);
        diceRolls.add(randomNumber4);

//        boolean match = number == randomNumber;
//        model.addAttribute("match", match);
        int matchCounter = 0;
        for(int i = 0; i < diceRolls.size(); i++) {
            if(diceRolls.get(i) == number) {
                matchCounter ++;
            }
        }

        model.addAttribute("matchCounter", matchCounter);
        model.addAttribute("guessedNumber", number);
        model.addAttribute("diceRolls", diceRolls);
//        model.addAttribute("randomNumber", randomNumber);

        return "roll-dice";
    }
}
