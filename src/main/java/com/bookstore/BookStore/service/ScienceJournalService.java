package com.bookstore.BookStore.service;

import com.bookstore.BookStore.dao.AntiqueBookDao;
import com.bookstore.BookStore.dao.ScienceJournalDao;
import com.bookstore.BookStore.model.AntiqueBook;
import com.bookstore.BookStore.model.ScienceJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ScienceJournalService {
    private final ScienceJournalDao bookDao;

    @Autowired
    public ScienceJournalService(@Qualifier("fakeScienceDao") ScienceJournalDao bookDao) {
        this.bookDao = bookDao;
    }

    public int addBook(ScienceJournal book){
        return bookDao.insertBook(book);
    }

    public List<ScienceJournal> getAllBooks(){
        return bookDao.selectAllBooks();
    }

    public Optional<ScienceJournal> getBookByBarcode(String barcode){
        return bookDao.selectBookByBarcode(barcode);
    }

    public int updateBook(String barcode, ScienceJournal newBook){
        return bookDao.updateBookByBarcode(barcode, newBook);
    }

    public Optional<ScienceJournal> getPriceByBarcode(String barcode){
        return bookDao.calculateTotalPrice(barcode);
    }

    public Map<Integer, List<ScienceJournal>> getAllBooksGrouped(){
        return bookDao.selectAllBooksGrouped();
    }
}
