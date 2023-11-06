package org.example;

import java.util.ArrayList;
import java.util.List;

public class APIBookData implements BookData {
    @Override
    public List<Book> getBookData() {
        return new ArrayList<>();
    }

}
