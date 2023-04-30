package com.techelevator.Service;

import com.techelevator.dao.CartItemDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.CartItem;
import com.techelevator.model.User;

import java.security.Principal;
import java.util.List;

public class CartItemService {

    private CartItemDao cartItemDao;
    private UserDao userDao;

//    public List<CartItem> viewShoppingCart(){return null;}
//    public int addToShoppingCart(CartItem cartItem){return 0;}
//    public void removeFromShoppingCart(int cartItemId){}
//    public void clearCart(){}
//    public CartItem get(int cartItemId){return null;}
    private User getUser(Principal principal){
        String username = principal.getName();
        User user = userDao.findByUsername(username);
        return user;
    }

}
