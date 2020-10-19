package com.example.Security3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hi")
    public String sayHello(){
        return "Hi !!";
    }

    @GetMapping("/user")
    public String sayHelloToUser(){
        return "Hi User !!";
    }

    @GetMapping("/admin")
    public String sayHelloToAdmin(){
        return "Hi Admin !!";
    }

    // /hi - anyone ( 1 API )
    // /user - user ( 2 API)
    // /admin - admin ( 3 APIs)

}
