package com.bookclub.web;

/*
Assignment 9.2 #6
Add a new Controller to the web package and name it AdminController

Saved inside web folder -- Mark Gallagher, 2026

Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/monthly-books")
public class AdminController {

    private BookOfTheMonthDao bookOfTheMonthDao;

    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showBookOfTheMonth(Model model) {
        List<BookOfTheMonth> booksOfTheMonth = bookOfTheMonthDao.list("999");
        model.addAttribute("booksOfTheMonth", booksOfTheMonth);
        return "monthly-books/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String bookOfTheMonthForm(Model model) {
        model.addAttribute("months", getMonths());
        model.addAttribute("bookOfTheMonth", new BookOfTheMonth());
        return "monthly-books/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addBookOfTheMonth(
            @Valid BookOfTheMonth bookOfTheMonth,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("months", getMonths());
            return "monthly-books/new";
        }

        bookOfTheMonthDao.add(bookOfTheMonth);

        return "redirect:/monthly-books";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeBookOfTheMonth(@PathVariable String id) {
        bookOfTheMonthDao.remove(id);
        return "redirect:/monthly-books";
    }

    private Map<Integer, String> getMonths() {
        Map<Integer, String> months = new LinkedHashMap<>();

        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");
        months.put(999, "All Months");

        return months;
    }
}