package com.bookstore.BookStore.service;

import com.bookstore.BookStore.dao.AntiqueBookDao;
import com.bookstore.BookStore.model.AntiqueBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AntiqueBookService {
    private final AntiqueBookDao bookDao;

    @Autowired
    public AntiqueBookService(@Qualifier("fakeAntiqueDao") AntiqueBookDao bookDao) {
        this.bookDao = bookDao;
    }

    public int addBook(AntiqueBook book){
        return bookDao.insertBook(book);
    }

    public List<AntiqueBook> getAllBooks(){
        return bookDao.selectAllBooks();
    }

    public Optional<AntiqueBook> getBookByBarcode(String barcode){
        return bookDao.selectBookByBarcode(barcode);
    }

    public int updateBook(String barcode, AntiqueBook newBook){
        return bookDao.updateBookByBarcode(barcode, newBook);
    }

    public Optional<AntiqueBook> getPriceByBarcode(String barcode){
        return bookDao.calculateTotalPrice(barcode);
    }

    public Map<Integer, List<AntiqueBook>> getAllBooksGrouped(){
        return bookDao.selectAllBooksGrouped();
    }
}
