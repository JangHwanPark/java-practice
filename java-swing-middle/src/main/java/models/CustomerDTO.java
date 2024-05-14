package models;

public class CustomerDTO extends IModels {
    public CustomerDTO(int userId, String name, String email, String phone, String address, String role) {
        super(userId, name, email, phone, address, role);
    }

    // userId만 받는 생성자 (오버로딩)
    public CustomerDTO(int userId) {
        super(userId, null, null, null, null, null);
    }

    // 이름, 주소, 이메일, 전화번호, 역할을 받는 생성자
    public CustomerDTO(String name, String address, String email, String phone, String role) {
        super(0, name, email, phone, address, role);
    }
}