package models;

public class AdminDTO extends models.IUser {
    public AdminDTO(int userId, String name, String email, String phone, String address, String role) {
        super(userId, name, email, phone, address, role);
    }
}