package com.example.libraryapplication;

public class Book {
    private String card_title, book_author;
    private int book_cover;

    public Book(String card_title, String book_author, int book_cover) {
        this.card_title = card_title;
        this.book_author = book_author;
        this.book_cover = book_cover;
    }

    public String getCard_title() {
        return card_title;
    }

    public void setCard_title(String card_title) {
        this.card_title = card_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public int getBook_cover() {
        return book_cover;
    }

    public void setBook_cover(int book_cover) {
        this.book_cover = book_cover;
    }
}
