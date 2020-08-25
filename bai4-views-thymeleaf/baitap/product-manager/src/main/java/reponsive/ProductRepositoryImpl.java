package reponsive;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Banh", 10000.0, 10,"ĐN"));
        products.put(2, new Product(2, "Keo", 10000.0, 10,"HN"));
        products.put(3, new Product(3, "Kem", 10000.0, 10,"HCM"));
        products.put(4, new Product(4, "Sua", 10000.0, 10,"HUE"));
        products.put(5, new Product(5, "Duong", 10000.0, 10,"QNM"));
        products.put(6, new Product(6, "Gao", 10000.0, 10,"QNI"));
        products.put(7, new Product(7, "Bot My", 10000.0, 10,"QNN"));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }
}
