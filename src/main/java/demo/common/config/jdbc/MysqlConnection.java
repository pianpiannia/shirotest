package demo.common.config.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author jun
 * @exception TODO
 * @date 2019/05/28 14:22
 * @Version
 */
public class MysqlConnection {

    private static  final String url="jdbc:mysql://http://129.28.152.193:30903/shirotest";

    private static  final String user="mysql";

    private static  final String password="979598595";

    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
