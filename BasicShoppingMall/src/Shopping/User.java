package src.Shopping;

public class User {
    private String uid;
    private String password;
    private String address;
    private String tel;

    /**
     * 기본 생성자.<br>
     * {@code User} 객체를 생성할 때 특별한 초기화 작업 없이 객체를 생성합니다.
     */
    public User() {}

    /** Todo User Constructors*/
    public User(String uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    // Getter
    public String getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    // Setter
    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}