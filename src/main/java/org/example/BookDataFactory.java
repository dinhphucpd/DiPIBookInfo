package org.example;

public class BookDataFactory {
    private BookDataFactory() {
    }

    public static BookData getBookData(BookDataType dataType) {
        switch (dataType) {
            case CSV -> {
                return new CSVBookData();
            }
            case MYSQL -> {
                return new MySQLBookData();
            }
            case API -> {
                return new APIBookData();
            }
            default -> {
                throw new IllegalArgumentException("This data source is not supported!");
            }
        }
    }
}
