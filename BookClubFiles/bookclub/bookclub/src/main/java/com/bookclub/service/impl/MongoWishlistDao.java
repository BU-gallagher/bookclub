package com.bookclub.service.impl;

/*
Assignment 4.2 #8
Add a new Java class to the impl package and name it MongoWishlistDao.

Additional Requirements
a. Implement the WishlistDao interface.
b. Add a decorator to the class named @Repository and it a value of wishlistDao
c. Add a private property named mongoTemplate of type MongoTemplate and give it a 
    decorator of @Autowired.  
d. Implement the list() method by calling the mongoTemplate.findAll() method. 
e. Implement the add method by calling the mongoTemplate.save(entity) method.  


Saved inside service/impl folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

    @Repository("wishlistDao")
    public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(WishlistItem entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void update(WishlistItem entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public boolean remove(WishlistItem entity) {
        mongoTemplate.remove(entity);
        return true;
    }

    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    }

    @Override
    public WishlistItem find(String key) {
        return mongoTemplate.findById(key, WishlistItem.class);
    }
}



