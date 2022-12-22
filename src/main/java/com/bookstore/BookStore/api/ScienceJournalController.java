package com.bookstore.BookStore.api;

import com.bookstore.BookStore.model.AntiqueBook;
import com.bookstore.BookStore.model.ScienceJournal;
import com.bookstore.BookStore.service.AntiqueBookService;
import com.bookstore.BookStore.service.ScienceJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("scienceJournals")
@RestController
public class ScienceJournalController {
    private final ScienceJournalService bookService;

    @Autowired
    public ScienceJournalController(ScienceJournalService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody ScienceJournal book){
        bookService.addBook(book);
    }

    @GetMapping
    public List<ScienceJournal> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{barcode}")
    public ScienceJournal getBookByBarcode(@PathVariable("barcode") String barcode){
        return bookService.getBookByBarcode(barcode)
                .orElse(null);
    }

    @PutMapping(path = "{barcode}")
    public void updateBook(@PathVariable("barcode") String barcode, @RequestBody ScienceJournal bookToUpdate){
        bookService.updateBook(barcode, bookToUpdate);
    }

    @GetMapping(path = "{barcode}/totalPrice")
    public double getTotalPriceByBarcode(@PathVariable("barcode") String barcode){
        return bookService.getPriceByBarcode(barcode)
                .orElse(null).calculateTotalPrice();
    }

    @GetMapping(path = "grouped")
    public Map<Integer, List<ScienceJournal>> getAllBooksGrouped(){
        return bookService.getAllBooksGrouped();
    }
}
