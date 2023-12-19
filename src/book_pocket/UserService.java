package book_pocket;

public class UserService {
    private User user;

    public UserService(User user) {
        this.user = new User(user.getName(), user.getPhone());
    }

    void displayUser() {
        System.out.println(user.toString());
    }
}