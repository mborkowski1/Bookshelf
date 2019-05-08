package com.example.bookshelf.service;

import com.example.bookshelf.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book saveBook(Book book);

}
