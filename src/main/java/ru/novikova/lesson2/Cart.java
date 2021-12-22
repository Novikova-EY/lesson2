package ru.novikova.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.novikova.lesson2.product.Product;
import ru.novikova.lesson2.product.ProductRepositoryImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Cart {
    private LinkedHashMap<Product, Integer> cart = new LinkedHashMap<>();
    ProductRepositoryImpl productRepository;

    @Autowired
    public Cart(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    public void addToCart(long id, int count) {
        if (cart.containsKey(productRepository.fidByID(id))) {
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                if (cart.containsKey(productRepository.fidByID(id))) {
                    entry.setValue(entry.getValue() + count);
                }
            }
        } else {
            cart.put(productRepository.fidByID(id), count);
        }
    }

    public void deleteFromCart(long id, int count) {
        if (cart.containsKey(productRepository.fidByID(id))) {
            for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
                if (cart.containsKey(productRepository.fidByID(id))) {
                    if ((entry.getValue() - count) > 0) {
                        entry.setValue(entry.getValue() - count);
                    } else {
                        cart.remove(productRepository.fidByID(id));
                    }
                }
            }
        } else {
            cart.remove(productRepository.fidByID(id));
        }
    }

    public HashMap<Product, Integer> findAll() {
        return cart;
    }

}
