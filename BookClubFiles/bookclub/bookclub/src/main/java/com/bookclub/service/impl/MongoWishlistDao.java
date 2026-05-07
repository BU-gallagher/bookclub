package com.bookclub.service.impl;

/*
Assignment 8.2 #3
Update the MongoWishlistDao class

Additional requirements
a. Update the list method by adding a QueryCriteria for username and pass that to the
find() method off of the mongoTemplate variable
b. Write the code for the update method
c. Write the code for the remove method.

Saved inside service/impl folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    public boolean remove(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(key));

        mongoTemplate.remove(query, WishlistItem.class);
        return true;
    }

    @Override
    public List<WishlistItem> list(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(key));

        return mongoTemplate.find(query, WishlistItem.class);
    }

    @Override
    public WishlistItem find(String key) {
        return mongoTemplate.findById(key, WishlistItem.class);
    }
}



