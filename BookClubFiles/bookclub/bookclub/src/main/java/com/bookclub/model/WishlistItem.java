package com.bookclub.model;

/*
Assignment 4.2 #5
Update the WishlistItem class by including a new private property for id of type String
with a decorator of @Id.  The decorator is imported from
org.springframework.data.annotation.Id.

Additional Requirements
a. Add getter method for the new id property.
b. Update the overridden toString() method to include the id property.  Follow the
    format you already have for the output string.

Saved inside model folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Initial syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class WishlistItem {

    @Id
    private String id;

    @NotNull(message = "ISBN is a required field.")
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    @NotNull(message = "Title is a required field.")
    @NotEmpty(message = "Title is a required field.")
    private String title;

    // Default constructor
    public WishlistItem() {}

    // Parameterized constructor
    public WishlistItem(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getId() {
        return id;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "WishlistItem{id=" + id + ", isbn=" + isbn + ", title=" + title + "}";
    }
}

