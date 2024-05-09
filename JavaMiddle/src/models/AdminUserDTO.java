package models;

public class AdminUserDTO extends models.IUser {
    public AdminUserDTO(int userId, String name, String email, String phone, String address, String role) {
        super(userId, name, email, phone, address, role);
    }
}