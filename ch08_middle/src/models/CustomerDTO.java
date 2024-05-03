package src.models;

public class CustomerDTO extends models.IUser {
    public CustomerDTO(int userId, String name, String email, String phone, String address, String role) {
        super(userId, name, email, phone, address, role);
    }
}