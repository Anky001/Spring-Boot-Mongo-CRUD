package com.springmongo.springmongo.service;

import com.springmongo.springmongo.exception.ResourceNotFoundException;
import com.springmongo.springmongo.model.UserDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserDetailsInterface {

    public List<UserDetails> getAllUsers();
    public ResponseEntity<UserDetails> getUserById(String id) throws ResourceNotFoundException;
    public String addUser(UserDetails userDetails);
}
