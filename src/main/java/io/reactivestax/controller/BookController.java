package io.reactivestax.controller;

import io.reactivestax.entity.Book;
import io.reactivestax.repository.BookRepository;
import io.reactivestax.service.BookService;
import io.reactivestax.util.Mapper;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    Logger logger = LogManager.getLogger(BookController.class);

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        logger.info("***** BookController:saveBook request payload :{}  *****", Mapper.mapToJsonString(book));
        Book book1 = bookService.addBook(book);
        logger.info("***** BookController:saveBook response payload :{}  *****", Mapper.mapToJsonString(book1));
        return book1;
    }

    @GetMapping("/books")
    public List<Book> findBooks() {
        List<Book> books = bookService.getBooks();
        logger.info("***** BookController:findBooks request payload :{}  *****", Mapper.mapToJsonString(books));
        return books;
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public Book findBook(@PathVariable int id) {
        Optional<Book> bookById = bookService.getBookById(id);
        logger.info("***** BookController:findBookById request payload :{}  *****", Mapper.mapToJsonString(bookById));
        return bookById.orElseThrow(() -> new Exception("Book not found"));
    }


}
