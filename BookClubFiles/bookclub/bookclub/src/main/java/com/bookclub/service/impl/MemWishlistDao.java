package com.bookclub.service.impl;

/*
Assignment 3.2 #5
Add a new class to the impl package and name it MemWishlistDao (notice the spelling?)
and write methods to implement list() and find().  In the classes constructor populate a
private property called wishlist of type List<WishlistItem>.  Return this array in the list()
method and use this array to return a matching object by isbn.  Use the work you
completed in the MemBookDao as a baseline for how to write the Java code.

Saved inside service/impl folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Initial syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import java.util.ArrayList;
import java.util.List;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

public class MemWishlistDao implements WishlistDao {

    private final List<WishlistItem> wishlist = new ArrayList<>();

    public MemWishlistDao() {
        wishlist.add(new WishlistItem("6", "Murach's Java Programming"));
        wishlist.add(new WishlistItem("7", "Introduction to Java: Programming and Data Structures"));
    }
    //Add a method to save items to in MemWishlistDao
    //public void add(WishlistItem item) {
    //wishlist.add(item);
    //}

    @Override
    public List<WishlistItem> list() {
        return wishlist;
    }

    @Override
    public WishlistItem find(String key) {
        return wishlist.stream()
                .filter(item -> item.getIsbn().equals(key))
                .findFirst()
                .orElse(null);
    }
}
