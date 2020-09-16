package com.example.DemoApp1;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id){
        super("Could not find the book of id: "+ id);
    }
}
