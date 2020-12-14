package ru.springmvc.exceptions;

public class CreateProductException extends IllegalArgumentException{

    private String field;

    public CreateProductException(String filed , String msg) {
        super(msg);
        this.field = filed;

    }

    public String getField() {
        return field;
    }
}
