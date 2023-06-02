package io.reactivestax.service;

import io.reactivestax.entity.Book;
import io.reactivestax.repository.BookRepository;
import io.reactivestax.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    Logger logger = LogManager.getLogger(BookService.class);
    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        logger.info("***** BookService:addBook execution started *****");
        logger.info("***** BookService:addBook request payload :{}  *****", Mapper.mapToJsonString(book));
        logger.info("***** BookService:addBook request ended  *****");
        return bookRepository.save(book);

    }

    public List<Book> getBooks() {
        logger.info("***** BookService:getBooks execution started *****");
        List<Book> bookList =  bookRepository.findAll();
        logger.info("***** BookService:getBooks request payload :{}  *****", Mapper.mapToJsonString(bookList));
        logger.info("***** BookService:getBooks execution ended *****");
        return bookList;
    }

    public Optional<Book> getBookById(Integer id) {
        logger.info("***** BookService:getBookById execution started *****");
        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new RuntimeException("Book not found : " + id);
        }
        logger.info("***** BookService:getBooks request payload :{}  *****", Mapper.mapToJsonString(book));
        logger.info("***** BookService:getBookById execution ended *****");
        return bookRepository.findById(id);
    }
}
