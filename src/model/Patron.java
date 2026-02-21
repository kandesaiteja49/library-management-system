package model;

import java.util.ArrayList;
import java.util.List;

import observer.Observer;

public class Patron implements Observer {
    private String id;
    private String name;
    private List<Book> history=new ArrayList<>();


    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void addHistory(Book book) {
        this.history.add(book);
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return history;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for "+this.name+": "+message);
    }


    public boolean isBookReturned(Book book) {
        return history.contains(book);
    }

    @Override
    public String toString() {
        return "Patron{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
