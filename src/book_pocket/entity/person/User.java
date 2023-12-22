package book_pocket.entity.person;

import book_pocket.entity.Book;

import java.util.HashMap;
import java.util.Map;

import static book_pocket.entity.person.Authority.CUSTOMER;

public class User extends Person {
    private String name;
    private Map<Book, Integer> bookCart;


    public User() {
        super(CUSTOMER);
    }

    public User(String id, String password, String phone, String name) {
        super(id, password, phone, CUSTOMER);
        this.name = name;
        this.bookCart = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Book, Integer> getBookCart() {
        return bookCart;
    }

    @Override
    public String toString() {
        return "이름 : " + name + "\n" + super.printInfo();
    }


    public void resetCart() {
        this.bookCart = new HashMap<>();
    }

    public void addToCart(Book book) {
        this.getBookCart().put(book, this.getBookCart().getOrDefault(book, 0) + 1);

        System.out.printf("%s 도서가 장바구니에 추가되었습니다.\n", book.getIsbn());
    }

    // Builder Pattern
    private User(Builder builder) {
        super(builder.id, builder.password, builder.phone, CUSTOMER);
        this.name = builder.name;
        this.bookCart = new HashMap<>();
    }

    public static class Builder {
        private String id;
        private String password;
        private String phone;
        private String name;
        private Map<String, Integer> bookCart = new HashMap<>();
        private Authority authority;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder bookCart(Map<String, Integer> bookCart) {
            this.bookCart = bookCart;
            return this;
        }

        public Builder authority(Authority authority) {
            this.authority = authority;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}