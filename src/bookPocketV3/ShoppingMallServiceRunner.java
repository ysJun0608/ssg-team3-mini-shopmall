package bookPocketV3;

import bookPocketV3.service.ShoppingMallService;

import java.util.Scanner;

public class ShoppingMallServiceRunner {
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        ShoppingMallService shoppingMallService = new ShoppingMallService(sc);
        while (true) { //종료 전까지 false 반환
            if (!shoppingMallService.displayMenuAndGetIsContinue()) {
                break;
            }
        }
        sc.close();
    }
}