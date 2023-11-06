package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookManageTest {

    @Test
    void testGetAllBooks() {
        BookManage bookManage = new BookManage();
        List<Book> bookList = bookManage.getAllBooks(BookDataType.CSV);
        assertFalse(bookList.isEmpty());
    }

    @Test
    void testSearchByIsbn() {
        BookManage bookManage = new BookManage();
        List<Book> bookList = bookManage.getAllBooks(BookDataType.CSV);
        List<Book> result = bookManage.searchByIsbn(bookList, "743273567");
        assertEquals(1, result.size());
    }

    @Test
    void testSearchByTitle() {
        BookManage bookManage = new BookManage();
        List<Book> bookList = bookManage.getAllBooks(BookDataType.CSV);
        List<Book> result = bookManage.searchByTitle(bookList, "Harry");
        assertEquals(7, result.size());
    }

    @Test
    void testSearchByAuthor() {
        BookManage bookManage = new BookManage();
        List<Book> bookList = bookManage.getAllBooks(BookDataType.CSV);
        List<Book> result = bookManage.searchByAuthor(bookList, "Dan Brown");
        assertEquals(2, result.size());
    }

    @Test
    void testSortByRatingAsc() {
        BookManage bookManage = new BookManage();
        List<Book> bookList = bookManage.getAllBooks(BookDataType.CSV);
        List<Book> result = bookManage.sortByRatingAsc(bookList);
        assertEquals("143038419", result.get(0).getIsbn());
        assertEquals("545010225", result.get(result.size() - 1).getIsbn());
    }

    @Test
    void tesGetTopRatedBook() {
        BookManage bookManage = new BookManage();
        List<Book> bookList = bookManage.getAllBooks(BookDataType.CSV);
        List<Book> result = bookManage.getTopRatedBook(bookList, 3);
        assertEquals("545010225", result.get(0).getIsbn());
        assertEquals("439785960", result.get(1).getIsbn());
        assertEquals("043965548X", result.get(2).getIsbn());
    }
}