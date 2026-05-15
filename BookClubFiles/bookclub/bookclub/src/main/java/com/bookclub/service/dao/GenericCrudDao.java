/*
Assignment 9.2 #3
Update the GenericCrudDao interface by adding a parameter to the list() method of
type K and a value of key.  Update the remove method by adding a parameter of type K
and a value of key.

Saved inside service folder -- Mark Gallagher, 2026

Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

package com.bookclub.service.dao;

public interface GenericCrudDao<E, K> extends GenericDao<E, K> {

    void add(E entity);

    void update(E entity);

    boolean remove(K key);
}