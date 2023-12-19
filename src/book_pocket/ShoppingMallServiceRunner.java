package book_pocket;

import book_pocket.entity.Admin;
import book_pocket.entity.Person;
import book_pocket.entity.User;
import book_pocket.service.AdminService;
import book_pocket.service.ShoppingMallService;
import book_pocket.service.UserService;

import java.util.Scanner;

/*
        BookMarketService (displayMenu)
        OrderService (getCartProduct, resetCart, showReceipt, addCartProduct, decreaseAmount, deleteCartProduct)
        UserService (getCustomer)
 */
public class ShoppingMallServiceRunner {
    static Scanner sc;
    static AdminService adminService = new AdminService();

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);

        System.out.println("로그인 | 회원가입");
        String signInOrUp = sc.nextLine();

        UserService userService = new UserService();
        if (signInOrUp.equals("회원가입")) { // admin 회원가입은 데이터를 직접 넣는걸로 생각하고 user 회원가입만 진행

            boolean duplicateName = true;
            String id = "";
            while (duplicateName) {
                System.out.println("아이디를 입력해주세요 : ");
                id = sc.nextLine();
                duplicateName = userService.findById(id);
                if (duplicateName) System.out.println("이미 존재하는 아이디 입니다.");
//                throw new Exception("이미 존재하는 아이디입니다.");
            }

            System.out.println("비밀번호를 입력해주세요 : ");
            String password = sc.nextLine();
            System.out.println("연락처를 입력해주세요 : ");
            String phone = sc.nextLine();
            System.out.println("이름을 입력해주세요 : ");
            String name = sc.nextLine();

            User user = new User.Builder()
                    .id(id)
                    .password(password)
                    .phone(phone)
                    .name(name)
                    .build();

            userService.signUp(user);
        }
        // 로그인 시작
        System.out.println("=====로그인 화면=====");
        System.out.print("아이디를 입력해주세요 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력해주세요 : ");
        String password = sc.nextLine();
        Person person = new Person(id, password);

        if (id.length() > 6 && id.substring(0, 6).equals("Admin_")) { // 관리자;
            if (adminService.existByIdAndPassword(id, password)) {
                throw new Exception("잘못된 아이디와 비밀번호입니다.");
            } else { // 관리자 화면 실행
                Admin admin = adminService.signIn();
                ShoppingMallService shoppingMallService = new ShoppingMallService(sc, admin);
                boolean flagLoop = true;

                while (flagLoop) {
                    flagLoop = shoppingMallService.adminMenu();
                }
            }
        } else { // 고객
            User user = userService.findByIdAndPassword(id, password);

            welComeToShoppingMall();

            ShoppingMallService shoppingMallService = new ShoppingMallService(sc, user);

            boolean flagLoop = true;

            while (flagLoop) {
                flagLoop = shoppingMallService.displayMenu();
            }

        }
        sc.close();
    }

    private static void welComeToShoppingMall() {
        System.out.println("*".repeat(54));
        System.out.printf("%s\tWelcome to Shopping Mall\n", " ".repeat(10));
        System.out.printf("%s\t Welcome to Book Market\n", " ".repeat(10));
        System.out.println("*".repeat(54));
    }
}