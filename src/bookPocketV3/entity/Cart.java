package bookPocketV3.entity;

import java.util.List;

public class Cart {
    private List<Book> listCart;

    public void addToCart(Book book) {
        listCart.add(book);
    }
}
