package com.bookclub.service.impl;

/*
Assignment 9.2 #4
AAdd a new class to the impl package and name it MongoBookOfTheMonthDao.

Saved inside service/impl folder -- Mark Gallagher, 2026

Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;

@Repository("bookOfTheMonthDao")
public class MongoBookOfTheMonthDao implements BookOfTheMonthDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(BookOfTheMonth entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public void update(BookOfTheMonth entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public boolean remove(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(key));

        mongoTemplate.remove(query, BookOfTheMonth.class);
        return true;
    }

    @Override
    public List<BookOfTheMonth> list(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("month").is(Integer.parseInt(key)));

        return mongoTemplate.find(query, BookOfTheMonth.class);
    }

    @Override
    public BookOfTheMonth find(String key) {
        return mongoTemplate.findById(key, BookOfTheMonth.class);
    }
}