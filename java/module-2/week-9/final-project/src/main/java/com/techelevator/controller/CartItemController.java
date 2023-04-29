package com.techelevator.controller;

import com.techelevator.dao.CartItemDao;
import com.techelevator.model.CartItem;
import com.techelevator.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CartItemController {

    private CartItemDao dao;

    public CartItemController(CartItemDao dao){this.dao =dao;}

    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    public CartItem views(){
       return dao.view();
    }


    @RequestMapping(path = "/cart/items", method = RequestMethod.POST)
    public CartItem add( @RequestBody CartItem item){
            dao.addToShoppingCart(item);
            item.setQuantity(item.getQuantity());
        return item;
    }

    @RequestMapping(path = "/cart/items/{itemId}", method = RequestMethod.DELETE)
    void remove(@PathVariable int itemId){
        dao.removeFromShoppingCart(itemId);

    }

    @RequestMapping(path = "/cart", method = RequestMethod.DELETE)
    void clearCart(  CartItem cartItem){
        dao.clearCart();
    }
}
