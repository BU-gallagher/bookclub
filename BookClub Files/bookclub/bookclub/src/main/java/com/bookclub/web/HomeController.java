
/*
Create three methods: showHome, showAboutUs, and showContactUs.
Each of these methods should use the Spring @RequestMapping decorator.
Created by CIS-530 instruction.
Modified by Mark Gallagher, 2026
*/

package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String showHome() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs() {
        return "about";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs() {
        return "contact";
    }
}

