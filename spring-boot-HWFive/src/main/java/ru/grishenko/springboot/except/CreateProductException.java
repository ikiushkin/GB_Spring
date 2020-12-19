package ru.grishenko.springboot.except;

public class CreateProductException extends ProductException{

    public CreateProductException(String field, String message) {
        super(field, message);
    }
}
