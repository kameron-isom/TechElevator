package com.techelevator.dao;

import com.techelevator.model.CartItem;

import java.security.Principal;
import java.util.List;

public interface CartItemDao {

   int addToShoppingCart(CartItem cartItem, Principal principal);
    void removeFromShoppingCart(int cartItemId);
    void clearCart(Principal principal);
    CartItem get(int cartItemId);
    CartItem view();





}
