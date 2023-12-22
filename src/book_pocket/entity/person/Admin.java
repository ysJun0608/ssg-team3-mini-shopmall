package book_pocket.entity.person;

import static book_pocket.entity.person.Authority.ADMIN;

public class Admin extends Person {
    private static Admin admin;

    private String name;

    public static Admin getInstance() {
        if (admin == null) {
            admin = new Admin("Admin_abc", "Admin_1234", "01012345678");
        }
        return admin;
    }
    public Admin(String id, String password, String phone) {
        super(id, password, phone, ADMIN);
    }

    /**
     * setter 정말 싫어하는데 어떻게 주입할지 떠오르지가 않아서 사용
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
