package book_pocket.service;

import book_pocket.entity.Admin;

public class AdminService {
    private static Admin admin = Admin.getInstance();

    public AdminService() {
    }

    public boolean existByIdAndPassword(String id, String password) {
        return admin.getId().equals(id) &&
                admin.getPassword().equals(password);
    }

    public static Admin signIn() {

        return admin;
    }
}
