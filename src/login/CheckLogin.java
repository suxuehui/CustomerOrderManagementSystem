package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import dao.DBUtil;

public class CheckLogin {
	/**
	 * 账号密码检查
	 */
	public static boolean CheckRole(String usr,String pwd){ 
        Connection conn;  
        PreparedStatement preparedStatement = null; 
        try{  
        	conn=DBUtil.getConnection();   //连接数据库  
            preparedStatement = conn.prepareStatement("select * from 用户表 where 用户名='"+usr+"' and 密码='"+pwd+"'");  
            ResultSet result1 = preparedStatement.executeQuery();               
            if(result1.next()==true)
            	return true; 
        }
        catch(Exception e1){  
            System.out.println(e1);  
        }  
            return false;  
    }  
	
	/**
	 * 判断用户是否存在
	 */
    public static boolean exist(String usr1){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        try {  
        	conn=DBUtil.getConnection();    //连接数据库  
            preparedStatement = conn.prepareStatement("select 用户名 from 用户表  where 用户名='"+usr1+"'");  
            ResultSet result1 = preparedStatement.executeQuery();               
            if(result1.next()==true)
            	return true; 
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }
        return false;  
    }
    
	/**
	 * 用户权限检查
	 */
	public static Vector Checklevel(String usr,String pwd){ 
        Connection conn;  
        PreparedStatement preparedStatement = null; 
        Vector<Vector<String>> rows = null; 
        try{  
        	conn=DBUtil.getConnection();   //连接数据库  
            preparedStatement = conn.prepareStatement("select 用户类型 from 用户表 where 用户名='"+usr+"' and 密码='"+pwd+"'");  
            ResultSet result1 = preparedStatement.executeQuery();               
            rows = new Vector<Vector<String>>();  
            
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
            }
        }
        catch(Exception e1){  
            System.out.println(e1);  
        }  
            return rows;  
    }  
        
     // 得到数据库中下一行数据  
    private static Vector<String> getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{  
        Vector<String> currentRow = new Vector<String>();  
        for(int i = 1; i <= rsmd.getColumnCount(); i++){  
            currentRow.addElement(rs.getString(i));  
        }  
        return currentRow;  
    }
    
}


