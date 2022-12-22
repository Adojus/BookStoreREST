package com.bookstore.BookStore.dao;

import com.bookstore.BookStore.model.AntiqueBook;
import com.bookstore.BookStore.model.Book;
import com.bookstore.BookStore.model.ScienceJournal;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ScienceJournalDao {

    int insertBook(ScienceJournal book);

    List<ScienceJournal> selectAllBooks();

    Optional<ScienceJournal> selectBookByBarcode(String barcode);

    int updateBookByBarcode(String barcode, ScienceJournal book);

    Optional<ScienceJournal> calculateTotalPrice(String barcode);

    Map<Integer,List<ScienceJournal>> selectAllBooksGrouped();
}
