package com.codegym.giohang.service.impl;

import com.codegym.giohang.model.Product;
import com.codegym.giohang.repository.ProductRepository;
import com.codegym.giohang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> productMap;

    static {

        productMap = new HashMap<>();
        productMap.put(1, new Product( "Sản Phẩm 1", 20000.00, "Hàng Tặng Không Bán", 1, "static/img/Capture1.PNG"));
        productMap.put(2, new Product( "Sản Phẩm 2", 30000.00, "Hàng Tặng Không Bán", 1, "static/img/Capture2.PNG"));
        productMap.put(3, new Product( "Sản Phẩm 3", 40000.00, "Hàng Tặng Không Bán", 1, "static/img/Capture3.PNG"));
        productMap.put(4, new Product( "Sản Phẩm 4", 50000.00, "Hàng Tặng Không Bán", 1, "static/img/Capture4.PNG"));
    }

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> findAllByFirstNameContaining(String firstname) {
        return null;
    }

}
