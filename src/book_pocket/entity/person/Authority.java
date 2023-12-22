package book_pocket.entity.person;

public enum Authority {
    ADMIN("관리자"), CUSTOMER("고객");

    private String desc;
    Authority(String desc) {
        this.desc = desc;
    }
}
