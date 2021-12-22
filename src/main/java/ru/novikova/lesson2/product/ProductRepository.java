package ru.novikova.lesson2.product;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository {
    List<Product> findAll();
    Product fidByID(long id);
    void save(Product product);
    void delete(long id);
}
