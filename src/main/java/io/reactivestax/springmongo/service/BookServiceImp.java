package io.reactivestax.springmongo.service;

import io.reactivestax.springmongo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page<Book> search(String name, String author, int year, double price, Pageable pageable) {
        Query query = new Query().with(pageable);
        List<Criteria> criteria = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            criteria.add(Criteria.where("bookName").regex(name, "i"));
        }

        if (author != null && !author.isEmpty()) {
            criteria.add(Criteria.where("authorName").is(author));
        }

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria()
                    .andOperator(criteria.toArray(new Criteria[0]))
            );
        }

        Page<Book> books = PageableExecutionUtils.getPage(
                mongoTemplate.find(query, Book.class), pageable, () -> mongoTemplate
                        .count(query.skip(0).limit(0), Book.class));

        return books;
    }
}
