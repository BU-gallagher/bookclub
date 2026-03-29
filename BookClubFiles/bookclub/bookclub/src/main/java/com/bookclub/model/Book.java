package com.bookclub.model;

/*
Additional Java requirements
a. Add a new file to the model package and name it Book.  Supply the Book class with
    the following private fields: String isbn, String title, String description, int
    numOfPages, and List<String> authors.
b. Create a default constructor and a constructor accepting five parameters: String
    isbn, String title, String description, int numOfPages, and List<String> authors.
    Assign these values to the class’s private properties.
c. Create getter/setter methods for each of the private properties.
d. Override the classes toString method by returning a string with the following format:
    “Book{isbn=<isbnValue>, title=<titleValue>, description=<descriptionValue>,
    numOfPages=<numOfPagesValue>, authors=<authorsValue>}

    Saved inside model folder -- Mark Gallagher, 2026

Initial syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import java.util.List;

public class Book {

    private String isbn;
    private String title;
    private String description;
    private int numOfPages;
    private List<String> authors;

    // Default constructor
    public Book() {}

    // Parameterized constructor
    public Book(String isbn, String title, String description, int numOfPages, List<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    }

    // Getters and Setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getNumOfPages() { return numOfPages; }
    public void setNumOfPages(int numOfPages) { this.numOfPages = numOfPages; }

    public List<String> getAuthors() { return authors; }
    public void setAuthors(List<String> authors) { this.authors = authors; }

    @Override
    public String toString() {
        return "Book{isbn=" + isbn + ", title=" + title + ", description=" + description +
                ", numOfPages=" + numOfPages + ", authors=" + authors + "}";
    }
}


