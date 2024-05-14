package view;

import controller.CustomerController;
import models.AdminDTO;
import models.CustomerDTO;
import models.OrdersDTO;
import models.ProductDTO;
import view.abstractView.ICustomerView;

import javax.swing.*;
import java.sql.Date;

public class CustomerRegistration extends ICustomerView {
    private static final CustomerRegistration customerRegister = new CustomerRegistration();

    private CustomerRegistration() {
        super("고객 등록", 300, 500);
        setVisible(true);
    }

    public static CustomerRegistration getInstance() {
        return customerRegister;
    }

    @Override
    public void initComponents() {
        super.initComponents();
        createButtonPanel("등록", "취소");
    }

    /* 사용자 등록 이벤트 리스너 */
    @Override
    public void setButtonEvent() {
        try {
            String name = getNameField().getText().trim();
            String address = getAddressField().getText().trim();
            String email = getEmailField().getText().trim();
            String phone = getPhoneField().getText().trim();
            String role = getRoleField().getText().trim();
            String productIdStr = getProductIdField().getText().trim();
            String adminIdStr = getAdminIdField().getText().trim();
            String purchaseDateStr = getPurchaseDateField().getText().trim();
            String serviceDueDateStr = getServiceDueDateField().getText().trim();
            boolean paymentStatus = getPaymentStatusField().isSelected();

            if (name.isEmpty() || address.isEmpty() || email.isEmpty() || phone.isEmpty() || role.isEmpty() || productIdStr.isEmpty() || adminIdStr.isEmpty() || purchaseDateStr.isEmpty() || serviceDueDateStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 필드를 입력하세요.", "입력 오류", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int productId = Integer.parseInt(productIdStr);
            int adminId = Integer.parseInt(adminIdStr);
            Date purchaseDate = Date.valueOf(purchaseDateStr);
            Date serviceDueDate = Date.valueOf(serviceDueDateStr);

            CustomerDTO customer = new CustomerDTO(name, address, email, phone, role);
            OrdersDTO order = new OrdersDTO();
            order.setProduct(new ProductDTO(productId));
            order.setAdmin(new AdminDTO(adminId));
            order.setPurchaseDate(purchaseDate);
            order.setServiceDueDate(serviceDueDate);
            order.setPaymentStatus(paymentStatus);

            CustomerController controller = new CustomerController();
            boolean success = controller.registerCustomerAndOrder(customer, order);

            if (success) {
                JOptionPane.showMessageDialog(this, "고객 및 주문 등록 성공");
            } else {
                JOptionPane.showMessageDialog(this, "고객 및 주문 등록 실패", "오류", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "제품 ID와 관리자 ID는 숫자로 입력해야 합니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "날짜 형식이 잘못되었습니다. YYYY-MM-DD 형식으로 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
        }
    }
}