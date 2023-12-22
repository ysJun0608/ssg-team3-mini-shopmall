package book_pocket.dto;

/**
 * 엔티티 의존성을 낮추기 위해서 만든 로그인 정보를 받는 Dto
 */
public class SignInDto {

    private String id;
    private String password;

    public SignInDto(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
