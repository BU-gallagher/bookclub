package com.bookclub.service.dao;

/*
Additional Java requirements
a. Add a new file to the service package and name it GenericDao.  Make this a generic
    interface with values E and K.
b. Give the interface two methods: List<E> list() and E find(Key key)

Saved inside service/dao folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Modified by Mark Gallagher, 2026
*/

import com.bookclub.model.Book;
import com.bookclub.service.GenericDao;

public interface BookDao extends GenericDao<Book, String> {
}


