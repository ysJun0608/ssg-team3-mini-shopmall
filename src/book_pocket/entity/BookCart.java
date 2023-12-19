package book_pocket.entity;

import java.util.ArrayList;

public class BookCart {
    private ArrayList<Book> bookList;

    public void addToCart(Book book) {
        bookList.add(book);
    }
}
