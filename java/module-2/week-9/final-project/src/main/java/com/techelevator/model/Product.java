package com.techelevator.model;

import java.math.BigDecimal;

public class Product {
    private int productId;
    private String productSku;
    private String name;
    private String description;
    private String imageName;
    private BigDecimal price;

    public Product(int productId, String productSku, String name, String description, String imageName, BigDecimal price){
        this.productId= productId;
        this.productSku= productSku;
        this.name=name;
        this.description = description;
        this.imageName = imageName;
        this.price =price;
    }

    public Product() {

    }

    public int getProductId(){return productId;}

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

