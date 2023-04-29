package com.techelevator.dao;

import com.techelevator.model.CartItem;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CartItemDao {
    List<CartItem> viewShoppingCart();
   int addToShoppingCart(CartItem cartItem);
    void removeFromShoppingCart(int cartItemId);
    void clearCart();
    CartItem get(int cartItemId);
    CartItem view();




}
