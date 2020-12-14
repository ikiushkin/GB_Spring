package ru.springmvc.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.springmvc.exceptions.CreateProductException;
import ru.springmvc.inter.ProductRepository;
import ru.springmvc.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Primary
public class ProductsMemRepository implements ProductRepository {

    private List<Product> productList;

    @Override
    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addNewProduct(Product product) {
        if (product.getTitle().equals("")) {
            throw new CreateProductException("title", "Название не может быть пустым");
        }
        if (product.getCost() <= 0.00) {
            throw new CreateProductException("cost", "Стоимость не может быть нулевой или отрицательной");
        }
        productList.add(product);
    }

    @PostConstruct
    public void initRepository(){
        productList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            productList.add(new Product("Title_" + (i + 1), 38.40f + ((i + 1) * 10)));
        }
    }
}
