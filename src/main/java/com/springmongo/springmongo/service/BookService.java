package com.springmongo.springmongo.service;

import com.springmongo.springmongo.dao.BookRepository;
import com.springmongo.springmongo.exception.ResourceNotFoundException;
import com.springmongo.springmongo.model.BookModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BookService implements BookServiceInterface {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Boolean addBook(BookModel bookModel) {
        try {
            repository.save(bookModel);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public List<BookModel> getAllBooks() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ResponseEntity<BookModel> getBook(@PathVariable String id) throws ResourceNotFoundException {
        try {
            BookModel bookModel = repository.findById(id)
                    .orElseThrow(() -> {
                        return new ResourceNotFoundException("Book not found with id::" + id);
                    });
            return ResponseEntity.ok().body(bookModel);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(null);
        }


    }

    public ResponseEntity<String> updateBook(@PathVariable String id, @RequestBody BookModel updatedBookModel) throws ResourceNotFoundException {
        BookModel theModel = repository.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Book not found with id::" + id);
                });
        try {
            theModel.setId(id);
            theModel.setBookName(updatedBookModel.getBookName());
            theModel.setAuthorName(updatedBookModel.getAuthorName());
            repository.save(theModel);
            return ResponseEntity.ok().body("Book updated: " + id);
        } catch (Exception ex) {
            System.out.println(ex);
            return ResponseEntity.badRequest().body("Book updated failed " + id);
        }
    }

    public ResponseEntity<String> deleteBook(@PathVariable String id) throws ResourceNotFoundException {
        repository.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Book not found with id::" + id);
                });
        repository.deleteById(id);
        return ResponseEntity.ok().body("Book deleted by id: " + id);
    }

    public BookModel findByAuthorName(@RequestParam(name = "authorName") String authorName) throws ResourceNotFoundException {
        return repository.findByAuthorName(authorName)
                .orElseThrow(() -> new ResourceNotFoundException("Book with Author id::" + authorName + " not found"));
    }

}
