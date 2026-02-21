package model;

import java.util.LinkedList;
import java.util.Queue;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available=true;

    private Queue<Patron> reservationQueue=new LinkedList<>();


    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
    
    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public int getYear() {
        return this.year;
    }
    public Queue<Patron> getReservationQueue() {
        return reservationQueue;
    }

    public void update(String title,String author,int year){
        this.title=title;
        this.author=author;
        this.year=year;
    }

        @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

}
