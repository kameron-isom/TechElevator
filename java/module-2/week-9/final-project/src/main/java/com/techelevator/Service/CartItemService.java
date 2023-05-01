package com.techelevator.Service;

import com.techelevator.dao.CartItemDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.CartItem;
import com.techelevator.model.User;

import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.List;

public class CartItemService {

    private CartItemDao cartItemDao;
    private UserDao userDao;

    public void addToShoppingCart(CartItem cartItem, Principal principal)  {
        User user = getUser(principal);
        if (user.getId()==cartItem.getUserId()){
           cartItemDao.addToShoppingCart(cartItem);
        }
        }


    private User getUser(Principal principal){
        String username = principal.getName();
        User user = userDao.findByUsername(username);
        return user;
    }

}
