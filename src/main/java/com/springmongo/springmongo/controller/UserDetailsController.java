package com.springmongo.springmongo.controller;

import com.springmongo.springmongo.exception.ResourceNotFoundException;
import com.springmongo.springmongo.model.UserDetails;
import com.springmongo.springmongo.service.UserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDetailsController {

    final
    UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDetails userDetails) {
        return userDetailsService.addUser(userDetails);
    }

    @GetMapping("/getUser")
    public ResponseEntity<UserDetails> getUserById(@RequestParam(name = "userId") String userId) throws ResourceNotFoundException {
        return userDetailsService.getUserById(userId);
    }

    @GetMapping("/getAllUsers")
    public List<UserDetails> getAllUsers() {
        return userDetailsService.getAllUsers();
    }
}
