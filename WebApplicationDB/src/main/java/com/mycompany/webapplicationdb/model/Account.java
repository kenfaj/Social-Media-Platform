package com.mycompany.webapplicationdb.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<User> users;

    public Account() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }
}