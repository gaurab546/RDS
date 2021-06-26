package com.example.demo.controller;

import com.example.demo.UserService;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping
    public String hello( ){
        return "Hello World";
    }


    @PostMapping (value ="/reg")
    public String userReg(@RequestBody User user){
        userService.registerUser(user);
        return ("Customer registered");
    }

    @GetMapping(value = "/get")
    public List<User> userGet(){
        List list = userRepository.findAll();
        return list;
    }
}
