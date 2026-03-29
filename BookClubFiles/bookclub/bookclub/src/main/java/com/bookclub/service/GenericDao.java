package com.bookclub.service;

/*
Additional Java requirements
a. Add a new file to the service package and name it GenericDao.  Make this a generic
    interface with values E and K.
b. Give the interface two methods: List<E> list() and E find(Key key)

Saved inside service folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Modified by Mark Gallagher, 2026
*/


import java.util.List;

public interface GenericDao<E, K> {
    List<E> list(); //Return a list of objetcs of type E
    E find(K key); //Return an object of type E by type K value
}