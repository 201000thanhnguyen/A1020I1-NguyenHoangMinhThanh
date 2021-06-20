package thanh.code.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectRepository {
    private Connection connection;
    private String jdbcURL = "jdbc:mysql://localhost:3307/db_name";
    private String jdbcUserName = "root";
    private String jdbcPassword = "123456789Tt**";

    public ConnectRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){ return connection; }
}