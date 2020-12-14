package ru.springmvc.models;

import org.springframework.validation.FieldError;

public class ErrorModel {

    private String objectName;
    private String entity;
    private String msg;

    public ErrorModel(String objectName, String entity, String msg) {
        this.objectName = objectName;
        this.entity = entity;
        this.msg = msg;
    }

    public ErrorModel(FieldError fieldError, String msg) {
        this.objectName = fieldError.getObjectName();
        this.entity = fieldError.getField();
        if (msg == null) {
            this.msg = fieldError.getDefaultMessage();
        } else {
            this.msg = msg;
        }
    }

    public String getObjectName() {
        return objectName;
    }

    public String getEntity() {
        return entity;
    }

    public String getMsg() {
        return msg;
    }
}
