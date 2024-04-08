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

    /**
     * 매개변수를 받는 생성자
     * @param uid 사용자 아이디
     * @param password 사용자 비밀번호
     */
    public User(String uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    // Fixme: 회원가입때 사용할것
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