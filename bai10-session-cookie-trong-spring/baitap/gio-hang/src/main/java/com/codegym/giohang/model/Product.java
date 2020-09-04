package com.codegym.giohang.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Double productPrice;
    private String productContext;
    private int productNumber;
    private String productImg;

    public Product() {
    }

    public Product(String productName,Double productPrice, String productContext,int productNumber,String productImg){
        this.productName = productName;
        this.productPrice = productPrice;
        this.productContext = productContext;
        this.productNumber =  productNumber;
        this.productImg =   productImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductContext() {
        return productContext;
    }

    public void setProductContext(String productContext) {
        this.productContext = productContext;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}
