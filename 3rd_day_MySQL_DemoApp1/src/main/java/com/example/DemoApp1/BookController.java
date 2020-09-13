package com.example.DemoApp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository repository;
    // repository = new BookRepository();

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @PostMapping("/books")
    public boolean addABook(@RequestBody Book book){
        repository.save(book);
        return true;
    }
}
