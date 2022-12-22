package com.bookstore.BookStore.service;

import com.bookstore.BookStore.dao.BookDao;
import com.bookstore.BookStore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
