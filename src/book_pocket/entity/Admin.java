package book_pocket.entity;

public class Admin extends Person {
    private static Admin admin;

    private final String position = "관리자";
    private String name;

    public static Admin getInstance() {
        if (admin == null) {
            admin = new Admin("Admin_abc", "Admin_1234", "01012345678");
        }
        return admin;
    }
    public Admin(String id, String password, String phone) {
        super("Admin_abc", "Admin_1234", "01012345678");
    }
}
