package book_pocket_v1;

public class Admin extends Person{
    private String id = "Admin";
    private String password = "Admin1234";

    public Admin(String name, String phone){
        super(name, phone);
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "이름 " + getName() + "\t아이디 "+ id + "\n" + "연락처" + getPhone() + "\t비밀번호 "+  password;
    }
}
