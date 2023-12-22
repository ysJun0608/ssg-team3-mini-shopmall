package book_pocket.service;

import book_pocket.dto.ExistUserDto;
import book_pocket.entity.Book;
import book_pocket.entity.person.User;

import java.util.Map;
import java.util.Optional;

public class OrderService {
    private BookService bookService;
    private UserService userService;

    public OrderService() {
        userService = UserService.getInstance();
        bookService = BookService.getInstance();
    }

    // Method ==============================================================

    // TODO : Throw new Exception 으로 처리하기
    public void resetCart(ExistUserDto userDto) {
        Optional<User> optionalUser = userService.findById(userDto);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.resetCart();
            System.out.println("장바구니를 비웠습니다.");
        } else {
            System.out.println("존재하지 않는 유저입니다.");
        }


    }

    // TODO : Throw new Exception 으로 처리하기
    public void addCart(ExistUserDto userDto, String bookId, String flag) {
        if (flag.equals("Y")) {
            Optional<User> optionalUser = userService.findById(userDto);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                Optional<Book> optionalBook = bookService.findById(bookId);
                if (optionalBook.isEmpty()) {
                    System.out.println("존재하지 않는 책 번호입니다.");
//                throw new Exception("존재하지 않는 책 번호입니다.");
                }
                Book book = optionalBook.get();

                user.addToCart(book);
            } else {
                System.out.println("존재하지 않는 유저입니다.");
            }
        }
    }

    // TODO : Throw new Exception 으로 처리하기
    public void decreaseAmount(ExistUserDto userDto, String bookId) {
        Optional<User> optionalUser = userService.findById(userDto);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.getBookCart().isEmpty()) {
                System.out.println("장바구니가 비어있습니다.");
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
                    }
                }
            }
        } else {
            System.out.println("존재하지 않는 유저입니다.");
        }
    }

    // TODO : Throw new Exception 으로 처리하기
    public void getCartProductList(ExistUserDto userDto) {
        Optional<User> optionalUser = userService.findById(userDto);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Map<Book, Integer> bookCart = user.getBookCart();
            for (Book book : bookCart.keySet()) {
                System.out.println(book.toString());
            }
        } else {
            System.out.println("존재하지 않는 유저입니다.");
        }
    }

    // TODO : Throw new Exception 으로 처리하기
    public void showReceipt(ExistUserDto userDto) {
        Optional<User> optionalUser = userService.findById(userDto);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Map<Book, Integer> bookCart = user.getBookCart();

            if (!bookCart.isEmpty()) {
                for (Book book : bookCart.keySet()) {
                    System.out.println("| " + book + " " + bookCart.get(book) + "권 |");
                }
            } else {
                System.out.println("장바구니가 비어있습니다.");
            }
        } else {
            System.out.println("존재하지 않는 유저입니다.");
        }
    }

    // TODO : Throw new Exception 으로 처리하기
    public void resetSpecificBookQuantity(ExistUserDto userDto, String bookId) {
        Optional<User> optionalUser = userService.findById(userDto);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            Optional<Book> optionalBook = bookService.findById(bookId);
            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                user.getBookCart().remove(book);
            } else {
                System.out.println("장바구니에 없는 책입니다.");
            }
        } else {
            System.out.println("존재하지 않는 유저입니다.");
        }
    }
}
