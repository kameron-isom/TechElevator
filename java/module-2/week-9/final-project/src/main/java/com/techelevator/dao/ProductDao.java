package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {
    List <Product> findAll(); //Find all products for sale
    List <Product> findBySku(String productSku); // Find by name or sku
    Product get(int id); // view details about specific product
    List<Product> findByName (String name);


}
