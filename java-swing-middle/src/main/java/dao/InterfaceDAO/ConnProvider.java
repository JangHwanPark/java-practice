package dao.InterfaceDAO;

import utils.ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnProvider {
    static Connection getConnection() throws SQLException {
        return ConnectDB.initDB();
    }
}