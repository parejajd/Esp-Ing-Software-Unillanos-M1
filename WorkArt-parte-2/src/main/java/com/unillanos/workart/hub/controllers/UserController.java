package com.unillanos.workart.hub.controllers;

import com.unillanos.workart.hub.entities.User;
import com.unillanos.workart.hub.repositories.UserRepository;
import com.unillanos.workart.hub.utils.TokenUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    List<User> users;
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
        this.users = new ArrayList<>();
        this.users.add(new User("juan", "1234"));
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        TokenUtils tokenUtils = new TokenUtils();
        User currentUser = repository.findById(user.getUsername()).get();

        if (currentUser != null) {
            currentUser.setPassword(tokenUtils.getToken(currentUser));
            return currentUser;
        } else
            return new User();
    }
}
