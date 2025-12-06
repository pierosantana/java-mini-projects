package model;

import exceptions.ResourceNotAvailableException;
import loan.Loanable;

public class Magazine extends Publication implements Loanable {

    private final int issueNumber;
    private boolean loaned;


    public Magazine(String author, String title, int issueNumber) {
        super(author, title);

        if(issueNumber < 1) {
            throw new IllegalArgumentException();
        }
        this.issueNumber = issueNumber;
    }

    public Integer getIssueNumber() {
        return issueNumber;
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
            throw new ResourceNotAvailableException("The magazine has already been loaned");
        }
        setLoaned(true);
    }
    @Override
    public void returnResource() {
        setLoaned(false);
    }
}
