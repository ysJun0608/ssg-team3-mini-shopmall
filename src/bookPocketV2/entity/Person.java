package bookPocketV2.entity;
//Admin과 User가 상속을 요청한 부모 클래스
public class Person {
    private String name;
    private String userMobile;
    private String address;

    public Person(String name, String userMobile) {
        this.name = name;
        this.userMobile = userMobile;
    }

    public Person(String name, String userMobile, String address) {
        this.name = name;
        this.userMobile = userMobile;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return userMobile;
    }

    public String getAddress() {
        return address;
    }
}