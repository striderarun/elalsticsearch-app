package com.arun.app.service;


import com.arun.app.beans.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchService {

    void indexBook(Book book);

    Page<Book> findByAuthor(String author, Pageable pageable);
}
