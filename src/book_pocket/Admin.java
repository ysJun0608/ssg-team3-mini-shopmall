package book_pocket;

public class Admin extends Person{
    private String id = "Admin";
    private String password = "Admin1234";

    private String name;

    private String phone;

    public Admin(String name, String phone) {
        super(name, phone);
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
 }
