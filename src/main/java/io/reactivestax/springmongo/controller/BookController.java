package io.reactivestax.springmongo.controller;

import io.reactivestax.springmongo.model.Book;
import io.reactivestax.springmongo.repository.BookRepository;
import io.reactivestax.springmongo.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookServiceImp bookServiceImp;

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

    @GetMapping("/search")
    public Page<Book> searchBook(
            @RequestParam(required = false) String bookName,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Double price,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ){
        Pageable pageable = PageRequest.of(page,size);
        return bookServiceImp.search(bookName,author,year,price,pageable);

    }


}
