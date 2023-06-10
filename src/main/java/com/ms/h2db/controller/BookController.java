package com.ms.h2db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.h2db.entity.Book;
import com.ms.h2db.repo.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
    private BookRepository bookRepository;


    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public List<Book> createBook(@RequestBody List<Book> books) {
        return bookRepository.saveAll(books);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) throws Exception {
        return bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Book not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) throws Exception {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new Exception("Book not found with id: " + id));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());

        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}

