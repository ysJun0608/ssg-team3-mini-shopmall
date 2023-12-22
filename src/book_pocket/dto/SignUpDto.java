package book_pocket.dto;

/**
 * 엔티티 의존성을 낮추기 위해 만든 회원정보를 담는 Dto
 */
public class SignUpDto {
    private String id;

    public SignUpDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
