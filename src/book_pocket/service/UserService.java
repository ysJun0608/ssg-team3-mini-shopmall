package book_pocket.service;

import book_pocket.dto.ExistUserDto;
import book_pocket.dto.SignInDto;
import book_pocket.dto.SignUpDto;
import book_pocket.entity.Book;
import book_pocket.entity.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class UserService {


    private ArrayList<User> userList = new ArrayList<>();

    private static UserService instance;

    public UserService() {}

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void signUp(User user) {
        userList.add(user);
    }

    public void displayUser(ExistUserDto userDto) {
        User user = findById(userDto);

        System.out.println(user.toString() + "\n");
    }

    public boolean existById(SignUpDto dto) {
        if (!userList.isEmpty()) return userList.stream().anyMatch(user -> user.getId().equals(dto.getId()));
        else return false;
    }

    public Optional<User> findByIdAndPassword(SignInDto dto) {
        return userList.stream()
                .filter(user -> user.getId().equals(dto.getId()) &&
                        user.getPassword().equals(dto.getPassword()))
                .findFirst();
    }

    public User findById(ExistUserDto userDto) {
        return userList.stream().
                filter(user -> user.getId().equals(userDto.getId()))
                .findFirst()
                .get();
    }

    public void findBookReceiptById(ExistUserDto userDto) {
        Map<Book, Integer> bookCart = findById(userDto).getBookCart();
        for (Book book : bookCart.keySet()) {
            System.out.println("| " + book + " " + bookCart.get(book) + "권 |");
        }
    }
}