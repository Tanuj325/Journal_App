package com.tanuj.Spring.Boot.controller;

import com.tanuj.Spring.Boot.entity.User;
import com.tanuj.Spring.Boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

}
