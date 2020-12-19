package ru.grishenko.springboot.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.grishenko.springboot.except.CreateProductException;
import ru.grishenko.springboot.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component

public class ProductMemRepository implements ProductRepository{

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
        if (product.getTitle() == null || product.getTitle().equals("")) {
            throw new CreateProductException("title", "Title cannot be empty");
        }
        if ( product.getCost() == null || product.getCost() <= 0.00) {
            throw new CreateProductException("cost", "Cost cannot be zero or negative");
        }
        productList.add(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Iterator<Product> iter = productList.iterator();
        Product item;
        while (iter.hasNext()) {
            item = iter.next();
            if (item.getId().equals(id)) {
                iter.remove();
                return;
            }
        }
    }

    @PostConstruct
    public void initRepository(){
        productList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            productList.add(new Product("Title_" + (i + 1), 38.40f + ((i + 1) * 10)));
        }
    }
}
