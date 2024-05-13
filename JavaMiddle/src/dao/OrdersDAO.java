package dao;

import dao.InterfaceDAO.ConnProvider;
import dao.abstractDAO.IModelDAO;
import models.AdminDTO;
import models.CustomerDTO;
import models.OrdersDTO;
import models.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDAO extends IModelDAO<OrdersDTO> {
    public OrdersDAO() {
        super("db2451506_user_management.orders");
    }

    @Override
    protected OrdersDTO modelsResultSet(ResultSet rset) throws SQLException {
        AdminDAO adminDAO = new AdminDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();

        AdminDTO admin = adminDAO.findByAdminId(rset.getInt("admin_id"));
        CustomerDTO customer = customerDAO.findByProductId(rset.getInt("customer_id"));
        ProductDTO product = productDAO.findByProductId(rset.getInt("product_id"));

        return new OrdersDTO(
                admin,
                customer,
                product,
                rset.getDate("purchase_date"),
                rset.getDate("service_due_date"),
                rset.getBoolean("payment_status")
        );
    }

    // TODO: 추상 메서드로 구현
    public OrdersDTO findByCustomerID(int customer_id) {
        String sql = """
                SELECT
                    c.customer_id,
                    c.name,
                    c.email,
                    c.phone,
                    c.address,
                    p.make AS purchase_vehicle,
                    p.vin,
                    p.color,
                    o.purchase_date,
                    p.price,
                    (CASE WHEN o.purchase_date IS NOT NULL THEN 'Paid' ELSE 'Not Paid' END) AS payment_status
                FROM db2451506_user_management.customer c
                JOIN db2451506_user_management.orders o ON c.customer_id = o.customer_id
                JOIN db2451506_user_management.product p ON o.product_id = p.product_id
                WHERE c.customer_id = ?
                """;

        try (
                Connection conn = ConnProvider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            System.out.println("데이터 조회 성공");
            pstmt.setInt(1, customer_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return modelsResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.getStackTrace();
        }

        return null;
    }


    @Override
    public OrdersDTO insertModel(OrdersDTO model) {
        String sql = """
                INSERT INTO db2451506_user_management.orders 
                (customer_id, product_id, admin_id, purchase_date, service_due_date) 
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection conn = ConnProvider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(3, model.getAdmin().getUserId());
            pstmt.setInt(1, model.getCustomer().getUserId());
            pstmt.setInt(2, model.getProduct().getProductId());
            pstmt.setDate(4, new java.sql.Date(model.getPurchaseDate().getTime()));
            pstmt.setDate(5, new java.sql.Date(model.getServiceDueDate().getTime()));
            pstmt.setBoolean(6, model.isPaymentStatus());
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("Insertion successful, new order ID: " + generatedKeys.getInt(1));
                    }
                }
            }
            return model;
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.getStackTrace();
        }

        return null;
    }

    @Override
    public OrdersDTO deleteModel(OrdersDTO model) {
        return null;
    }

    @Override
    public OrdersDTO updateModel(OrdersDTO model) {
        return null;
    }

    public static void main(String[] args) {
        OrdersDAO ordersDAO = new OrdersDAO();
        System.out.println(ordersDAO.getAllModels());
    }
}