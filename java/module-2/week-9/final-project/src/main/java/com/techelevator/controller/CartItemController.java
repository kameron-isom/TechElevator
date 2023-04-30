package com.techelevator.controller;

import com.techelevator.dao.CartItemDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.CartItem;
import com.techelevator.model.Product;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@PreAuthorize("hasRole('USER")
@RestController
public class CartItemController  {

    private CartItemDao dao;

    private UserDao userDao;

    public CartItemController(CartItemDao dao){this.dao =dao;}

    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    public CartItem views(Principal principal){
        return dao.view();
    }


    @RequestMapping(path = "/cart/items", method = RequestMethod.POST)
    public CartItem add( @RequestBody CartItem item, Principal principal){
        try {
            dao.addToShoppingCart(item,principal);
            item.setQuantity(item.getQuantity());
        } catch (ResourceAccessException e){
            System.out.println("Could not add item to shopping cart");
        } catch (RestClientResponseException e){
            System.out.println(e.getRawStatusCode());
        }

        return item;
    }

    @RequestMapping(path = "/cart/items/{itemId}", method = RequestMethod.DELETE)
    void remove(@PathVariable int itemId){
        try {
            dao.removeFromShoppingCart(itemId);
        } catch (ResourceAccessException e){
            System.out.println("Product Id not found. Unable to remove item " +
                    "from shopping cart");
        } catch (RestClientResponseException e){
            System.out.println(e.getRawStatusCode());
        }

    }

    @RequestMapping(path = "/cart", method = RequestMethod.DELETE)
    void clearCart(Principal principal){
        try {
            dao.clearCart(principal);
        } catch (ResourceAccessException e){
            System.out.println("Cart Id not found");
        } catch (RestClientResponseException e){
            System.out.println(e.getRawStatusCode());
        }
    }
    private void getUser(Principal principal){
        String username = principal.getName();
        User user = userDao.findByUsername(username);
         user.getId();
    }
}
