package strategy;

import java.util.*;
import java.util.stream.Collectors;

import model.Book;

public class AuthorSearch implements SearchStrategy {
    
    @Override
    public List<Book> search(List<Book> books, String author) {
        return books.stream().filter(b->b.getAuthor().toLowerCase().contains(author.toLowerCase())).collect(Collectors.toList());
    }
    
}
