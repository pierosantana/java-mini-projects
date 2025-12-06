package model;

public class Book extends Publication{
private final String isbn;


    public Book(String author, String title, String isbn) {
        super(author, title);
        if(isbn == null ||
                isbn.length() != 13 ||
                !isbn.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException();
        }
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
