package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.services.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeysController {

    @Autowired
    private Keys keys;

    @GetMapping(value = "/keys.js", produces = "application/javascript")
    public String getKeys() {
        return String.format("""
                const API_KEY_ONE = "%s";
                const API_KEY_TWO = "%s";
                """, keys.getAPI_KEY_ONE(), keys.getAPI_KEY_TWO());
    }
}
