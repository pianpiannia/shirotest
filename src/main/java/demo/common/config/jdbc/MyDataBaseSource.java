package demo.common.config.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum MyDataBaseSource {
    DATASOURCE;

    String url="jdbc:mysql://129.28.152.193:30903/shirotest";

    String user="mysql";

    String password="979598595";

    Connection connection = null;

    private MyDataBaseSource() {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("-----调用了构造方法------");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


    }

    public Connection getConnection() {
            return connection;
    }
}
