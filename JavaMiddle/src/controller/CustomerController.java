package controller;

import dao.CustomerDAO;
import dao.OrdersDAO;
import models.AdminDTO;
import models.CustomerDTO;
import models.OrdersDTO;
import models.ProductDTO;
import view.CustomerRegistration;

import javax.swing.*;
import java.sql.Date;

public class CustomerController {
    private final CustomerDAO customerDAO;
    private final OrdersDAO ordersDAO;

    public CustomerController() {
        customerDAO = new CustomerDAO();
        ordersDAO = new OrdersDAO();
    }

    public boolean registerCustomerAndOrder(CustomerDTO customer, OrdersDTO order) {
        // 고객 등록
        CustomerDTO registeredCustomer = customerDAO.insertModel(customer);
        if (registeredCustomer == null) {
            return false;
        }

        // 주문 등록
        order.setCustomer(registeredCustomer);
        return ordersDAO.insertModel(order) != null;
    }
}