package src.models;

public class AdminUser extends models.IUser {
    public AdminUser(int userId, String name, String email, String phone, String address, String role) {
        super(userId, name, email, phone, address, role);
    }
}