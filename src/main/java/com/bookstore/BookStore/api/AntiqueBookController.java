package com.bookstore.BookStore.api;

import com.bookstore.BookStore.model.AntiqueBook;
import com.bookstore.BookStore.model.Book;
import com.bookstore.BookStore.service.AntiqueBookService;
import com.bookstore.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("antiqueBooks")
@RestController
public class AntiqueBookController {
    private final AntiqueBookService bookService;

    @Autowired
    public AntiqueBookController(AntiqueBookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody AntiqueBook book){
        bookService.addBook(book);
    }

    @GetMapping
    public List<AntiqueBook> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{barcode}")
    public AntiqueBook getBookByBarcode(@PathVariable("barcode") String barcode){
        return bookService.getBookByBarcode(barcode)
                .orElse(null);
    }

    @PutMapping(path = "{barcode}")
    public void updateBook(@PathVariable("barcode") String barcode, @RequestBody AntiqueBook bookToUpdate){
        bookService.updateBook(barcode, bookToUpdate);
    }

    @GetMapping(path = "{barcode}/totalPrice")
    public double getTotalPriceByBarcode(@PathVariable("barcode") String barcode){
        return bookService.getPriceByBarcode(barcode)
                .orElse(null).calculateTotalPrice();
    }

    @GetMapping(path = "grouped")
    public Map<Integer, List<AntiqueBook>> getAllBooksGrouped(){
        return bookService.getAllBooksGrouped();
    }
}
