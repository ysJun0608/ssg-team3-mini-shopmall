package book_pocket.entity;

public class User extends Person {
    private String name;
    private BookCart bookCart;

    public User(String id, String password, String phone, String name, BookCart bookCart) {
        super(id, password, phone);
        this.name = name;
        this.bookCart = bookCart;
    }

    @Override
    public String toString() {
        return "이름 : " + name + "\n" + super.printInfo();
    }

    // Builder Pattern
    private User(Builder builder) {
        super(builder.id, builder.password, builder.phone);
        this.name = builder.name;
        this.bookCart = builder.bookCart;
    }

    public static class Builder {
        private String id;
        private String password;
        private String phone;
        private String name;
        private BookCart bookCart;

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

        public Builder bookCart(BookCart bookCart) {
            this.bookCart = bookCart;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}