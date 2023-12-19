package book_pocket;

import java.util.Scanner;

public class OrderService {

    private Scanner sc;
    private UserService userService;

    private Book[] books = {
            new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000, "송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서", "2018/10/08"),
            new Book("ISBN1235", "안드로이드 프로그래밍", 33000, "우재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22"),
            new Book("ISBN1236", "스크래치", 22000, "고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터입문", "2019/06/10"),
    };

    private int[] cartAmount = new int[3];

    public OrderService(Scanner sc, UserService us) {
        this.sc = sc;
        this.userService = us;
    }

    public void resetCart() {
        for (int i = 0; i < cartAmount.length; i++) {
            cartAmount[i] = 0;
        }
    }

    public void addCart() {
        System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
        String bookId = sc.nextLine();
        System.out.println("장바구니에 추가하겠습니까? Y | N");
        String flag = sc.nextLine();
        if (flag.equals("Y")) {
            for (int idxCart = 0; idxCart < cartAmount.length; idxCart++) {
                Book el = books[idxCart];
                if (el.getIsbn().equals(bookId)) {
                    cartAmount[idxCart]++;
                }
            }
            System.out.printf("%s 도서가 장바구니에 추가되었습니다.", bookId);
            System.out.println();
        }
    }

    public void decreaseAmount() {
        System.out.print("장바구니에 수량을 감소시킬 도서의 ID를 입력하세요 :");
        String bookId = sc.nextLine();
        for (int idxCart = 0; idxCart < cartAmount.length; idxCart++) {
            Book el = books[idxCart];
            if (el.getIsbn().equals(bookId)) {
                cartAmount[idxCart] = cartAmount[idxCart] < 1 ? 0 : cartAmount[idxCart] - 1;
            }
        }
    }

    public void deleteCartProduct() {
        System.out.print("장바구니에 수량을 초기화할 도서의 ID를 입력하세요 :");
        String bookId = sc.nextLine();
        for (int idxCart = 0; idxCart < cartAmount.length; idxCart++) {
            Book el = books[idxCart];
            if (el.getIsbn().equals(bookId)) {
                cartAmount[idxCart] = 0;
            }
        }
    }

    public void getCartProductList() {
        int lenCartAmount = cartAmount.length;
        for (int idxCart = 0; idxCart < lenCartAmount; idxCart++) {
            Book el = books[idxCart];
            if (cartAmount[idxCart] > 0) {
                System.out.printf("%s의 총 수량은 %d입니다.", el.getIsbn(), cartAmount[idxCart]);
                System.out.println();
            }
        }
    }

    public void showReceipt() {
        int lenCartAmount = cartAmount.length;
        for (int idxCart = 0; idxCart < lenCartAmount; idxCart++) {
            if (cartAmount[idxCart] > 0) {
                Book el = books[idxCart];
                System.out.println(el + " " + cartAmount[idxCart] + " |");
            }
        }
    }
}