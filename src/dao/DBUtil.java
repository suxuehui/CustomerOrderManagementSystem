package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String sql_url="jdbc:mysql://localhost:3306/�ͻ���������ϵͳ?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String name="root";
    private static final String password="983400";
    
    private static Connection conn=null;
    
    static {
        try {
            //1.������������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.������ݿ������
            conn=DriverManager.getConnection(sql_url, name, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //����õ����ݿ���java�����ӷ��أ����ص�����ΪConnection��
    public static Connection getConnection(){
        return conn;
    }

}