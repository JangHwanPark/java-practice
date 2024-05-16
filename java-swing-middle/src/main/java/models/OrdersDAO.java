package models;

import utils.ConnProvider;

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

        AdminDTO admin = adminDAO.findByModelId(rset.getInt("admin_id"));
        CustomerDTO customer = customerDAO.findByProductId(rset.getInt("customer_id"));
        ProductDTO product = productDAO.findByModelId(rset.getInt("product_id"));

        return new OrdersDTO(
                admin,
                customer,
                product,
                rset.getDate("purchase_date"),
                rset.getDate("service_due_date"),
                rset.getBoolean("payment_status")
        );
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

    @Override
    public OrdersDTO findByModelId(int id) {
        String sql = """
                SELECT * FROM db2451506_user_management.orders WHERE order_id = ?
                """;

        try (Connection conn = ConnProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
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
}