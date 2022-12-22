package com.bookstore.BookStore.dao;

import com.bookstore.BookStore.model.AntiqueBook;
import com.bookstore.BookStore.model.ScienceJournal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("fakeScienceDao")
public class ScienceJournalDataAccessService implements ScienceJournalDao{

    private static List<ScienceJournal> DB = new ArrayList<>();

    @Override
    public int insertBook(ScienceJournal book) {
        DB.add(new ScienceJournal(book.getName(), book.getAuthor(), book.getBarcode(),
                book.getQuantity(), book.getPrice(), book.getYear()));
        return 1;
    }

    @Override
    public List<ScienceJournal> selectAllBooks() {
        return DB;
    }

    @Override
    public Optional<ScienceJournal> selectBookByBarcode(String barcode) {
        return DB.stream()
                .filter(book -> book.getBarcode().equals(barcode))
                .findFirst();
    }

    @Override
    public int updateBookByBarcode(String barcode, ScienceJournal updateBook) {
        return selectBookByBarcode(barcode)
                .map(b -> {
                    int indexOfBookToUpdate = DB.indexOf(b);
                    if(indexOfBookToUpdate >= 0){
                        DB.set(indexOfBookToUpdate, new ScienceJournal(updateBook.getName(),
                                updateBook.getAuthor(), barcode, updateBook.getQuantity(),
                                updateBook.getPrice(), updateBook.getYear()) );
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<ScienceJournal> calculateTotalPrice(String barcode) {
        return DB.stream()
                .filter(book -> book.getBarcode().equals(barcode))
                .findFirst();
    }

    @Override
    public Map<Integer, List<ScienceJournal>> selectAllBooksGrouped() {
        Map<Integer, List<ScienceJournal>> mapByQuantity =
                DB.stream().collect(Collectors.groupingBy(ScienceJournal::getQuantity));
        return mapByQuantity;
    }
}
