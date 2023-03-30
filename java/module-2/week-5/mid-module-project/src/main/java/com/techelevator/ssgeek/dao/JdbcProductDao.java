package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //list all products
    //view product details
    //add a product
    //modify product details
    //remove a product


    @Override
    public List<Product> getProducts() {
        List<Product> listOfAllProducts = new ArrayList<>();
        Product products = null;
        String sql = "SELECT * FROM products";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next()){
            products= mapRowToResults(result);
            listOfAllProducts.add(products);
        }
        return listOfAllProducts;
    }


    @Override
    public Product createProduct(Product newProduct){
        String sql = "INSERT INTO product (product_id, name, description, image_name, price) VALUES(?,?,?,?,?) RETURNING product_id";
        Integer newId = jdbcTemplate.queryForObject(sql,int.class, newProduct.getProductId(),newProduct.getName(),newProduct.getDescription(),newProduct.getImageName(),newProduct.getPrice());
        newProduct.setProductId(newId);

     return newProduct;
    }

    @Override
    public void updateProduct(Product updatedProduct){

    }

    @Override
    public  void deleteProduct(int productId){

}

    private Product mapRowToResults (SqlRowSet result){
        Product product = new Product();
        product.setName(result.getString("name"));
        product.setDescription(result.getString("description"));
        product.setProductId(result.getInt("product_id"));
        product.setImageName(result.getString("image_name"));
        product.setPrice(result.getBigDecimal("price"));
        return product;
    }
}
