package com.bookclub.service.dao;

/*
Assignment 4.2 #7
Update the code in the WIshlistDao to extend the GenericCrudDao instead of the
GenericDao interface.

Saved inside service/dao folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericCrudDao;

public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {
}



