package src.test;

import org.junit.Test;
import src.models.AdminUserDTO;
import src.models.CustomerDTO;
import static org.junit.Assert.*;

public class TestIUser {
    @Test
    public void createIUserInstance() {
        AdminUserDTO adminUser = new AdminUserDTO(100001,"admin01", "admin01@ansan.ac.kr", "010-1111-1111","ansan","admin");

        CustomerDTO customer = new CustomerDTO(100002,"customer01", "customer01@ansan.ac.kr", "010-2222-2222","ansan",
                "customer");

        // 객체 생성 검증
        assertNotNull("AdminUser 객체는 null이 아니어야 합니다.", adminUser);
        assertNotNull("Customer 객체는 null이 아니어야 합니다.", customer);
    }
}