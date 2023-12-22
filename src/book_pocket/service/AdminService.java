package book_pocket.service;

import book_pocket.dto.AdminSignInDto;
import book_pocket.dto.ExistUserDto;
import book_pocket.dto.UserInfoOutDto;
import book_pocket.entity.person.Admin;
import book_pocket.entity.Book;
import book_pocket.entity.person.User;

import java.util.List;
import java.util.Optional;

public class AdminService {
    private static Admin admin = Admin.getInstance();
    private static AdminService instance;
    private BookService bookService;
    private UserService userService;

    public static AdminService getInstance() {
        if (instance == null) {
            instance = new AdminService();
        }
        return instance;
    }

    public AdminService() {
        this.bookService = BookService.getInstance();
        this.userService = UserService.getInstance();
    }

    public static Optional<Admin> signIn(AdminSignInDto dto) {
        if (admin.getId().equals(dto.getId()) && admin.getPassword().equals(dto.getPassword())) {
            return Optional.of(admin);
        }
        return Optional.empty();
    }

    public void addBook(Book book) {
        bookService.addBook(book);
    }

    public void removeBook(String bookId) {
        bookService.removeBook(bookId);
    }

    public void findAllUser() {
        List<User> userList = userService.findAll();
        for (User user : userList) {
            userInfo(user);
        }
    }

    private static void userInfo(User user) {
        UserInfoOutDto dto = UserInfoOutDto.from(user);
        System.out.println(String.format("아이디 : %s, 이름 : %s, 연락처 : %s", dto.getId(), dto.getName(), dto.getPhone()));
        if (!dto.getCart().isEmpty()) {
            dto.getCart().entrySet().stream()
                    .forEach(book -> {
                        System.out.printf("%s %d권", book.getKey().toString(), book.getValue());
                    });
        }
    }

    public void findUserById(ExistUserDto userDto) {
        Optional<User> optionalUser = userService.findById(userDto);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userInfo(user);
        } else {
            System.out.println("존재하지않는 유저입니다.");
        }
    }
}
