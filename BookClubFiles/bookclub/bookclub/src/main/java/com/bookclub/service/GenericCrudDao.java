package com.bookclub.service;

/*
Assignment 4.2 #4
Add a new interface to the service package and name it GenericCrudDao.java

Additional Requirements
a. Follow the signature you used in the GenericDao interface by accepting generic
    types for E and K.  For example, GenericCrudDao<E, K> {}.
b. Add 5 methods to the interfaces body: void add(E entity), void update(E entity),
    boolean remove(E entity), List<E> list(), and E find(K key)

Saved inside service folder -- Mark Gallagher, 2026

Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import java.util.List;

public interface GenericCrudDao<E, K> {
    void add(E entity);
    void update(E entity);
    boolean remove(E entity);
    List<E> list();
    E find(K key);
}


