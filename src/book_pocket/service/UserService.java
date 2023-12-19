package book_pocket.service;

import book_pocket.entity.User;

import java.util.ArrayList;

public class UserService {
    private ArrayList<User> userList = new ArrayList<>();
    private User user;

    public UserService(User user) {
        this.user = user;
    }

    public UserService() {

    }

    public void signUp(User user) {
        userList.add(user);
    }

    public void displayUser() {
        System.out.println(user.toString() + "\n");
    }

    public boolean findById(String userId) {
        if (!userList.isEmpty()) return userList.stream().anyMatch(user -> user.getId().equals(userId));
        else return false;
    }

    public User findByIdAndPassword(String id, String password) {
        return userList.stream()
                .filter(user -> user.getId().equals(id) &&
                        user.getPassword().equals(password))
                .findFirst()
                .get();
    }
}