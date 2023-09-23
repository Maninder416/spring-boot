package io.reactivestax.springmongo.service;


import io.reactivestax.springmongo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService  {

     Page<Book> search(String bookName, String author,
                             int year, double price,
                             Pageable pageable);



}
