package book_pocket.dto;

/**
 * 관리자 로그인을 하는 사람의 이름을 담아두기 위해 만듬
 */
public class AdminSignInDto extends SignInDto {
    private String name;

    public AdminSignInDto(String id, String password, String name) {
        super(id, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
