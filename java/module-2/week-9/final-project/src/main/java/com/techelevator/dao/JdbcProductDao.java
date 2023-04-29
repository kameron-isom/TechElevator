package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    @Override
     public List<Product> findAll(){
        List<Product> products= new ArrayList<>();
        String sql = "SELECT * FROM product";
        SqlRowSet result= jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
          products.add(mapRowToProduct(result));
        }
        return products;
    }

    @Override
    public List <Product> findByName(String name){
        List<Product> products= new ArrayList<>();
        String sql = "SELECT name, product_sku FROM product WHERE name = ? ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,name);
        while (result.next()){
            products.add(mapRowToProduct(result));
        }
        return products;}

    @Override
    public List <Product> findBySku( String productSku){
        List<Product> products= new ArrayList<>();
        String sql = "SELECT name, product_sku FROM product WHERE sku =?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,productSku);
        while (result.next()){
            products.add(mapRowToProduct(result));
        }
        return products;}

    @Override
    public Product get(int id) {
        Product product = new Product();
        String sql = "SELECT * FROM product WHERE product_id=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,id);
        if (result.next()) {
            product=mapRowToProduct(result);
        }
        return product;
    }

    private Product mapRowToProduct(SqlRowSet result){
        Product product = new Product();
        product.setProductId(result.getInt("product_id"));
        product.setName(result.getString("name"));
        product.setDescription(result.getString("description"));
        product.setProductSku(result.getString("product_sku"));
        product.setImageName(result.getString("image_name"));
        product.setPrice(result.getBigDecimal("price"));
        return product;
    }
}
