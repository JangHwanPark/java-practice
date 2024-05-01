package src.test;

import org.junit.Test;
import src.models.AdminUser;
import src.models.Customer;
import static org.junit.Assert.*;

public class TestIUser {
    @Test
    public void createIUserInstance() {
        AdminUser adminUser = new AdminUser(100001,"admin01", "admin01@ansan.ac.kr", "010-1111-1111","ansan","admin");

        Customer customer = new Customer(100002,"customer01", "customer01@ansan.ac.kr", "010-2222-2222","ansan",
                "customer");

        // 객체 생성 검증
        assertNotNull("AdminUser 객체는 null이 아니어야 합니다.", adminUser);
        assertNotNull("Customer 객체는 null이 아니어야 합니다.", customer);
    }
}