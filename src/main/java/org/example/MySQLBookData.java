package org.example;

import java.util.ArrayList;
import java.util.List;

public class MySQLBookData implements BookData {
    @Override
    public List<Book> getBookData() {
        return new ArrayList<>();
    }

}
