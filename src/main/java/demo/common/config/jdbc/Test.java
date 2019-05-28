package demo.common.config.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author jun
 * @exception TODO
 * @date 2019/05/28 16:59
 * @Version
 */
public class Test {

    private static PreparedStatement preparedStatement = null;
    private static Connection connection = null;
    private static ResultSet resultSet = null;
    public static void main(String[] args) throws Exception {
        Connection connection = MyDataBaseSource.DATASOURCE.getConnection();

        String s = "select * from adminuser where username = 'admin'";

       
            preparedStatement = connection.prepareStatement(s);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                System.out.println(id);
            }

            resultSet.close();
            connection.close();
            preparedStatement.close();
            

        
    }
}
