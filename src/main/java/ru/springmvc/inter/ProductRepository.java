package ru.springmvc.inter;

import ru.springmvc.models.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(int id);

    void addNewProduct(Product product);
}
