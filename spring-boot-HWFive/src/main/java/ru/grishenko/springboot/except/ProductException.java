package ru.grishenko.springboot.except;

public class ProductException extends RuntimeException {

    private String field;

    public ProductException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
