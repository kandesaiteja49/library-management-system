import Service.LibraryService;
import factory.BookFactory;
import model.Book;
import model.Patron;
import strategy.TitleSearch;

public class App {
    public static void main(String[] args)  {
       LibraryService lib = new LibraryService();

        Book b1 = BookFactory.createBook("101","Clean Code","Martin",2008);
        Book b2 = BookFactory.createBook("102","Effective Java","Bloch",2018);

        lib.addBook(b1);
        lib.addBook(b2);

        Patron p1 = new Patron("P1","Alice");
        Patron p2 = new Patron("P2","Bob");

        lib.addPatron(p1);
        lib.addPatron(p2);

        lib.checkout("101","P1");
        lib.checkout("101","P2"); // goes to reservation queue

        lib.returnBook("101"); // auto-assign to Bob + notify

        System.out.println(lib.search(new TitleSearch(),"clean"));
    }
    
}
