package book_pocket.entity.person;

public class Person {
    private String id;
    private String password;
    private String phone;
    private Authority authority;

    public Person(Authority authority) {
        this.authority = authority;
    }

    public Person(String id, String password, Authority authority) {
        this.id = id;
        this.password = password;
        this.authority = authority;
    }

    public Person(String id, String password, String phone, Authority authority) {
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.authority = authority;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    protected String printInfo() {
        return "아이디 : " + this.id + "\n"
                + "연락처 : " + this.phone;
    }
}
