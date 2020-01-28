package com.springmongo.springmongo.service;

import com.springmongo.springmongo.exception.ResourceNotFoundException;
import com.springmongo.springmongo.model.BookModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookServiceInterface {
    Boolean addBook(BookModel bookModel);

    List<BookModel> getAllBooks() throws ResourceNotFoundException;

    ResponseEntity<BookModel> getBook(String id) throws ResourceNotFoundException;

    ResponseEntity<String> updateBook(String id, BookModel updatedBookModel) throws ResourceNotFoundException;

    ResponseEntity<String> deleteBook(String id) throws ResourceNotFoundException;

    BookModel findByAuthorName(String authorName) throws ResourceNotFoundException;
}
