package org.example;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        BookManage bookManage = new BookManage();
        BookDataType dataType = BookDataType.CSV;

        Scanner scanner = new Scanner(System.in);

        int select;
        do {
            System.out.println("========================================");
            System.out.println("|            DiPi Book Info            |");
            System.out.println("----------------------------------------");
            System.out.println("|       [1]. Book List                 |");
            System.out.println("|       [2]. Search by ISBN            |");
            System.out.println("|       [3]. Search by Title           |");
            System.out.println("|       [4]. Search by Author          |");
            System.out.println("|       [5]. Sort by Rating (ASC)      |");
            System.out.println("|       [6]. Get Top Rated Book        |");
            System.out.println("|       [0]. Exit                      |");
            System.out.println("========================================");
            System.out.print("Enter a number: ");
            select = scanner.nextInt();
            scanner.nextLine();

            switch (select) {
                case 1 -> {
                    System.out.println("Book List:");
                    bookManage.displayBook(bookManage.getAllBooks(dataType));
                }
                case 2 -> {
                    System.out.print("Enter ISBN: ");
                    String search = scanner.nextLine();

                    if (bookManage.searchByIsbn(bookManage.getAllBooks(dataType), search).isEmpty()) {
                        System.out.println("Book not found!");
                    } else {
                        bookManage.displayBook(bookManage.searchByIsbn(bookManage.getAllBooks(dataType), search));
                    }
                }
                case 3 -> {
                    System.out.print("Enter Title: ");
                    String search = scanner.nextLine();

                    if (bookManage.searchByTitle(bookManage.getAllBooks(dataType), search).isEmpty()) {
                        System.out.println("Book not found!");
                    } else {
                        bookManage.displayBook(bookManage.searchByTitle(bookManage.getAllBooks(dataType), search));
                    }
                }
                case 4 -> {
                    System.out.print("Enter Author's name: ");
                    String search = scanner.nextLine();

                    if (bookManage.searchByAuthor(bookManage.getAllBooks(dataType), search).isEmpty()) {
                        System.out.println("Book not found!");
                    } else {
                        bookManage.displayBook(bookManage.searchByAuthor(bookManage.getAllBooks(dataType), search));
                    }
                }
                case 5 -> {
                    bookManage.displayBook(bookManage.sortByRatingAsc(bookManage.getAllBooks(dataType)));
                    System.out.println("Sort successfully!");
                }
                case 6 -> {
                    System.out.print("Enter Amount: ");
                    int count = scanner.nextInt();

                    bookManage.displayBook(bookManage.getTopRatedBook(bookManage.getAllBooks(dataType), count));
                }
            }
        } while (select != 0);

        scanner.close();
    }
}