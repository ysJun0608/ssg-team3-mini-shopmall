package book_pocket.dto;

/**
 * 쿠키 느낌으로 id값만 들고 다니며 사용자 존재 여부 체크
 */
public class ExistUserDto {
    private String id;

    public ExistUserDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
