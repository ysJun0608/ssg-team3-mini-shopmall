package book_pocket;
import java.util.*;
public class AdminService {

    private Scanner sc;
    private Admin admin;

    private User user;
    AdminService(){}

    //AdminService()

    public AdminService(String nameUser, String phoneUser) {
        this.user = new User(nameUser, phoneUser);
    }


    public void AdminLogin() {
        System.out.println("관리자 정보를 입력하세요");
        Scanner input = new Scanner(System.in);
        System.out.print("아이디 : ");
        String adminId = input.next();
        System.out.print("비밀번호 : ");
        String adminPW = input.next();
        displayAdmin(adminId, adminPW);
    }

    void displayAdmin(String adminId, String adminPW) {
        Admin admin = new Admin(user.getUserName(), user.getPhone());

        if(adminId.equals(admin.getId())&&adminPW.equals(admin.getPassword())) {
            System.out.println("이름" + admin.getName() + " 연락처 " + admin.getPhone());
            System.out.println("아이디 " + admin.getId() + " 비밀번호 " + admin.getPassword());
        }else
            System.out.println("관리자 정보가 일치하지 않습니다.");
    }

}
