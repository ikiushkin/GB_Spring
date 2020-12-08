package ru.geekbrains.context;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Primary
public class ProductRepository {
    private static final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        add(new Product(1, "Product1", 120));
        add(new Product(2, "Product2", 76));
        add(new Product(3, "Product3", 70));
        add(new Product(4, "Product4", 45));
        add(new Product(5, "Product5", 130));
        add(new Product(6, "Product6", 840));
        add(new Product(7, "Product7", 110));
        add(new Product(8, "Product8", 235));
    }

    public List<Product> getProduct() {
        return Collections.unmodifiableList(products);
    }

    public void add(Product product) {
        products.add(product);
    }

    public Product getProductById(int id) {
        if (products.size() != 0) {
            for (Product product : products) {
                if (id == product.getId()) {
                    return product;
                }
            }
        }
        return null;
    }
}
