package com.bookclub.service.impl;

/*
Updated based on the requirements of Assignment 7.2:
Renamed the MemBookDao class from teh impl package to RestBookDao class.

Additional Java requirements
a. Remove the books variable and the code inside of the class’s constructor.
b. Add a new method named getBooksDoc with a parameter of type string and a name
of isbnString.  
c. Update the list() method to call the getBooksDoc() method and build a list of books.  
d. Update the find() method to call the getBooksDoc() method and build a book object.

Saved inside service/impl folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Suppleemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

@Repository("bookDao")
public class RestBookDao implements BookDao {

    public Object getBooksDoc(String isbnString) {
        String openLibraryUrl = "https://openlibrary.org/api/books";

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<String> response = rest.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        String jsonBooklist = response.getBody();

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist);
    }

    @Override
    public List<Book> list() {
        String isbnString = "ISBN:9780345339683,ISBN:9780261103573,ISBN:9780261102361,ISBN:9780261102378";

        Object doc = getBooksDoc(isbnString);

        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..details.title");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < isbns.size(); i++) {
            String isbn = isbns.get(i).replace("ISBN:", "");
            String title = titles.size() > i ? titles.get(i) : "N/A";
            String infoUrl = infoUrls.size() > i ? infoUrls.get(i) : "N/A";

            Book book = new Book();
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setInfoUrl(infoUrl);

            books.add(book);
        }

        return books;
    }

    @Override
    public Book find(String key) {
        Object doc = getBooksDoc("ISBN:" + key);

        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..details.title");
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages");
        List<Object> descriptions = JsonPath.read(doc, "$..details.description");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");

        String isbn = isbns.size() > 0 ? isbns.get(0).replace("ISBN:", "") : key;
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "N/A";

        String description = "N/A";

        if (descriptions.size() > 0) {
            Object desc = descriptions.get(0);

            if (desc instanceof String) {
                description = desc.toString();
            } else if (desc instanceof Map) {
                Object value = ((Map<?, ?>) desc).get("value");
                description = value != null ? value.toString() : "N/A";
            }
        }

        Book book = new Book();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setDescription(description);
        book.setInfoUrl(infoUrl);
        book.setNumOfPages(numOfPages);

        return book;
    }
}
