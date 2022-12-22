package com.bookstore.BookStore.dao;

import com.bookstore.BookStore.model.Book;

import java.util.List;

public interface BookDao {
    int insertBook(Book book);
    List<Book> selectAllBooks();
}
