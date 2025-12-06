import model.Book;
import model.Magazine;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Book book = new Book("Isaac Asimov", "El fin de la eternidad", "9788497933537");
        Magazine magazine = new Magazine("Forbes", "Actualidad y Negocios", 67);

        System.out.println("Books is loaned?: " + book.isLoaned());
        System.out.println("Magazine is loaned?: " + magazine.isLoaned());

        book.loan();
        magazine.loan();

        System.out.println("---------------------------------");
        System.out.println("Books is loaned?: " + book.isLoaned());
        System.out.println("Magazine is loaned?: " + magazine.isLoaned());

        System.out.println("---------------------------------");
        System.out.println("Exception:");
        book.loan();
        
    }
}