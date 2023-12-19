package book_pocket;

public class Admin extends Person {
    private final String id = "admin";
    private final String password = "admin1234";

    public Admin(String name, String phone) {
        super(name, phone);
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}