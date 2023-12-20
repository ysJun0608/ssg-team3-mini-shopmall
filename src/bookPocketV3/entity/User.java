package bookPocketV3.entity;

import bookPocketV3.Role;

import static bookPocketV3.Role.ROLE_USER;
public class User extends Person {
    public User(String name, String userMobile) {
        super(name, userMobile, ROLE_USER);
    }

    public User(String name, String userMobile, String address) {
        super(name, userMobile, address, ROLE_USER);
    }

    @Override
    public String toString() {
        return "현재 고객 정보 : \n" + "이름 : " + getName() + "  연락처 : " + getPhone();
    }
}