package ru.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShowAllProducts {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        System.out.println(productRepository.getProduct());
        context.close();
    }
}
