package book_pocket;

public class User {
    private String name;
    private String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "이름 : " + name + "\n" + "연락처 : " + phone;
    }
}