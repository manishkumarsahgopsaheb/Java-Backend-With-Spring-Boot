package com.example.DemoApp1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
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

    @PostMapping("/users")
    public boolean CreateUser(@RequestBody User user){
        return db.addAUser(user);
    }

    // Put - update
    @PutMapping("/users")
    public boolean updateUser(@RequestBody User user){
        return db.updateAUser(user);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id){
        return db.deleteAUser(id);
    }

    // good : well, nice, okay
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getAUser(@PathVariable int id){
        User user = db.getAUser(id);
        MultiValueMap<String,String> headers =
                new LinkedMultiValueMap<>();
        LinkedList<String> values = new LinkedList<>();
        values.add("my-server");
        values.add("my own machine");
        headers.put("server",values);

        ResponseEntity<User> responseEntity =
                new ResponseEntity<User>(user, headers, HttpStatus.CREATED);

        return responseEntity;
    }

    // API Docs


}
