package com.bookclub.web;

/*
Updated based on the requirements of Assignment 7.2:
Saved inside web folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Modified by Mark Gallagher, 2026
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

@Controller
public class HomeController {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(Model model) {
        List<Book> books = bookDao.list();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String showAboutUs() {
        return "about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String showContactUs() {
        return "contact";
    }

    @RequestMapping(value = "/monthly-books/{isbn}", method = RequestMethod.GET)
    public String getMonthlyBook(@PathVariable String isbn, Model model) {
        Book book = bookDao.find(isbn);
        model.addAttribute("book", book);
        return "monthly-books/view";
    }
}
