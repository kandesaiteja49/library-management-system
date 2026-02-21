package Service;

import java.util.*;
import java.util.logging.Logger;

import model.Book;
import model.Loan;
import model.Patron;
import observer.ReservationSubject;
import strategy.SearchStrategy;

public class LibraryService {
    private static final Logger log = Logger.getLogger("Library");

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Patron> patrons = new HashMap<>();
    private Map<String, Loan> loans = new HashMap<>();

    private ReservationSubject notifier = new ReservationSubject();

    // ---------- BOOK ----------
    public void addBook(Book b) {
        books.put(b.getIsbn(), b);
        log.info("Added " + b);
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public void updateBook(String isbn, String t, String a, int y) {
        books.get(isbn).update(t, a, y);
    }

    public List<Book> search(SearchStrategy s, String key) {
        return s.search(new ArrayList<>(books.values()), key);
    }

    // ---------- PATRON ----------
    public void addPatron(Patron p) {
        patrons.put(p.getId(), p);
        notifier.addObserver(p);
    }

    // ---------- CHECKOUT ----------
    public void checkout(String isbn, String patronId) {
        Book b = books.get(isbn);
        Patron p = patrons.get(patronId);

        if (b == null || p == null) throw new RuntimeException("Invalid");

        if (!b.isAvailable()) {
            b.getReservationQueue().add(p);
            log.info("Added to reservation queue: " + p.getName());
            return;
        }

        b.setAvailable(false);
        loans.put(isbn, new Loan(b, p));
        p.addHistory(b);
        log.info("Checked out to " + p.getName());
    }

    // ---------- RETURN ----------
    public void returnBook(String isbn) {
        Loan loan = loans.remove(isbn);
        if (loan == null) return;

        Book b = loan.getBook();

        if (!b.getReservationQueue().isEmpty()) {
            Patron next = b.getReservationQueue().poll();
            loans.put(isbn, new Loan(b, next));
            next.addHistory(b);
            notifier.notifyObservers("Reserved book ready: " + b.getTitle());
            log.info("Auto-issued to reserved patron");
        } else {
            b.setAvailable(true);
        }
    }

    public List<Book> availableBooks() {
        return books.values().stream()
                .filter(Book::isAvailable)
                .toList();
    }
}
