package com.bookclub.security;

/*
Assignment 5.2 #6
Create a SecurityContoller.java file.

Saved inside security folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/logout-success")
    public String logout() {
        return "login?logout";
    }
}


