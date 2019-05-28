package demo.shiro;

import demo.common.config.jdbc.MyDataBaseSource;
import demo.common.config.jdbc.MysqlConnection;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author jun
 * @exception TODO
 * @date 2019/05/28 15:17
 * @Version
 */
public class MyRealm extends AuthorizingRealm {

    private static PreparedStatement preparedStatement = null;
    private static Connection connection = null;
    private static ResultSet resultSet = null;

    /**
     * 权限认证
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        connection = MyDataBaseSource.DATASOURCE.getConnection() ;

        String s = "select * from adminuser where usermane = " + token.getUsername();

        try {
            preparedStatement = connection.prepareStatement(s);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return null;
    }
}
