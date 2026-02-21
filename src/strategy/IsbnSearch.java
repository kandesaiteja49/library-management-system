package strategy;

import java.util.List;
import java.util.stream.Collectors;

import model.Book;

public class IsbnSearch implements SearchStrategy {

    @Override
    public List<Book> search(List<Book> books, String isbn) {
        return books.stream().filter(b->b.getIsbn().equalsIgnoreCase(isbn)).collect(Collectors.toList());
    }
    
}
