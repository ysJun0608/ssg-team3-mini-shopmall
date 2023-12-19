package book_pocket;

import java.util.Scanner;

public class ShoppingMallServiceRunner {
    static Scanner sc;
    ;

    /**
     * Main Method
     *
     * @param args String Arguments
     */
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요 : ");
        String nameUser = sc.nextLine();
        System.out.print("연락처를 입력하세요 : ");
        String phoneUser = sc.nextLine();
        ShoppingMallService shoppingMallService = new ShoppingMallService(sc, nameUser, phoneUser);
        boolean flagLoop = true;
        while (flagLoop) {
            System.out.println("메뉴 번호를 선택해주세요 ");
            flagLoop = shoppingMallService.displayMenu();
        }
        sc.close();
    }
}