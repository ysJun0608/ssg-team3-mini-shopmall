package book_pocket;

public class User extends Person {
    private String name;
    private String phone;

    public User(String name, String phone) {
        super(name, phone);
    }

    @Override
    public String toString() {
        return "이름 : " + name + "\n" + "연락처 : " + phone;
    }
}