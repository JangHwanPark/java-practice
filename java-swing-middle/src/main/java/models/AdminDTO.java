package models;

public class AdminDTO extends IModels {
    // userId를 포함하여 객체 생성 (업데이트 또는 조회시 사용)
    public AdminDTO(int userId, String name, String email, String phone, String address, String role) {
        super(userId, name, email, phone, address, role);
        System.out.println("AdminDTO 생성자 호출됨");
    }

    public AdminDTO(String name, String email, String phone, String address, String password, String role) {
        super(name, email, phone, address, password, role);
        System.out.println("AdminDTO 생성자 호출됨");
    }

    // adminId만 받는 생성자
    public AdminDTO(int userId) {
        super(userId, null, null, null, null, null);
    }
}