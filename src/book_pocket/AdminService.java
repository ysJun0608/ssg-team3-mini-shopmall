package book_pocket;

import java.util.Scanner;

public class AdminService {
    private User user;
    private Admin admin;
    private Scanner sc;

    public AdminService(Scanner sc, String nameUser, String phoneNumber) {
        this.sc = sc;
        this.user = new User(nameUser, phoneNumber);
    }
    void adminLogin() {
        System.out.println("관리자 정보를 입력하세요.");

        System.out.print("아이디: ");
        String adminId = sc.nextLine();

        System.out.print("비밀번호: ");
        String adminPw = sc.nextLine();


        displayAdmin(adminId, adminPw);
    }

    void displayAdmin(String adminId, String adminPw) {
        admin = new Admin(user.getName(), user.getPhone());
        if(adminId.equals(admin.getId()) && adminPw.equals(admin.getPassword())) {
            System.out.println("이름 " + admin.getName() + " 연락처 " + admin.getPhone());
            System.out.println("아이디 " + admin.getId() + " 비밀번호 " + admin.getPassword());
        } else System.out.println("관리자 정보가 일치하지 않습니다.");
    }
}
