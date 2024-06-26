package src.Shopping;

public class User { // 단일 사용자 - 사용자 정보 관리
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
    public String getUserId() {
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
    public void setUid(String uid) { // 아이디 설정
        this.uid = uid;
    }

    public void setPassword(String password) { // 비밀번호 설정
        this.password = password;
    }

    public void setAddress(String address) { // 주소 설정
        this.address = address;
    }

    public void setTel(String tel) { // 전화번호 설정
        this.tel = tel;
    }

    // Obj 클래스 오버라이딩 (equals, toString)
    @Override
    public boolean equals(Object object) {
        // 자기 자신(객체)랑 비교
        if (this == object) return true;

        // null 검사, 클래스의 타입 비교
        if (object == null || getClass() != object.getClass()) return false;

        // 인자로 받은값을 User 타입으로 캐스팅 후 비교하려는 두 객체가 같은 uid 값인지 비교
        User user = (User) object;
        return uid.equals(user.uid);
    }

    @Override
    public String toString() {
        return "uid: " + uid + "\n" +
                "password: " + password + "\n" +
                "address: " + address + "\n" +
                "tel: " + tel;
    }
}