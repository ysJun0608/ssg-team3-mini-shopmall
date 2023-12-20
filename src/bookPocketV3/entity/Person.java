package bookPocketV3.entity;

import bookPocketV3.Role;

//Admin과 User가 상속을 요청한 부모 클래스
public class Person {
    private String name;
    private String userMobile;
    private String address;

    //추가
    private Role role;

    //admin
    public Person(String name, String userMobile, Role role) {
        this.name = name;
        this.userMobile = userMobile;
        this.role = role;
    }


    //user
    public Person(String name, String userMobile, String address, Role role) {
        this.name = name;
        this.userMobile = userMobile;
        this.address = address;
        this.role = role;
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