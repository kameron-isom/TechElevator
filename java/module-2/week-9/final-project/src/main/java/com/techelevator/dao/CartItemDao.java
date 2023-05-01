package com.techelevator.dao;

import com.techelevator.model.CartItem;

import java.security.Principal;
import java.util.List;

public interface CartItemDao {
    List <CartItem> viewShoppingCart();
    int addToShoppingCart(CartItem cartItem);
    void removeFromShoppingCart(int cartItemId);
    void clearCart(Principal principal);
    CartItem get(int cartItemId);
    CartItem view();





}
