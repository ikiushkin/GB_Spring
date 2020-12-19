package ru.grishenko.springboot.repositories;

import ru.grishenko.springboot.models.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(int id);

    void addNewProduct(Product product);

    void deleteProductById(Long id);
}
