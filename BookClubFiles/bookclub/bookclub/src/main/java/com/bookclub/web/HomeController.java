package com.bookclub.web;

/*
Assignment 9.2 #7
Update the HomeController to call the BookOfTheMonthDao.list() method.

Saved inside web folder -- Mark Gallagher, 2026

Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookDao;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;

@Controller
public class HomeController {

    private BookDao bookDao;

    private BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(Model model) {
        Integer currentMonth = LocalDate.now().getMonthValue();

        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(currentMonth.toString());

        StringBuilder isbnString = new StringBuilder();

        for (BookOfTheMonth bookOfTheMonth : monthlyBooks) {
            if (isbnString.length() > 0) {
                isbnString.append(",");
            }

            isbnString.append("ISBN:").append(bookOfTheMonth.getIsbn());
        }

        List<Book> books = bookDao.list(isbnString.toString());

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