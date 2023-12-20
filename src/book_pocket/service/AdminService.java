package book_pocket.service;

import book_pocket.dto.SignInDto;
import book_pocket.entity.Admin;

import java.util.Optional;

public class AdminService {
    private static Admin admin = Admin.getInstance();
    public AdminService() {}

    public static Optional<Admin> signIn(SignInDto dto) {
        if (admin.getId().equals(dto.getId()) && admin.getPassword().equals(dto.getPassword())) {
            return Optional.of(admin);
        }
        return Optional.empty();
    }
}
