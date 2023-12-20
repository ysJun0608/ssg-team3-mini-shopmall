package bookPocketV3.service;

import bookPocketV3.entity.User;

public class UserService {
    private final User user; //final이 바뀔 수 있음

    public UserService(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    void displayUser() {
        System.out.println(user.toString());
    } //user 정보 출력
}