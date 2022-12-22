package com.bookstore.BookStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Year;

public class AntiqueBook extends Book{


    private final int year;
    public AntiqueBook(String name, String author,
                       String barcode, int quantity, double price,
                       @JsonProperty("year") int year) {
        super(name, author, barcode, quantity, price);
        if(year > 1900) throw new IllegalArgumentException();
        this.year = year;
    }
    public int getYear() {
        return year;
    }
    @Override
    public double calculateTotalPrice(){

        return (double)Math.round((price*quantity*(Year.now().getValue()-year)/10)*100)/100;
    }
}
