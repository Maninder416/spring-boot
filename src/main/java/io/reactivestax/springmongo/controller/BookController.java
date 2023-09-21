package io.reactivestax.springmongo.controller;

import io.reactivestax.springmongo.model.Book;
import io.reactivestax.springmongo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    public String saveBook(@RequestBody Book book){
        bookRepository.save(book);
        return "Added book successfully";
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findBookById(@PathVariable String id){
        return bookRepository.findById(id);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable String id){
        bookRepository.deleteById(id);
        return "Book deleted with id : "+id;
    }


}
