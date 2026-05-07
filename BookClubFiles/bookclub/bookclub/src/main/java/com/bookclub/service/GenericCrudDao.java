package com.bookclub.service;

/*
Assignment 8.2 #1
Update the GenericCrudDao interface by adding a parameter to the list() method of
type K and a value of key.  Update the remove method by adding a parameter of type K
and a value of key.

Saved inside service folder -- Mark Gallagher, 2026

Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import java.util.List;

public interface GenericCrudDao<E, K> {
    void add(E entity);
    void update(E entity);
    boolean remove(K entity);
    List<E> list(K key);
    E find(K key);
}


