package com.bookclub.service.dao;

/*
Assignment 3.2 #4
Add a new interface to dao package and name it WishlistDao (notice the spelling?) and
extend the GenericDao interface with the WishlistItem object.

Saved inside service/dao folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericDao;

public interface WishlistDao extends GenericDao<WishlistItem, String> {
}


