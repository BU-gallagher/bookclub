package com.bookclub.model;

/*
Assignment 9.2 #2
Add a new class to the model package and name it BookOfTheMonth.
Additional Requirements
a. Set class properties for String Id, Integer month, and String isbn.  Include
getter/setter methods and @Override the toString() method following the output
format you used in the WishlistItem class.  Set the id property to a decorator of @Id
and set the isbn property to @NotEmpty with a custom required field error
message.

Saved inside model folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Initial syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotEmpty;

public class BookOfTheMonth {

    @Id
    private String id;

    private Integer month;

    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    public BookOfTheMonth() {
    }

    public BookOfTheMonth(Integer month, String isbn) {
        this.month = month;
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookOfTheMonth{id=" + id +
                ", month=" + month +
                ", isbn=" + isbn +
                "}";
    }
}