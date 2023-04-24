package io.reactivestax.controller;

import io.reactivestax.entity.Book;
import io.reactivestax.repository.BookRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<Book> findBooks(){
        return bookRepository.findAll();
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public Book findBook(@PathVariable int id) throws Exception {
        Book book= bookRepository.findById(id).orElseThrow(()-> new Exception("Book not found"));
        return book;
    }


}