package io.reactivestax.springmongo.repository;

import io.reactivestax.springmongo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
