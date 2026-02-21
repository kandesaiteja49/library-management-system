package strategy;

import java.util.List;

import model.Book;

public interface SearchStrategy {
    List<Book> search(List<Book> books,String title);
}
