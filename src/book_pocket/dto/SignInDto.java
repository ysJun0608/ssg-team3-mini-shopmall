package book_pocket.dto;

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
