/*
Assignment 9.2 #5
Update the GenericDao interface by adding a parameter to the list() method of type K 
with a variable name of key.

Saved inside service folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Modified by Mark Gallagher, 2026
*/

package com.bookclub.service.dao;

import java.util.List;

public interface GenericDao<E, K> {

    List<E> list(K key);

    E find(K key);
}