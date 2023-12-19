package book_pocket.service;

import book_pocket.entity.Book;

public class OrderService {

    private final BookService bookService = new BookService();
    public OrderService() {}

    private int[] cartAmount = new int[bookService.BookCount()];

        // Method ==============================================================

    public void resetCart() {
        cartAmount = new int[bookService.BookCount()]; // 책의 갯수가 많으면 그만큼 반복문으로 모든 인덱스 돌며 0의 값을 넣어주게 되므로 새로 초기화 하는것이 좋음.
    }

    public void addCart(String bookId, String flag) {
        if(flag.equals("Y")) {
            for(int idxCart = 0; idxCart < cartAmount.length; idxCart++) { // 반복문을 돌며 책의 인덱스를 찾기 위함
                Book el = bookService.getBooks(idxCart);
                if(el.getIsbn().equals(bookId)) { // 만약 책의 번호와 장바구니에 넣을 번호가 같으면 장바구니에 담음
                    cartAmount[idxCart]++;
                }
            }
            System.out.printf("%s 도서가 장바구니에 추가되었습니다.\n", bookId); // \n을 사용하여 sout 코드 한줄 제거
        }
    }

    public void decreaseAmount(String bookId) {
        for(int idxCart = 0; idxCart < cartAmount.length; idxCart++) { // 장바구니에서 책을 빼기 위해 cartAmount 순회
            Book el = bookService.getBooks(idxCart);
            if(el.getIsbn().equals(bookId)) { // 뺄려고 한 책이면 cartAmount에서 -1하여 한권 제거 만약 책이 없으면 장바구니에 없는 책이라고 출력
                if (cartAmount[idxCart] > 0) cartAmount[idxCart]--;
                else System.out.println("장바구니에 없는 책입니다.");
//                cartAmount[idxCart] = cartAmount[idxCart] < 1 ? 0 : cartAmount[idxCart] - 1;
            }
        }
    }

    public void deleteCartProduct(String bookId) {
        for(int idxCart = 0; idxCart < cartAmount.length; idxCart++) {
            Book el = bookService.getBooks(idxCart);
            if(el.getIsbn().equals(bookId)) {
                cartAmount[idxCart] = 0;
            }
        }
    }

    public void getCartProductList() {
        int lenCartAmount = cartAmount.length;
        for(int idxCart = 0; idxCart < lenCartAmount; idxCart++) {
            Book el = bookService.getBooks(idxCart);
            if(cartAmount[idxCart] > 0) {
                System.out.printf("%s의 총 수량은 %d입니다.\n", el.getIsbn(), cartAmount[idxCart]);
            }
        }
    }

    public void showReceipt() {
        int lenCartAmount = cartAmount.length;
        for(int idxCart = 0; idxCart < lenCartAmount; idxCart++) {
            if(cartAmount[idxCart] > 0) {
                Book el = bookService.getBooks(idxCart);
                System.out.println(el + " " + cartAmount[idxCart] + " |");
            }
        }
    }
}