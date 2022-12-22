package com.bookstore.BookStore.dao;

import com.bookstore.BookStore.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    int insertBook(Book book);

    List<Book> selectAllBooks();

    Optional<Book> selectBookByBarcode(String barcode);

    int updateBookByBarcode(String barcode, Book book);

    Optional<Book> calculateTotalPrice(String barcode);
}
