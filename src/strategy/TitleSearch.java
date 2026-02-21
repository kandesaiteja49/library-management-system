package strategy;

import java.util.List;
import java.util.stream.Collectors;

import model.Book;

public class TitleSearch implements SearchStrategy {

    @Override
    public List<Book> search(List<Book> books,String title) {
        // TODO Auto-generated method stub
       return books.stream().filter(b->b.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList());
    } 
    
}
