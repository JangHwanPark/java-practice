package dao;

import dao.abstractDAO.IModelDAO;
import models.LexusDTO;
import models.OrdersDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDAO extends IModelDAO<OrdersDTO> {
    public OrdersDAO() {
        super("db2451506_user_management.orders");
    }

    @Override
    protected OrdersDTO modelsResultSet(ResultSet rset) throws SQLException {
        return new OrdersDTO(
            rset.getInt("order_id"),
            rset.getInt("customer_id"),
            rset.getInt("product_id"),
            rset.getInt("quantity"),
            rset.getInt("total_price"),
            rset.getString("order_date")
        );
    }

    @Override
    public OrdersDTO insertModel(OrdersDTO model) {
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
}