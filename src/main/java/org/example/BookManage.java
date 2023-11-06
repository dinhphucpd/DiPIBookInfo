package org.example;

import java.util.ArrayList;
import java.util.List;

public class BookManage {

    public BookManage() {
    }

    public List<Book> getAllBooks(BookDataType dataType) {
        return BookDataFactory.getBookData(dataType).getBookData();
    }

    public void displayBook(List<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book);
        }
    }


    public List<Book> searchByIsbn(List<Book> bookList, String search) {
        List<Book> foundBookList = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getIsbn().contains(search)) {
                foundBookList.add(book);
            }
        }
        return foundBookList;
    }


    public List<Book> searchByTitle(List<Book> bookList, String search) {
        List<Book> foundBookList = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getTitle().contains(search)) {
                foundBookList.add(book);
            }
        }
        return foundBookList;
    }


    public List<Book> searchByAuthor(List<Book> bookList, String search) {
        List<Book> foundBookList = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getAuthors().contains(search)) {
                foundBookList.add(book);
            }
        }
        return foundBookList;
    }


    public List<Book> sortByRatingAsc(List<Book> bookList) {
        for (int i = 0; i < bookList.size() - 1; ++i) {
            for (int j = i + 1; j < bookList.size(); ++j) {
                if (bookList.get(i).getRating() > bookList.get(j).getRating()) {
                    Book temp = bookList.get(i);
                    bookList.set(i, bookList.get(j));
                    bookList.set(j, temp);
                }
            }
        }
        return bookList;
    }

    public List<Book> getTopRatedBook(List<Book> bookList, int count) {
        for (int i = 0; i < bookList.size() - 1; ++i) {
            for (int j = i + 1; j < bookList.size(); ++j) {
                if (bookList.get(i).getRating() < bookList.get(j).getRating()) {
                    Book temp = bookList.get(i);
                    bookList.set(i, bookList.get(j));
                    bookList.set(j, temp);
                }
            }
        }

        List<Book> topRatedBookList = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            topRatedBookList.add(bookList.get(i));
        }
        return topRatedBookList;
    }
}
