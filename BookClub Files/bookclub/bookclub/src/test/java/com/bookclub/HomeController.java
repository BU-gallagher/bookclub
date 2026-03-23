package com.bookclub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
Add a controller by external resources
Modified by Mark Gallagher, 2026
*/

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // refers to index.html
    }
}


