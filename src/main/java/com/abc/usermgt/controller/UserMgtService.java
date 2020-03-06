package com.abc.usermgt.controller;

import com.abc.usermgt.dao.UserMgtDAO;
import com.abc.usermgt.domain.User;
import com.abc.usermgt.jwt.JWTRequest;
import com.abc.usermgt.jwt.JWTResponse;
import com.abc.usermgt.jwt.JWTTokenUtil;
import com.abc.usermgt.jwt.JWTUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserMgtService {

    @Autowired
    public UserMgtDAO userDAO;
    
    @Autowired
    private JWTTokenUtil jwtTokenUtil;

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

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JWTRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        UserDetails details = new JWTUserDetails("dimuthu", "lee");
        final String token = jwtTokenUtil.generateToken(details);
        return ResponseEntity.ok(new JWTResponse(token));
    }


    private boolean authenticate(String username, String password) throws Exception {
        return true;
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
