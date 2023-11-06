package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVBookData implements BookData {
    @Override
    public List<Book> getBookData() {
        String path = "D:\\CSV\\books.csv";
        String[] row;
        String line;

        List<Book> bookList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            String headerLine = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                row = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                double rating = 0;
                if (row[8] != null && !row[8].isEmpty()) {
                    rating = Double.parseDouble(row[12]);
                }

                int year = 0;
                if (row[8] != null && !row[8].isEmpty()) {
                    double doubleYear = Double.parseDouble(row[8]);
                    year = (int) doubleYear;
                }

                Book book = new Book(row[5], row[10], row[7], rating, year, row[11]);
                bookList.add(book);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
}
