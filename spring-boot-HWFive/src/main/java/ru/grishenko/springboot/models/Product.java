package ru.grishenko.springboot.models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    private static Long idInc = 0L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private Float cost;

    {
        idInc++;                // генерация ID для репозитория в памяти, не для БД
    }
    public Product() {
        this.id = idInc;
    }
    public Product(String title, Float cost) {
        this.id = idInc;
        this.title = title;
        this.cost = cost;
    }
}
