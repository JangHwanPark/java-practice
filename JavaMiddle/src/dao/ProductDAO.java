package dao;

import dao.InterfaceDAO.ConnProvider;
import dao.abstractDAO.IModelDAO;
import models.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends IModelDAO<ProductDTO> {
    public ProductDAO() {
        super("db2451506_user_management.product");
    }

    @Override
    protected ProductDTO modelsResultSet(ResultSet rset) throws SQLException {
        return new ProductDTO(
            rset.getInt("product_id"),
            rset.getString("make"),
            rset.getString("model"),
            rset.getInt("year"),
            rset.getString("color"),
            rset.getString("vin"),
            rset.getInt("price")
        );
    }

    @Override
    public ProductDTO insertModel(ProductDTO model) {
        return null;
    }

    @Override
    public ProductDTO deleteModel(ProductDTO model) {
        return null;
    }

    @Override
    public ProductDTO updateModel(ProductDTO model) {
        return null;
    }

    // TODO: 추상 메서드로 구현
    public ProductDTO findByProductId(int id) {
        String sql = "SELECT * FROM db2451506_user_management.product WHERE product_id = ?";
        try (
                Connection conn = ConnProvider.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
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
}