package model;

public class Book extends Publication{
private final String isbn;
private boolean loaned;


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

    public boolean isLoaned() {
        return loaned;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }
}
