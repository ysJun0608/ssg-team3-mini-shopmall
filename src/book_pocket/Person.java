package book_pocket;

public class Person {
    private String name;
    private String phone;
    private String address;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Person(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "현재 고객 정보 : \n" + "이름 : " + getName() + "  연락처 : " + getPhone();
    }
}