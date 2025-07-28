package com.example.demo.mytest.mybean;

import org.springframework.stereotype.Component;

//@Component
public class Book {
    private String bookName;
    private String bookType;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
