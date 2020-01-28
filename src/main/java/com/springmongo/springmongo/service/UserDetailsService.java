package com.springmongo.springmongo.service;

import com.springmongo.springmongo.dao.UserDetailsRepository;
import com.springmongo.springmongo.exception.ResourceNotFoundException;
import com.springmongo.springmongo.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserDetailsService implements UserDetailsInterface {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public List<UserDetails> getAllUsers() {
        try {
            return userDetailsRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error occurred while fetching the user details " + ex);
            return null;
        }
    }

    @Override
    public ResponseEntity<UserDetails> getUserById(String id) throws ResourceNotFoundException {
        UserDetails userDetails = userDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(userDetails);
    }

    @Override
    public String addUser(UserDetails userDetails) {
        try {
            String userId = UUID.randomUUID().toString();
            userDetails.setUserId(userId);
            userDetailsRepository.save(userDetails);
            return userId;
        } catch (Exception ex) {
            System.out.println("Error occurred while adding the user " + ex);
            return null;
        }
    }
}
