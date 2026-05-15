package com.bookclub.service.dao;

/*
Assignment 9.2 #3
Add a new interface to the dao package and name it BookOfTheMonthDao.

Saved inside service/dao folder -- Mark Gallagher, 2026

Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import com.bookclub.model.BookOfTheMonth;

public interface BookOfTheMonthDao extends GenericCrudDao<BookOfTheMonth, String> {
}