package com.example.DemoApp1;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    DB db = new DB();

    @GetMapping("/hi")
    public String sayHello(){
        return "Hi coders";
    }

    // http://localhost:8080/convert?usd=60
    @GetMapping("/convert")
    public int convertToINR(@RequestParam int usd){
        return usd * 75;
    }
    // http://localhost:8080/search?q=sachin : query param


    @GetMapping("/search")
    public String searchAWord(@RequestParam String q){

        return db.search(q);
    }

    // http://localhost:8080/search?q=sachin : query param
    // http://localhost:8080/search/sachin : path param
    @GetMapping("/search/{word}")
    public String searchAWord2(@PathVariable String word){

        return db.search(word);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return db.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getAUser(@PathVariable int id){
        return db.getAUser(id);
    }

    @PostMapping("/users")
    public boolean CreateUser(@RequestBody User user){
        return db.addAUser(user);
    }

}
