package ru.grishenko.springboot.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.grishenko.springboot.except.CreateProductException;
import ru.grishenko.springboot.models.Product;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Primary
public class ProductMySQLRepository implements ProductRepository {

    private static SessionFactory factory;

    @Override
    public List<Product> getAllProducts() {
        try (Session session = factory.getCurrentSession())
        {
            session.beginTransaction();
            List<Product> items = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return items;
        }
    }

    @Override
    public Product getProductById(int id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product item = session.createQuery("select p from Product p where p.id = id", Product.class).getSingleResult();
            session.getTransaction().commit();
            return item;
        }
    }

    @Override
    public void addNewProduct(Product product) {
        if (product.getTitle() == null || product.getTitle().equals("")) {
            throw new CreateProductException("title", "Title cannot be empty");
        }
        if ( product.getCost() == null || product.getCost() <= 0.00) {
            throw new CreateProductException("cost", "Cost cannot be zero or negative");
        }
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product newProduct = new Product(product.getTitle(), product.getCost());
            session.save(newProduct);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteProductById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    @PostConstruct
    public void init() {
//        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
