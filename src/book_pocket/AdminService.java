package book_pocket;

import java.util.Scanner;

public class AdminService {
    private Scanner sc;

    public AdminService(Scanner sc) {
        this.sc = sc;
    }

    boolean authenticate(User user) {
        System.out.println("관리자 정보를 입력하세요");
        System.out.print("아이디 : ");
        String id = sc.next();
        System.out.print("비밀번호 : ");
        String password = sc.next();
        Admin admin = new Admin(user.getName(), user.getPhone());
        boolean isAuthenticated = id.trim().equals(admin.getId()) && password.trim().equals(admin.getPassword());
        if (isAuthenticated) {
            System.out.println("이름 " + admin.getName() + "  연락처 " + admin.getPhone());
            System.out.println("아이디 " + admin.getId() + "  비밀번호 " + admin.getPassword());
        } else {
            System.out.println("관리자 정보가 일치하지 않습니다.");
        }
        return isAuthenticated;
    }
}