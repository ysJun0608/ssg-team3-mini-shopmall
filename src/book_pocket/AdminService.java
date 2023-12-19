package book_pocket;

import java.util.Scanner;

public class AdminService {

    private Admin admin;

    public AdminService(String id, String password){
        this.admin = new Admin(id, password);
    }
    void displayAdmin(){
        System.out.println("관리자 정보를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 : ");
        String id = sc.next();
        System.out.print("비밀번호 : ");
        String password = sc.next();
        if(admin.getId().equals(id) && admin.getPassword().equals(password)){
            System.out.println(admin.toString());
        } else {
            System.out.println("관리자의 아이디와 비밀번호가 일치하지 않습니다. 다시 작성해주세요");
        }
    }
}
