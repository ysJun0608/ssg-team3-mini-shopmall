package book_pocket_v1;

public class UserService {
    private User user;

    public UserService(String nameUser, String phoneNumber) {
        this.user = new User(nameUser, phoneNumber);
    }

    void displayUser() {
        System.out.println(user.toString());
    }
}