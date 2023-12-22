package book_pocket.dto;

import book_pocket.entity.Book;
import book_pocket.entity.person.User;

import java.util.Map;

/**
 * 사용자 정보 및 장바구니 를 출력하는 Dto
 */
public class UserInfoOutDto {
    private String id;
    private String name;
    private String phone;
    private Map<Book, Integer> cart;

    public static UserInfoOutDto from(User user) {
        return new Builder()
                .id(user.getId())
                .name(user.getName())
                .phone(user.getPhone())
                .cart(user.getBookCart())
                .build();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Map<Book, Integer> getCart() {
        return cart;
    }

    // Builder Pattern
    private UserInfoOutDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.phone = builder.phone;
        this.cart = builder.cart;
    }

    public static class Builder {
        private String id;
        private String phone;
        private String name;
        private Map<Book, Integer> cart;

        public Builder id(String id) {
            this.id = id;
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

        public Builder cart(Map<Book, Integer> cart) {
            this.cart = cart;
            return this;
        }

        public UserInfoOutDto build() {
            return new UserInfoOutDto(this);
        }
    }
}
