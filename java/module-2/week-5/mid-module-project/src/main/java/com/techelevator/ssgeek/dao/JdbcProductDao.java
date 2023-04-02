package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao (DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getProducts() {
        List<Product> listOfAllProducts = new ArrayList<>();
        Product products = null;
        String sql = "SELECT * FROM product";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        if(result.next()){
            products= mapRowToResults(result);
            listOfAllProducts.add(products);
        }
        return listOfAllProducts;
    }


    @Override
    public Product createProduct(Product newProduct){
        String sql = "INSERT INTO product (name, description, image_name, price) VALUES(?,?,?,?) RETURNING product_id";
        Integer newId = jdbcTemplate.queryForObject(sql,int.class,newProduct.getName(),newProduct.getDescription(),newProduct.getImageName(),newProduct.getPrice());
        newProduct.setProductId(newId);

     return newProduct;
    }

    @Override
    public void updateProduct(Product updatedProduct){
        String sql = "UPDATE product SET name=? WHERE product_id=?";
        int updatedRows= jdbcTemplate.update(sql,updatedProduct.getName(),updatedProduct.getProductId());
        if (updatedRows!=1){
            System.out.println("Unable to update Product");
        }

    }

    @Override
    public void deleteProduct(int productId){
        String query = "DELETE FROM line_item WHERE product_id=?";
        int rowsDeleted = jdbcTemplate.update(query,productId);

        String sql= "DELETE FROM product WHERE product_id=?";
        int numberOfRowsDeleted = jdbcTemplate.update(sql, productId);

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
    @Override
    public Product getProduct(int productId) {
        String sql ="SELECT * FROM product WHERE product_id=?";
        Product product = new Product();
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql,productId);
        while(result.next()){
           product= mapRowToResults(result);
        }
        return product;
    }

    @Override
    public List<Product> getProductsWithNoSales() {
        return null;
    }
};

