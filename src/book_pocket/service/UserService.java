package book_pocket.service;

import book_pocket.dto.ExistUserDto;
import book_pocket.dto.SignInDto;
import book_pocket.dto.SignUpDto;
import book_pocket.entity.person.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    private ArrayList<User> userList = new ArrayList<>();

    public UserService() {}

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void signUp(User user) {
        userList.add(user);
    }

    // TODO : Throw new Exception 으로 처리하기
    public void displayUser(ExistUserDto userDto) {
        Optional<User> optionalUser = findById(userDto);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            System.out.println(user.toString() + "\n");
        } else {
            System.out.println("존재하지 않는 유저입니다.");
        }
    }

    /**
     * 사용자 리스트가 비어 있지 않다면 중복 아이디를 확인
     *
     * @param dto(Id, Password)
     * @return boolean
     */
    public boolean existById(SignUpDto dto) {
        if (!userList.isEmpty()) {
            return userList.stream()
                    .anyMatch(user -> user.getId().equals(dto.getId()));
        } else {
            return false;
        }
    }

    /**
     * id와 password로 로그인을 시도하고 Optional로 리턴
     *
     * @param dto(id, password)
     * @return Optional<User>
     */
    public Optional<User> findByIdAndPassword(SignInDto dto) {
        return userList.stream()
                .filter(user -> user.getId().equals(dto.getId()) &&
                        user.getPassword().equals(dto.getPassword()))
                .findFirst();
    }

    /**
     * 사용자 id값으로 userList에서 찾아서 Optional로 리턴
     *
     * @param userDto(id)
     * @return Optional<User>
     */
    public Optional<User> findById(ExistUserDto userDto) {
        return userList.stream()
                .filter(user -> user.getId().equals(userDto.getId()))
                .findFirst();
    }

    public List<User> findAll() {
        return userList; // TODO : DTO로 리턴하기
    }
}