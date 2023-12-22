package book_pocket.service;

import book_pocket.dto.ExistUserDto;
import book_pocket.entity.Book;

import java.util.Scanner;

public class ShoppingMallService {
    String[] customerMenu = {"고객 정보 확인하기", "장바구니 상품 목록 보기", "장바구니 비우기", "바구니에 항목 추가하기",
            "장바구니의 항목 수량 줄이기", "장바구니의 항목 삭제하기", "영수증 표시하기", "종료"};
    String[] adminMenu = {"책 추가하기", "책 제거하기", "고객 리스트 보기", "특정 회원 정보 보기", "종료"};
    private Scanner sc;
    private UserService userService;
    private OrderService orderService;
    private AdminService adminService;

    public ShoppingMallService(Scanner sc) {
        this.sc = sc;
        this.userService = UserService.getInstance();
        this.orderService = new OrderService();
        this.adminService = AdminService.getInstance();
    }

    private String chooseMenu(String[] menu) {
        System.out.println("*".repeat(54));
        int lenMenus = menu.length;
        for (int idxMenu = 0; idxMenu < lenMenus; idxMenu += 2) {
            System.out.printf("%d. %-20s", (idxMenu + 1), menu[idxMenu]);
            if (lenMenus % 2 == 1 && idxMenu == lenMenus - 1) {
                System.out.println();
            } else {
                System.out.printf(" \t%d. %s", (idxMenu + 2), menu[idxMenu + 1]);
                System.out.println();
            }
        }
        System.out.println("*".repeat(54));

        System.out.print("메뉴 번호를 선택해주세요. ");
        String cmd = sc.nextLine();
        System.out.println();

        return cmd;
    }

    /**
     * "1. 고객 정보 확인하기", "2. 장바구니 상품 목록 보기", "3. 장바구니 비우기", "4. 바구니에 항목 추가하기",
     * "5. 장바구니의 항목 수량 줄이기", "6. 장바구니의 항목 삭제하기", "7. 영수증 표시하기", "8. 종료"
     *
     * @param userDto
     * @return
     */
    public boolean displayMenu(ExistUserDto userDto) {
        String cmd = chooseMenu(customerMenu);

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
                default -> System.out.printf("1부터 %d까지의 숫자 중에서 다시 입력해주세요.\n", customerMenu.length);
            }
        } else {
            System.out.printf("1부터 %d까지의 숫자 중에서 다시 입력해주세요.\n", customerMenu.length);
        }
        System.out.println();

        return true;
    }

    /**
     * "1. 책 추가하기", "2. 책 제거하기", "3. 고객 리스트 보기", "4. 종료"
     *
     * @return
     */
    public boolean adminMenu() {
        System.out.println("구현중");
        String cmd = chooseMenu(adminMenu);

        if (!cmd.isEmpty() && cmd != null) {
            switch (cmd) {
                case "1" -> {
                    System.out.println("추가할 책 정보를 입력해주세요.");
                    Book book = inputBookInfo();

                    adminService.addBook(book);
                }
                case "2" -> {
                    System.out.println("제거할 책 정보를 입력해주세요.");
                    String bookId = sc.nextLine();

                    adminService.removeBook(bookId);
                }
                case "3" -> {
                    adminService.findAllUser();
                }
                case "4" -> {
                    System.out.println("찾을려고 하는 회원 ID를 입력해주세요.");
                    String userId = sc.nextLine();
                    adminService.findUserById(new ExistUserDto(userId));
                }
                case "5" -> {
                    return false;
                }
                default -> System.out.printf("1부터 %d까지의 숫자 중에서 다시 입력해주세요.\n", adminMenu.length);
            }
        } else {
            System.out.printf("1부터 %d까지의 숫자 중에서 다시 입력해주세요.\n", adminMenu.length);
        }
        return false;
    }

    private Book inputBookInfo() {
        System.out.print("책 ID 정보를 입력해주세요.");
        String isbn = sc.nextLine();
        System.out.print("책 이름 정보를 입력해주세요.");
        String name = sc.nextLine();
        System.out.print("책 가격 정보를 입력해주세요.");
        int price = Integer.parseInt(sc.nextLine());
        System.out.print("저자 정보를 입력해주세요.");
        String author = sc.nextLine();
        System.out.print("책 설명 정보를 입력해주세요.");
        String desc = sc.nextLine();
        System.out.print("카테고리 정보를 입력해주세요.");
        String category = sc.nextLine();
        System.out.print("발행년도 정보를 입력해주세요.");
        String datePublish = sc.nextLine();

        return new Book(isbn, name, price, author, desc, category, datePublish);
    }
}