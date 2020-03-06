package com.abc.usermgt.dao;

import com.abc.usermgt.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public final class UserMgtDAO {

    private static int index = 0;
    private List<User> users = new ArrayList<>();

    public User getUser(int id) {
        return null;
    }

    public User addUser(User user) {
        index++;
        user.setId(index);
        users.add(user);
        return user;
    }

    public User getUser(String name) {
        Optional<User> userOptional = users.stream().filter(u -> u.getUsername().equals(name)).findFirst();
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            return null;
        }
    }

    public User[] getUsers(){
        return null;
    }

    public void deleteUser(){

    }

    public void updateUser() {

    }
}
