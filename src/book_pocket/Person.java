package book_pocket;

public class Person {

    private String name;
    private String phone;
    private String address;
    Person(){};

    Person(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }



}