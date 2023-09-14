package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/math")
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNumbs(@PathVariable int num1, @PathVariable int num2) {
        return String.format("%s plus %s = %s",num1, num2, num1 + num2);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtractNumbs(@PathVariable int num1, @PathVariable int num2) {
        return String.format("%s minus %s = %s", num2, num1, num2 - num1);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyNumbs(@PathVariable int num1, @PathVariable int num2) {
        return String.format("%s times %s = %s", num1, num2, num1 * num2);
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divideNumbs(@PathVariable int num1, @PathVariable int num2) {
        return String.format("%s divided by %s = %s", num1, num2, num1 / num2);
    }

}
