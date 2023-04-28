package io.reactivestax.controller;

import io.reactivestax.entity.Book;
import io.reactivestax.repository.BookRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @SneakyThrows
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Book findBook(@PathVariable int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found"));
        return book;
    }

    @GetMapping("/home")
    public String getHome() {
        return "Hello Team";
    }


}
