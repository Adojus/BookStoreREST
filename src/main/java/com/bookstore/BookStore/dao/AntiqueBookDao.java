package com.bookstore.BookStore.dao;

import com.bookstore.BookStore.model.AntiqueBook;
import com.bookstore.BookStore.model.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AntiqueBookDao {

    int insertBook(AntiqueBook book);

    List<AntiqueBook> selectAllBooks();

    Optional<AntiqueBook> selectBookByBarcode(String barcode);

    int updateBookByBarcode(String barcode, AntiqueBook book);

    Optional<AntiqueBook> calculateTotalPrice(String barcode);

    Map<Integer,List<AntiqueBook>> selectAllBooksGrouped();
}
