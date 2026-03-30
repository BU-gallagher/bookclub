package com.bookclub.model;

/*
Assignment 3.2 #3
Add a new class to the model package and name it WishlistItem

Saved inside model folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Initial syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class WishlistItem {

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
        return "WishlistItem{isbn=" + isbn + ", title=" + title + "}";
    }
}

