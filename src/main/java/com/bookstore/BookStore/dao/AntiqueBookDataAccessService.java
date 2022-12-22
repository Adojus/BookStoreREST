package com.bookstore.BookStore.dao;

import com.bookstore.BookStore.model.AntiqueBook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("fakeAntiqueDao")
public class AntiqueBookDataAccessService implements AntiqueBookDao{

    private static List<AntiqueBook> DB = new ArrayList<>();

    @Override
    public int insertBook(AntiqueBook book) {
        DB.add(new AntiqueBook(book.getName(), book.getAuthor(), book.getBarcode(),
                book.getQuantity(), book.getPrice(), book.getYear()));
        return 1;
    }

    @Override
    public List<AntiqueBook> selectAllBooks() {
        return DB;
    }

    @Override
    public Optional<AntiqueBook> selectBookByBarcode(String barcode) {
        return DB.stream()
                .filter(book -> book.getBarcode().equals(barcode))
                .findFirst();
    }

    @Override
    public int updateBookByBarcode(String barcode, AntiqueBook updateBook) {
        return selectBookByBarcode(barcode)
                .map(b -> {
                    int indexOfBookToUpdate = DB.indexOf(b);
                    if(indexOfBookToUpdate >= 0){
                        DB.set(indexOfBookToUpdate, new AntiqueBook(updateBook.getName(),
                                updateBook.getAuthor(), barcode, updateBook.getQuantity(),
                                updateBook.getPrice(), updateBook.getYear()) );
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<AntiqueBook> calculateTotalPrice(String barcode) {
        return DB.stream()
                .filter(book -> book.getBarcode().equals(barcode))
                .findFirst();
    }

    @Override
    public Map<Integer, List<AntiqueBook>> selectAllBooksGrouped() {
        Map<Integer, List<AntiqueBook>> mapByQuantity =
                DB.stream().collect(Collectors.groupingBy(AntiqueBook::getQuantity));
        return mapByQuantity;
    }
}
