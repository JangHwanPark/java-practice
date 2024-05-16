package models;

public abstract class IModels {
    private int userId;
    // 사용자 필드
    private String name;
    private String email;
    private String phone;
    private String address;
    private String role;
    private String password;

    // 생성자
    public IModels(int userId, String name, String email, String phone, String address, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    public IModels(String name, String email, String phone, String address, String password, String role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    // 게터 (Getters)
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // 세터 (Setters)
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // 메소드
    @Override
    public String toString() {
        return "IUser {" +
                "name: '" + name + '\'' +
                ", email: '" + email + '\'' +
                ", phone: '" + phone + '\'' +
                ", address: '" + address + '\'' +
                '}';
    }
}