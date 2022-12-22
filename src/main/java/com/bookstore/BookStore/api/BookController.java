package com.bookstore.BookStore.api;

import com.bookstore.BookStore.model.Book;
import com.bookstore.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/book")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{barcode}")
    public Book getBookByBarcode(@PathVariable("barcode") String barcode){
        return bookService.getBookByBarcode(barcode)
                .orElse(null);
    }

    @PutMapping(path = "{barcode}")
    public void updateBook(@PathVariable("barcode") String barcode, @RequestBody Book bookToUpdate){
        bookService.updateBook(barcode, bookToUpdate);
    }
}
