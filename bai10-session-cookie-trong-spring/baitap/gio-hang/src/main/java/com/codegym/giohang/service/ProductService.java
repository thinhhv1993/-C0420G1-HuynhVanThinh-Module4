package com.codegym.giohang.service;

import com.codegym.giohang.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product customer);

    void remove(Long id);

    Iterable<Product> findAllProduct(Product product);

    List<Product> findAllByFirstNameContaining(String firstname);
}
