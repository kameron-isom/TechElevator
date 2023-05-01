package com.techelevator.dao;

import com.techelevator.model.CartItem;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCartItemDao implements CartItemDao {

    private final JdbcTemplate jdbcTemplate;

    private UserDao userDao;

    public JdbcCartItemDao (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate =jdbcTemplate;
    }

    public static String API_BASE_URL = "https://teapi.netlify.app/api/statetax?state=[state-code]";
    RestTemplate restTemplate= new RestTemplate();


    @Override
    public List <CartItem> viewShoppingCart(){
        String sql ="SELECT * FROM cart_item";
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql);
        List <CartItem> cartItems = new ArrayList<>();
        while (result.next()){
            CartItem cartItem = mapRowToCartItem(result);
            cartItems.add(cartItem);
        }
        return cartItems;
    }

    public CartItem view(){
        CartItem cartItem = new CartItem();
        String sql = "SELECT * FROM cart_item";
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            cartItem = mapRowToCartItem(result);
        }
        return cartItem;
    }

    @Override
    public int addToShoppingCart(CartItem cartItem){
       String sql = "INSERT INTO cart_item (user_id,product_id,quantity ) " +
               "VALUES (?,?,?)" +
               "RETURNING cart_item_id";
       int id = jdbcTemplate.queryForObject(sql,int.class,cartItem.getUserId(),cartItem.getProductId(),cartItem.getQuantity());
       return id;
    }

    @Override
    public void removeFromShoppingCart( @PathVariable  int id){
        String sqlRemoveWish = "DELETE FROM wishlist_item WHERE product_id=?";
        int Wish =jdbcTemplate.update(sqlRemoveWish, id);

        String sql ="DELETE FROM cart_item WHERE product_id=?";
        int productRemoved= jdbcTemplate.update(sql,id);

        String sqlremove = "DELETE FROM product WHERE product_id=?";
        int removed =jdbcTemplate.update(sqlremove, id);

    }

    @Override
    public void clearCart(Principal principal){
        String sql ="DELETE FROM cart_item";
        int productRemoved= jdbcTemplate.update(sql);
    }

    @Override
    public CartItem get(int cartItemId){
        CartItem cartItem = new CartItem();
        String sql = "SELECT * FROM cart_item WHERE cart_item_id=?";
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql,cartItemId);
        while (result.next()){
          cartItem = mapRowToCartItem(result);
        }
        return cartItem;
    }

    public BigDecimal findSubtotal(Principal principal){
        String sql = "SELECT p.price FROM cart_item ci JOIN product p ON p.product_id = ci.product_id WHERE user_id=?";
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql,principal);
        BigDecimal subtotal= null;
        while (result.next()){
            subtotal=subtotal.add(result.getBigDecimal("price"));
        }
        return subtotal;
    }

    public BigDecimal taxAmount(User user){
        String sql= "SELECT state_code FROM user WHERE user_id=?";
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql,user.getId());
        String stateCode= null;
        if (result.next()){
            stateCode=result.getString("state_code");
        }
        BigDecimal tax= restTemplate.getForObject(API_BASE_URL+stateCode,BigDecimal.class);
        return tax.divide(new BigDecimal(100));
    }


    private User getUser(Principal principal){
        String username = principal.getName();
        User user = userDao.findByUsername(username);
        return user;
    }

    private CartItem mapRowToCartItem(SqlRowSet result){
        CartItem cartItem = new CartItem();
        cartItem.setUserId(result.getInt("cart_item_id"));
        cartItem.setUserId(result.getInt("user_id"));
        cartItem.setProductId(result.getInt("product_id"));
        cartItem.setQuantity(result.getInt("quantity"));
    return cartItem;
    }
}
