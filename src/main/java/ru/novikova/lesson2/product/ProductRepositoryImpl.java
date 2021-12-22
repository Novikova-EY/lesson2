package ru.novikova.lesson2.product;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product(1l, "Product 1", 10));
        products.add(new Product(2l, "Product 2", 20));
        products.add(new Product(3l, "Product 3", 30));
        products.add(new Product(4l, "Product 4", 40));
        products.add(new Product(5l, "Product 5", 50));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product fidByID(long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void delete(long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
            }
        }
    }
}
