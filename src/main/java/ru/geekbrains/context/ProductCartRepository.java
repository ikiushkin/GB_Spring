package ru.geekbrains.context;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductCartRepository {
    private static final List<Product> cartList = new ArrayList<>();
    private ProductRepository productRepository = null;

    public ProductCartRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
        clearCart();
    }

    public List<Product> getProduct() {
        return cartList;
    }

    public List<Product> addProduct(int id) {
        cartList.add(productRepository.getProductById(id));
        return cartList;
    }

    public List<Product> removeProduct (int id) {
        if (cartList.size() != 0) {
        cartList.remove(productRepository.getProductById(id));
        return cartList;
        }
        return null;
    }

    public String clearCart() {
        cartList.clear();
        return "Your shopping card is cleared";
    }
}
