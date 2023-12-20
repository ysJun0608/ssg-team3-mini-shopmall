package bookPocketV2.entity;

//싱글톤 객체 사용
public class Admin extends Person {
    private final String ID_ADMIN = "admin";
    private final String PASSWORD_ADMIN = "admin1234";

    //Admin 클래스의 private 정적 변수로 유일한 인스턴스를 갖는다.
    private static Admin instanceSingleton = null;
    //Admin 클래스의 생성자는 pirvate으로 선언되어 외부에서 new를 통해 직접 생성할 수 없다.
    private Admin(String name, String phone) {
        //부모 클래스(Person)의 생성자를 호출하여 입력받은 이름과 값으로 초기화한다.
        super(name, phone);
    }

    //정적인 getInstance를 통해 유일한 인스턴스를 얻는다.
    public static Admin getInstance(String name, String phone) {
        //인스턴스가 생성되지 않았다면 새로운 Admin 인스턴스를 생성한다.
        if(instanceSingleton == null) {
            instanceSingleton = new Admin(name, phone);
        }
        //생성된 인스턴스를 반환한다.
        return instanceSingleton;
    }

    public String getId() {
        return ID_ADMIN;
    }

    public String getPassword() {
        return PASSWORD_ADMIN;
    }

    @Override
    public String toString() {
        return "이름 " + getName() + "\t연락처" + getPhone() + "\n" + "아이디 "+ getId() + "\t비밀번호 "+ getPassword();
    }
}