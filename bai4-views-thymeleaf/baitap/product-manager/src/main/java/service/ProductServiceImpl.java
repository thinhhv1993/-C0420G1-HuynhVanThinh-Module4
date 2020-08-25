package service;

import model.Product;
import reponsive.ProductRepository;
import reponsive.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        this.productRepository.delete(id);
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }
}
