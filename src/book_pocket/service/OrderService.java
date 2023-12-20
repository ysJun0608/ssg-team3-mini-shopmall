package book_pocket.service;

import book_pocket.dto.ExistUserDto;
import book_pocket.entity.Book;
import book_pocket.entity.User;

import java.util.Map;
import java.util.Optional;

public class OrderService {
    private final BookService bookService = new BookService();
    private UserService userService = UserService.getInstance();

    public OrderService() {}


    // Method ==============================================================

    public void resetCart(ExistUserDto userDto) {
        User user = userService.findById(userDto);
        user.resetCart();

//        cartAmount = new int[bookService.BookCount()]; // 책의 갯수가 많으면 그만큼 반복문으로 모든 인덱스 돌며 0의 값을 넣어주게 되므로 새로 초기화 하는것이 좋음.
    }

    //    public void addCart(String bookId, String flag) {
    public void addCart(ExistUserDto userDto, String bookId, String flag) {

        if (flag.equals("Y")) {
            User user = userService.findById(userDto);

            Optional<Book> optionalBook = bookService.findById(bookId);
            if (optionalBook.isEmpty()) {
                System.out.println("존재하지 않는 책 번호입니다.");
//                throw new Exception("존재하지 않는 책 번호입니다.");
            }
            Book book = optionalBook.get();

            user.addToCart(book);
        }
    }

    public void decreaseAmount(ExistUserDto userDto, String bookId) {
        User user = userService.findById(userDto);

        if (user.getBookCart().isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
//            throw new Exception("장바구니가 비어있습니다.");
        } else {
            Optional<Book> optionalBook = bookService.findById(bookId);
            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();

                int bookCountInCart = user.getBookCart().getOrDefault(book, 0);
                if (bookCountInCart > 1) {
                    user.getBookCart().put(book, bookCountInCart - 1);
                } else if (bookCountInCart == 1) { // 장바구니에서 책을 빼서 0권이 되면 map에서 제거
                    user.getBookCart().remove(book);
                } else {
                    System.out.println("장바구니에 없는 책입니다.");
//                    throw new Exception("장바구니에 없는 책입니다.");
                }
            }
        }
    }

    public void getCartProductList(ExistUserDto userDto) {
        User user = userService.findById(userDto);
        Map<Book, Integer> bookCart = user.getBookCart();
        for (Book book : bookCart.keySet()) {
            System.out.println(book.toString());
        }
    }

    public void showReceipt(ExistUserDto userDto) {
        User user = userService.findById(userDto);

        Map<Book, Integer> bookCart = user.getBookCart();

        if (!bookCart.isEmpty()) {
            for (Book book : bookCart.keySet()) {
                System.out.println("| " + book + " " + bookCart.get(book) + "권 |");
            }
        } else {
            System.out.println("장바구니가 비어있습니다.");
//            throw new Exception("장바구니가 비어있습니다.");
        }
    }

    public void resetSpecificBookQuantity(ExistUserDto userDto, String bookId) {
        User user = userService.findById(userDto);
        Optional<Book> book = bookService.findById(bookId);
        if (book.isPresent()) {
            user.getBookCart().remove(book);
        } else {
            System.out.println("장바구니에 없는 책입니다.");
//            throw new Exception("장바구니에 없는 책입니다.");
        }
    }
}