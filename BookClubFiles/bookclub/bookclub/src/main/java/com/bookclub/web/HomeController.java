package com.bookclub.web;

/*
Saved inside web folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Modified by Mark Gallagher, 2026
*/

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.Book;
import com.bookclub.service.impl.MemBookDao;

/*
Create three methods: showHome, showAboutUs, and showContactUs.
Each of these methods should use the Spring @RequestMapping decorator.
*/

@Controller
@RequestMapping("/")
public class HomeController {

    //code provided by the lab
/*
Update the HomeController’s showHome() method to create a new instance of the 
MemBookDao class, create a local variable named books of type List<Book>, and map 
the return value from the booksDao.list() method call.  Assign the books variable to the 
model attribute with a key of “books.” 
 */
    
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        MemBookDao bookDao = new MemBookDao();
        List<Book> books = bookDao.list();

        //for (Book book : books) {
            //System.out.println(book.toString());
            //System.out.println("showHome() was called");
        System.out.println("Books size: " + books.size());
        
    //}
        model.addAttribute("books", books);
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

//code provided by the lab
/*
Add a new method to the HomeController named getMonthlyBook.  Set the path to 
/{id} and set the RequestMethod to a GET request.  For the methods signature, add a 
parameter for @PathVariable of type String and a String Model.  In the body of the 
method, create a new instance of the MemBookDao and call the find() method.  Assign 
the result to the model attribute with a key of book.
 */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable String id, Model model) {
        String isbn = id;
        System.out.println(id);

        MemBookDao bookDao = new MemBookDao();
        Book book = bookDao.find(isbn);

        System.out.println(book.toString());

        model.addAttribute("book", book);
        return "monthly-books/view";
    }


}







