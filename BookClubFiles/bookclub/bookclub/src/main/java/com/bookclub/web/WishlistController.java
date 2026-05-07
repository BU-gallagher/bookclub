package com.bookclub.web;

/*
Assigment 8.2 #4
Update the WishlsitController by adding methods for showWishlistItem, 
updateWishlistItem, and removeWiishlistItem 

Saved inside web folder -- Mark Gallagher, 2026

Krasso, K. (2026). CIS 530 Server-Side Development. Bellevue University, all rights reserved.
Supplemental syntax created by ChatGPT, 2026
Modified by Mark Gallagher, 2026
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistDao wishlistDao;

    @Autowired
    public void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist() {
        return "wishlist/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(
            @Valid WishlistItem wishlistItem,
            BindingResult bindingResult,
            Authentication authentication) {

        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        String username = authentication.getName();
        wishlistItem.setUsername(username);

        wishlistDao.add(wishlistItem);

        return "redirect:/wishlist";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showWishlistItem(@PathVariable String id, Model model) {
        WishlistItem wishlistItem = wishlistDao.find(id);
        model.addAttribute("wishlistItem", wishlistItem);
        return "wishlist/view";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/update")
    public String updateWishlistItem(
            @Valid WishlistItem wishlistItem,
            BindingResult bindingResult,
            Authentication authentication) {

        if (bindingResult.hasErrors()) {
            return "wishlist/view";
        }

        String username = authentication.getName();
        wishlistItem.setUsername(username);

        wishlistDao.update(wishlistItem);

        return "redirect:/wishlist";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}")
    public String removeWishlistItem(@PathVariable String id) {
        wishlistDao.remove(id);
        return "redirect:/wishlist";
    }
}