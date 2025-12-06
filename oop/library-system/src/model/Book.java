package model;

import exceptions.ResourceNotAvailableException;
import loan.Loanable;

public class Book extends Publication implements Loanable {
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

    private void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    @Override
    public void loan() {
        if(isLoaned()) {
            throw new ResourceNotAvailableException("The book has already been loaned");
        }
        setLoaned(true);
    }

    @Override
    public void returnResource() {

        setLoaned(false);
    }
}
