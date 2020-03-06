package com.abc.usermgt.controller;

import com.abc.usermgt.dao.UserMgtDAO;
import com.abc.usermgt.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserMgtService {

    @Autowired
    private UserMgtDAO userDAO;

    @PostMapping("/")
    public ResponseEntity<URI> addUser(@RequestBody User user) {
       return null;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUser(){
        return null;
    }

    @PutMapping("/")
    public ResponseEntity udpateUser() {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity deleteUser() {
        return null;
    }

    @GetMapping("/all")
    public ResponseEntity<User[]> getAllUsers() {
        return null;
    }

/*
    @GetMapping("/health")
    public void sayHi() {
        System.out.println("Hi");
    }*/
}
