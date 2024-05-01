package src.models;

public class Customer extends models.IUser {

    public Customer(int userId, String name, String email, String phone, String address, String role) {
        super(userId, name, email, phone, address, role);
    }
}