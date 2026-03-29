package com.bookclub.service.impl;

/*
Additional Java requirements
a. Add a new file to the service package and name it GenericDao.  Make this a generic
    interface with values E and K.
b. Give the interface two methods: List<E> list() and E find(Key key)

Saved inside service/impl folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Suppleemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

public class MemBookDao implements BookDao {

    //private varibale created
    private final List<Book> books = new ArrayList<>();

    //list of five new Book objects
    public MemBookDao() {
        books.add(new Book("1", "Spring in Action", "Spring Framework Guide", 300, Arrays.asList("Craig Walls")));
        books.add(new Book("2", "Java Basics", "Intro to Java", 250, Arrays.asList("John Doe")));
        books.add(new Book("3", "Clean Code", "Best Practices", 400, Arrays.asList("Robert Martin")));
        books.add(new Book("4", "Effective Java", "Advanced Java Tips", 350, Arrays.asList("Joshua Bloch")));
        books.add(new Book("5", "Design Patterns", "Reusable Solutions", 450, Arrays.asList("GoF")));
    }

    //code provied by lab
    @Override
    public List<Book> list() {
        return books;
    }

    //code provided by lab
    @Override
    public Book find(String key) {
        for (Book book : books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return null;
    }
}




