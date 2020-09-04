package com.codegym.giohang.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


//@Entity
//@Table(name = "cart")
public class Cart {
    public Map<Product,Integer> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    public boolean addToCart(Product product){
        for (Product product1: cart.keySet()) {
            if (product1.getId() == product.getId())
            {
                cart.replace(product1, cart.get(product1), cart.get(product1) + 1);
                return true;
            }
        }
            cart.put(product,1);
            return true;

    }

    public String removeProduct(Product product) {
        for (Product product1 : cart.keySet()) {
            if (product1.getId() == product.getId()) {
                cart.remove(product1);
                return "xoá thành công";
            }
        }
        return "xoá thất bại";
    }

    public String updateProduct(Product product,Integer number) {
        for (Product product1 : cart.keySet()) {
            if (product1.getId() == product.getId()) {
               cart.put(product1,number);
                return "sửa thành công";
            }
        }
        return "sửa thất bại";
    }

    public Double totalProduct() {
        Double total = 0.0;
       if(cart == null){
           return total;
       }else {
           for (Product product :cart.keySet()){
               total += product.getProductPrice() * cart.get(product);
           }
           return total;
       }
    }

    public int getAmount(Product product){
        return  cart.get(product);
    }

    public Map<Product,Integer> getCart() {
        return cart;
    }

//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//    private Long numberProduct;
//    private Double totalPrice;
//
//    public Long getNumberProduct() {
//        return numberProduct;
//    }
//
//    public void setNumberProduct(Long numberProduct) {
//        this.numberProduct = numberProduct;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public Double getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(Double totalPrice) {
//        this.totalPrice = totalPrice;
//    }


}
