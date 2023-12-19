package book_pocket;

import java.util.Scanner;

public class ShoppingMallService {
    String[] menus = {"고객 정보 확인하기", "장바구니 상품 목록 보기", "장바구니 비우기", "바구니에 항목 추가하기", "장바구니의 항목 수량 줄이기", "장바구니의 항목 삭제하기", "영수증 표시하기", "종료", "관리자 로그인"};
    private UserService userService;
    private OrderService orderService;
    private AdminService adminService;

    private Scanner sc;

    public ShoppingMallService(Scanner sc, String nameUser, String phoneUser) {
        this.sc = sc;
        this.userService = new UserService(nameUser, phoneUser);
        this.orderService = new OrderService(sc, userService);
        this.adminService = new AdminService(nameUser, phoneUser);
    }

    boolean displayMenu() {
        System.out.println("*".repeat(54));
        System.out.print(" ".repeat(9));
        System.out.print("Welcome to Shopping Mall");
        System.out.print(" ".repeat(9));
        System.out.println();
        System.out.print(" ".repeat(9));
        System.out.print("Welcome to Book Market!");
        System.out.print(" ".repeat(8));
        System.out.println();
        System.out.println("*".repeat(54));

        int lenMenus = menus.length;
        for (int idxMenu = 0; idxMenu < lenMenus; idxMenu++) {
            System.out.printf("%d. %s", (idxMenu + 1), menus[idxMenu]);
            System.out.println();
        }
        System.out.println("*".repeat(54));
        int cmd = Integer.parseInt(sc.nextLine());
        switch (cmd) {
            case 1:
                userService.displayUser();
                break;
            case 2:
                orderService.getCartProductList();
                break;
            case 3:
                orderService.resetCart();
                break;
            case 4:
                orderService.addCart();
                break;
            case 5:
                orderService.decreaseAmount();
                break;
            case 6:
                orderService.deleteCartProduct();
                break;
            case 7:
                orderService.showReceipt();
                break;
            case 8:
                return false;
            case 9:
                adminService.adminLogin();
                break;
            default:
        }
        return true;
    }
}