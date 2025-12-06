package model;

public class Magazine extends Publication {

    private final int issueNumber;


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
}
