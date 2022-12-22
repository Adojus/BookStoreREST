package com.bookstore.BookStore.dao;

import com.bookstore.BookStore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakeDao")
public class FakeBookDataAccessService implements BookDao {

    private static List<Book> DB = new ArrayList<>();
    @Override
    public int insertBook(Book book) {
        DB.add(new Book(book.getName(), book.getAuthor(), book.getBarcode(),
                 book.getQuantity(), book.getPrice()));
        return 1;
    }

    @Override
    public List<Book> selectAllBooks() {
        return DB;
    }
}
