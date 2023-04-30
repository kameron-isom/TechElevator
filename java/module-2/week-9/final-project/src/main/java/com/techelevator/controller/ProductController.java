package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("permitAll")
@RestController
public class ProductController {

    private ProductDao dao;

    public ProductController (ProductDao dao){this.dao =dao;}


    //Find all products for sale
    @RequestMapping(path = "/products", method = RequestMethod.GET )
    public List<Product> listAll(@RequestParam (defaultValue = "") String name, @RequestParam(defaultValue = "") String product_sku){
        if (!product_sku.isEmpty()){
            return dao.findBySku(product_sku);
        }
        if (!name.isEmpty()){
            return dao.findByName(name);
        }
        return dao.findAll();
    }

    @RequestMapping(path ="/products/{id}", method = RequestMethod.GET)
    // view details about specific product
    public void viewOneProduct(@PathVariable int id){
        dao.get(id);
    }


}
