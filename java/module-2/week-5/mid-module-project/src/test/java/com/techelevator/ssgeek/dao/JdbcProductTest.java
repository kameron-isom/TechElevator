package com.techelevator.ssgeek.dao;

import com.techelevator.ssgeek.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class JdbcProductTest extends BaseDaoTests{
    private static final Product PRODUCT_1 = new Product(1,"Product 1","Description 1",BigDecimal.valueOf(9.99), "product-1.png");
    private static final Product PRODUCT_2 = new Product(2,"Product 2","Description 2", BigDecimal.valueOf(19.99), "product-1.png");

    private JdbcProductDao jdbcProductDao;
    private Product testProduct;

    @Before

    public void setup(){

        jdbcProductDao=new JdbcProductDao(dataSource);
    }

    @Test

    public void getProductsReturnsListOfProducts(){
        List<Product>products= jdbcProductDao.getProducts();
        Assert.assertEquals(1,products.size());

    }

    @Test
    public void createProducts(){
        Product createdProduct = jdbcProductDao.createProduct(PRODUCT_1);

        Assert.assertNotNull("createProduct returned null", createdProduct);

        Integer newId = createdProduct.getProductId();
        Assert.assertTrue("createProduct failed to return a product with an id", newId > 0);

        createdProduct.setProductId(newId);
        Assert.assertEquals(PRODUCT_1,createdProduct);
    }

    @Test
    public void updatedProjectReturnsUpdatedProject(){
        Product product = jdbcProductDao.getProduct(1);
        Assert.assertNotNull("can't test updateProject until getProject is working",product);
        product.setName("Test");

        jdbcProductDao.updateProduct(product);

        Product updatedProduct = jdbcProductDao.getProduct(1);
        Assert.assertEquals("updateProject failed to change project name in database", "Test", updatedProduct.getName());

        Assert.assertEquals(updatedProduct,product);
    }
}
