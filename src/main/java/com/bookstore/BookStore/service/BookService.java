package com.bookstore.BookStore.service;

import com.bookstore.BookStore.dao.BookDao;
import com.bookstore.BookStore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("fakeDao") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int addBook(Book book){
        return bookDao.insertBook(book);
    }

    public List<Book> getAllBooks(){
        return bookDao.selectAllBooks();
    }

    public Optional<Book> getBookByBarcode(String barcode){
        return bookDao.selectBookByBarcode(barcode);
    }

    public int updateBook(String barcode, Book newBook){
        return bookDao.updateBookByBarcode(barcode, newBook);
    }

    public Optional<Book> getPriceByBarcode(String barcode){
        return bookDao.calculateTotalPrice(barcode);
    }
}
