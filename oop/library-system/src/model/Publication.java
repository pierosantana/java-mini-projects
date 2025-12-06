package model;

public abstract class Publication  {

    private final String title;
    private final String author;

    public Publication(String author, String title) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }

        this.author = author;
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
