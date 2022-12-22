package com.bookstore.BookStore.dao;

import com.bookstore.BookStore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public Optional<Book> selectBookByBarcode(String barcode) {
        return DB.stream()
                .filter(book -> book.getBarcode().equals(barcode))
                .findFirst();
    }

    @Override
    public int updateBookByBarcode(String barcode, Book updateBook) {
        return selectBookByBarcode(barcode)
                .map(b -> {
                    int indexOfBookToUpdate = DB.indexOf(b);
                    if(indexOfBookToUpdate >= 0){
                        DB.set(indexOfBookToUpdate, new Book(updateBook.getName(),
                                updateBook.getAuthor(), barcode, updateBook.getQuantity(),
                                updateBook.getPrice()) );
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Book> calculateTotalPrice(String barcode) {
        return DB.stream()
                .filter(book -> book.getBarcode().equals(barcode))
                .findFirst();
    }

    @Override
    public Map<Integer, List<Book>> selectAllBooksGrouped() {
        Map<Integer, List<Book>> mapByQuantity =
                DB.stream().collect(Collectors.groupingBy(Book::getQuantity));
        return mapByQuantity;
    }
}
