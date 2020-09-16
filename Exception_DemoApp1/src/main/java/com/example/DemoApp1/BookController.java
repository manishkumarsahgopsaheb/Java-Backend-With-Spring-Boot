package com.example.DemoApp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
public class  BookController {

    @Autowired
    BookRepository repository;
    // repository = new BookRepository();

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @GetMapping("/booksByName")
    public List<Book> getAllBooksByName(){
        return repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @PostMapping("/books")
    public boolean addABook(@RequestBody Book book){
        repository.save(book);
        return true;
    }

    // 100 times : 100 objects

    @GetMapping("/books/{id}")
    public Book findABook(@PathVariable int id){
         // Book book = repository.findById(id);
        // return book.getName();

        /*
       Optional<Book> object = repository.findById(id);
       if(object.isPresent()){
           return object.get(); // book
       }
       return null;

         */
        return repository.findById(id)
               .orElseThrow(() -> new BookNotFoundException(id));

    }

    @DeleteMapping("/books/{id}")
    public boolean deleteABook(@PathVariable int id){
        try {
            repository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
         return true;
    }
}

// controller : service : DA Layer
