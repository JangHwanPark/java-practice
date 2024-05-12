package models;

public class CustomerDTO extends IModels {
    public CustomerDTO(int userId, String name, String email, String phone, String address, String role) {
        super(userId, name, email, phone, address, role);
    }

    // 생성자 오버로딩
    public CustomerDTO(int userId) {
        super(userId, null, null, null, null, null);
    }
}