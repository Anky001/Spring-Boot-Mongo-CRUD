package com.springmongo.springmongo.dao;

import com.springmongo.springmongo.model.BookModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<BookModel, String> {

    Optional<BookModel> findByAuthorName(String authorName);
}
