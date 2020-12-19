package ru.grishenko.springboot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.grishenko.springboot.models.Product;
import ru.grishenko.springboot.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.getAllProducts();
    }

    public List<Product> getProducts(Integer minCost, Integer maxCost) {
        List<Product> out = getProducts();
        if (minCost != null) {
            out = out.stream().filter(s -> s.getCost() >= minCost).collect(Collectors.toList());
        }
        if (maxCost != null) {
            out = out.stream().filter(s -> s.getCost() <= maxCost).collect(Collectors.toList());
        }
        return out;
    }

    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    public void addNewProduct(Product product) {
        productRepository.addNewProduct(product);
    }

    public void addNewProduct(String title, Float cost) {
        productRepository.addNewProduct(new Product(title, cost));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

}
