package book_pocket;

import java.util.Scanner;

public class AdminService {
    private Admin admin;
    public AdminService(String nameAdmin, String phoneNumber){
        this.admin = new Admin(nameAdmin, phoneNumber);
    }
    public void adminLogin(){
        System.out.println("관리자 정보를 입력하세요");

        Scanner input = new Scanner(System.in);
        System.out.print("아이디 : ");
        String adminId = input.next();
        System.out.print("비밀번호 : ");
        String adminPW = input.next();

        //Admin admin = new Admin(admin.getname(), user.getPhone());
        if (adminId.equals(admin.getId()) && adminPW.equals((admin.getPassword()))){
            System.out.println("이름 "+admin.getName()+"  연락처 "+admin.getPhone());
            System.out.println("아이디 "+admin.getId()+"  비밀번호 "+admin.getPassword());
        } else {
            System.out.println("관리자 정보가 일치하지 않습니다.");
        }
    }
}
