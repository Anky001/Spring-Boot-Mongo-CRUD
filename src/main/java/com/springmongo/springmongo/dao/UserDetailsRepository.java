package com.springmongo.springmongo.dao;

import com.springmongo.springmongo.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {
}
