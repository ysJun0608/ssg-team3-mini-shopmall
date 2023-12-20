package book_pocket.service;

import book_pocket.dto.ExistUserDto;

import java.util.Scanner;

public class ShoppingMallService {
    String[] menus = { "고객 정보 확인하기", "장바구니 상품 목록 보기", "장바구니 비우기", "바구니에 항목 추가하기",
            "장바구니의 항목 수량 줄이기", "장바구니의 항목 삭제하기", "영수증 표시하기", "종료"};
    private Scanner sc;
    private UserService userService;
    private OrderService orderService;

    public ShoppingMallService(Scanner sc) {
        this.sc = sc;
        this.userService = UserService.getInstance();
        this.orderService = new OrderService();
    }

    private void chooseMenu() {
        System.out.println("*".repeat(54));
        int lenMenus = menus.length;
        for (int idxMenu = 0; idxMenu < lenMenus; idxMenu += 2) {
            System.out.printf("%d. %-20s", (idxMenu + 1), menus[idxMenu]);
            if (lenMenus % 2 == 1 && idxMenu == lenMenus - 1) {
                System.out.println();
            } else {
                System.out.printf(" \t%d. %s", (idxMenu + 2), menus[idxMenu + 1]);
                System.out.println();
            }
        }
        System.out.println("*".repeat(54));
    }

    public boolean displayMenu(ExistUserDto userDto) throws InterruptedException {
        chooseMenu();

        System.out.print("메뉴 번호를 선택해주세요. ");
        String cmd = sc.nextLine();
        System.out.println();

        if (!cmd.isEmpty() && cmd != null) {
            switch (cmd) {
                case "1" -> userService.displayUser(userDto);

                case "2" -> orderService.getCartProductList(userDto);

                case "3" -> orderService.resetCart(userDto);

                case "4" -> {
                    System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
                    String bookId = sc.nextLine();
                    System.out.println("장바구니에 추가하겠습니까? Y | N");
                    String flag = sc.nextLine();

                    orderService.addCart(userDto, bookId, flag.toUpperCase()); // 별 의미 없고 소문자 들어오는 경우도 생각하여 toUpperCase 사용
                }

                case "5" -> {
                    System.out.print("장바구니에 수량을 감소시킬 도서의 ID를 입력하세요 :");
                    String bookId = sc.nextLine();

                    orderService.decreaseAmount(userDto, bookId);
                }

                case "6" -> {
                    System.out.print("장바구니에 수량을 초기화할 도서의 ID를 입력하세요 :");
                    String bookId = sc.nextLine();

                    orderService.resetSpecificBookQuantity(userDto, bookId);
                }

                case "7" -> orderService.showReceipt(userDto);

                case "8" -> {
                    return false;
                }
                default -> System.out.println("1부터 8까지의 숫자 중에서 다시 입력해주세요.");
            }
        } else {
            System.out.println("1부터 8까지의 숫자 중에서 다시 입력해주세요.");
        }
        System.out.println();

        return true;
    }

    /**
     *
     * @return
     */
    public boolean adminMenu() {
        System.out.println("미구현");
        return false;
    }
}