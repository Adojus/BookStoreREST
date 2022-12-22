package com.bookstore.BookStore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    private final String name;
    private final String author;
    private final String barcode;
    private final int quantity;
    private final double price;

    public Book(@JsonProperty("name") String name,
                @JsonProperty("author") String author,
                @JsonProperty("barcode") String barcode,
                @JsonProperty("quantity") int quantity,
                @JsonProperty("price") double price) {
        this.name = name;
        this.author = author;
        this.barcode = barcode;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
