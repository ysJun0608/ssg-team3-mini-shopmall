package book_pocket.exception;

public enum ErrorCode {
    DUPLICATEUSERID("중복된 사용자 아이디입니다."),
    WRONGLOGININFO("잘못된 로그인 정보입니다.");


    private String desc;

    ErrorCode(String desc) {
        this.desc = desc;
    }
}
