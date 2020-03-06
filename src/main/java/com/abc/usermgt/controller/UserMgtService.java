package com.abc.usermgt.controller;

import com.abc.usermgt.dao.UserMgtDAO;
import com.abc.usermgt.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserMgtService {

    @Autowired
    public UserMgtDAO userDAO;

    @PostMapping("/")
    public ResponseEntity<URI> addUser(@RequestBody User user) {
        User savedUser = userDAO.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUser(@PathVariable(value="username") String username){
        User savedUser = userDAO.getUser(username);
        if (savedUser != null ) {
            return ResponseEntity.ok(savedUser);
        } else {
            return new ResponseEntity("Invalid Name", HttpStatus.NOT_FOUND);
        }
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
