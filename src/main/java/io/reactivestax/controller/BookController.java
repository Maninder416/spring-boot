package io.reactivestax.controller;

import io.reactivestax.entity.Book;
import io.reactivestax.repository.BookRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Value("${spring.statement}")
    private String statement;

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
    public Book findBook(@PathVariable int id){
        Book book= bookRepository.findById(id).orElseThrow(()-> new Exception("Book not found"));
        return book;
    }

    @GetMapping("/test")
    public String test(){
        return statement;
    }


}
