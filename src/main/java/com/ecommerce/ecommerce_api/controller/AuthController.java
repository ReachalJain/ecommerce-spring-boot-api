package com.ecommerce.ecommerce_api.controller;

import com.ecommerce.ecommerce_api.model.User;
import com.ecommerce.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User found = userRepository.findByEmailAndPassword(
                user.getEmail(),
                user.getPassword()
        );
        return found;
    }
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        User existing = userRepository.findByEmail(user.getEmail());
        if (existing != null) {
            return "Email already registered!";
        }

        userRepository.save(user);
        return "Signup Successful! Welcome " + user.getName();
    }

}