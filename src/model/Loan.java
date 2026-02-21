package model;

import java.time.LocalDate;

public class Loan {
    private Book book;
    private Patron patron;
    private LocalDate issueDate;
    public Loan(Book book, Patron patron) {
        this.book = book;
        this.patron = patron;
        this.issueDate = LocalDate.now();
    }
    public Book getBook() {
        return book;
    }
    public Patron getPatron() {
        return patron;
    }
    public LocalDate getIssueDate() {
        return issueDate;
    } 
    
}
