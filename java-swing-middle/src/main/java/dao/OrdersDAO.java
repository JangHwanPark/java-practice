package dao;

import dao.InterfaceDAO.ConnProvider;
import dao.abstractDAO.IModelDAO;
import models.AdminDTO;
import models.CustomerDTO;
import models.OrdersDTO;
import models.ProductDTO;

import java.sql.*;

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
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, customer_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return modelsResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public OrdersDTO insertModel(OrdersDTO model) {
        String sql = """
                INSERT INTO db2451506_user_management.orders 
                (customer_id, product_id, admin_id, purchase_date, service_due_date, payment_status) 
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = ConnProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, model.getCustomer().getUserId());
            pstmt.setInt(2, model.getProduct().getProductId());
            pstmt.setInt(3, model.getAdmin().getUserId());
            pstmt.setDate(4, new java.sql.Date(model.getPurchaseDate().getTime()));
            pstmt.setDate(5, new java.sql.Date(model.getServiceDueDate().getTime()));
            pstmt.setBoolean(6, model.isPaymentStatus());
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        model.setOrderId(generatedKeys.getInt(1));
                    }
                }
            }
            return model;
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public OrdersDTO deleteModel(OrdersDTO model) {
        String sql = "DELETE FROM db2451506_user_management.orders WHERE order_id = ?";

        try (Connection conn = ConnProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, model.getOrderId());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("삭제된 행의 수: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OrdersDTO updateModel(OrdersDTO model) {
        String sql = "UPDATE db2451506_user_management.orders SET customer_id = ?, product_id = ?, admin_id = ?, purchase_date = ?, service_due_date = ?, payment_status = ? WHERE order_id = ?";

        try (Connection conn = ConnProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, model.getCustomer().getUserId());
            pstmt.setInt(2, model.getProduct().getProductId());
            pstmt.setInt(3, model.getAdmin().getUserId());
            pstmt.setDate(4, new java.sql.Date(model.getPurchaseDate().getTime()));
            pstmt.setDate(5, new java.sql.Date(model.getServiceDueDate().getTime()));
            pstmt.setBoolean(6, model.isPaymentStatus());
            pstmt.setInt(7, model.getOrderId());

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("수정된 행의 수: " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            e.printStackTrace();
        }
        return model;
    }

    public static void main(String[] args) {
        OrdersDAO ordersDAO = new OrdersDAO();
        System.out.println(ordersDAO.getAllModels());
    }
}