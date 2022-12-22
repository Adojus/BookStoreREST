package com.bookstore.BookStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Year;

public class ScienceJournal extends Book{


    private final int scienceIndex;
    public ScienceJournal(String name, String author,
                       String barcode, int quantity, double price,
                       @JsonProperty("scienceIndex") int scienceIndex) {
        super(name, author, barcode, quantity, price);
        if(scienceIndex > 10 || scienceIndex <1) throw new IllegalArgumentException();
        this.scienceIndex = scienceIndex;
    }
    public int getYear() {
        return scienceIndex;
    }
    @Override
    public double calculateTotalPrice(){

        return (double)Math.round((price*quantity*scienceIndex)*100)/100;
    }
}
