package com.RentCars.exception;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidationException  extends Exception {

    private String message;

    public String getMessage() {

        return message + ": Что-то не так! ";
    }
}