package com.springmongo.springmongo.controller;

import com.springmongo.springmongo.exception.ResourceNotFoundException;
import com.springmongo.springmongo.model.BookModel;
import com.springmongo.springmongo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class BookController {

    final
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public String saveBook(@Valid @RequestBody BookModel bookModel, HttpServletResponse response) {
        bookModel.setId(UUID.randomUUID().toString());
        Boolean res = bookService.addBook(bookModel);
        if (res) {
            response.setStatus(HttpServletResponse.SC_CREATED);
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return "Book added with id:" + bookModel.getId();
    }

    @GetMapping("/findAllBooks")
    public List<BookModel> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/findAllBooks/{id}")
    public ResponseEntity<BookModel> getBook(@PathVariable String id) throws ResourceNotFoundException {
        return bookService.getBook(id);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<String> getBook(@PathVariable String id, @Valid @RequestBody BookModel updatedBookModel) throws ResourceNotFoundException {
        return bookService.updateBook(id, updatedBookModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) throws ResourceNotFoundException {
        return bookService.deleteBook(id);
    }

    @GetMapping("/findByAuthorName")
    public BookModel findByAuthorName(@RequestParam(name = "authorName") String authorName) throws ResourceNotFoundException {
        return bookService.findByAuthorName(authorName);
    }
}
