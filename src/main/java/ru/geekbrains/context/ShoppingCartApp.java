package ru.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShoppingCartApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductCartRepository productCartRepository = context.getBean("productCartRepository", ProductCartRepository.class);
        System.out.println(productCartRepository.addProduct(1));
        System.out.println(productCartRepository.addProduct(3));
        System.out.println(productCartRepository.addProduct(5));
        System.out.println(productCartRepository.addProduct(7));
        System.out.println(productCartRepository.removeProduct(3));
        System.out.println(productCartRepository.clearCart());
        System.out.println(productCartRepository.addProduct(8));


        context.close();
        }
    }

