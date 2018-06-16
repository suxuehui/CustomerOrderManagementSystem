package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String sql_url="jdbc:mysql://localhost:3306/客户订购管理系统?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String name="root";
    private static final String password="983400";
    
    private static Connection conn=null;
    
    static {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得数据库的连接
            conn=DriverManager.getConnection(sql_url, name, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //将获得的数据库与java的链接返回（返回的类型为Connection）
    public static Connection getConnection(){
        return conn;
    }

}