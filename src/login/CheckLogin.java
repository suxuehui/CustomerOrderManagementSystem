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
	 * �˺�������
	 */
	public static boolean CheckRole(String usr,String pwd){ 
        Connection conn;  
        PreparedStatement preparedStatement = null; 
        try{  
        	conn=DBUtil.getConnection();   //�������ݿ�  
            preparedStatement = conn.prepareStatement("select * from �û��� where �û���='"+usr+"' and ����='"+pwd+"'");  
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
	 * �ж��û��Ƿ����
	 */
    public static boolean exist(String usr1){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�  
            preparedStatement = conn.prepareStatement("select �û��� from �û���  where �û���='"+usr1+"'");  
            ResultSet result1 = preparedStatement.executeQuery();               
            if(result1.next()==true)
            	return true; 
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }
        return false;  
    }
    
	/**
	 * �û�Ȩ�޼��
	 */
	public static Vector Checklevel(String usr,String pwd){ 
        Connection conn;  
        PreparedStatement preparedStatement = null; 
        Vector<Vector<String>> rows = null; 
        try{  
        	conn=DBUtil.getConnection();   //�������ݿ�  
            preparedStatement = conn.prepareStatement("select �û����� from �û��� where �û���='"+usr+"' and ����='"+pwd+"'");  
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
        
     // �õ����ݿ�����һ������  
    private static Vector<String> getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{  
        Vector<String> currentRow = new Vector<String>();  
        for(int i = 1; i <= rsmd.getColumnCount(); i++){  
            currentRow.addElement(rs.getString(i));  
        }  
        return currentRow;  
    }
    
}


