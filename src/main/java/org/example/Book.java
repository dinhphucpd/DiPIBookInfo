package org.example;

public class Book {
    private String isbn;
    private String title;
    private String authors;
    private double rating;
    private int year;
    private String language;

    public Book(String isbn, String title, String authors, double rating, int year, String language) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.rating = rating;
        this.year = year;
        this.language = language;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Book {" +
                "isbn = " + isbn +
                " | title = " + title +
                " | authors = " + authors +
                " | rating = " + rating +
                " | year = " + year +
                " | language = " + language +
                '}';
    }
}
