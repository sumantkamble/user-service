package com.sk.userservice.controllers;

import com.sk.userservice.entities.User;
import com.sk.userservice.exceptions.UserNotFoundException;
import com.sk.userservice.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> all() {
        log.info("Get all users");
       return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User byId(@PathVariable("id") Long userId) {
        log.info("Get user by userid");
        return userService.getUser(userId)
                .orElseThrow(() -> new UserNotFoundException("User with userid ["+userId+"] not found"));
    }

    @PostMapping("")
    public User doRegister(@RequestBody @Valid User user, BindingResult result) {

        log.info("Register new user");

        log.info("Fisrt Name: "+user.getFirstName());
        log.info("Last Name: "+user.getLastName());
        log.info("Username: "+user.getUsername());
        log.info("Password: "+user.getPassword());
        log.info("Email: "+user.getEmail());

        return userService.registerUser(user);
    }

}
