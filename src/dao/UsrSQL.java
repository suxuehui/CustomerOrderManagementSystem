package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class UsrSQL {
	/**
	 * 
	 */
	public static Vector<Vector<String>> getRows(){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�  
           // if(!conn.isClosed())  
           //   System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from �û���");  
            ResultSet result1 = preparedStatement.executeQuery();  
                            
            rows = new Vector<Vector<String>>();  
              
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
                
            }  
            //System.out.println("�ɹ�while");    
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return rows;  
    }  
      
	/**
	 *  �õ��û����ݿ��ͷ
	 */
    public static Vector<String> getHead(){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<String> columnHeads = null;  
          
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�  
//          if(!conn.isClosed())  
//              System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from �û���");  
            ResultSet result1 = preparedStatement.executeQuery();  
              
            columnHeads = new Vector<String>();  
            
            ResultSetMetaData rsmd = result1.getMetaData();  
            
            for(int i = 1; i <= rsmd.getColumnCount(); i++)  
                columnHeads.addElement(rsmd.getColumnName(i));  
              
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return columnHeads;  
    }  
    
    /**
	 *  �õ����ݿ�����һ������ 
	 */  
    private static Vector<String> getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{  
        Vector<String> currentRow = new Vector<String>();  
        for(int i = 1; i <= rsmd.getColumnCount(); i++){  
            currentRow.addElement(rs.getString(i));  
        }  
        return currentRow;  
    }
    
    /**
	 *  �༭�û�����
	 */    
    public static int edit(String item,String id,String ty,String pwd){  
        Connection conn;  
        PreparedStatement sql = null;      
        try {  
        	conn=DBUtil.getConnection();   //�������ݿ�  
              
            if (item=="add") {
            	//System.out.println("insert into ѧ����Ϣ��(ѧ��,����,�Ա�,�༶,ϵ��,��������,����) values('"+id+"','"+na+"','"+se+"','"+cl+"','"+ma+"','"+bi+"','"+ad+"')");
            	sql = conn.prepareStatement("insert into �û��� values('"+id+"','"+ty+"','"+pwd+"')");  
            } 
            else if(item=="edi")
            	//System.out.println("update ѧ����Ϣ�� set '����'='"+na+"','�Ա�'='"+se+"','ϵ��'='"+ma+"','�༶'='"+cl+"','��������'='"+bi+"','����'='"+ad+"' where 'ѧ��'='"+id+"'");    
            	sql = conn.prepareStatement("update �û��� set �û�����='"+ty+"' where �û���='"+id+"'"); 
                sql.executeUpdate();
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return 0;  
    }
    
    /**
	 *    ���������ܵ�ʵ��
	 */
    public static Vector<Vector<String>> search(String item,String n){
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�   
            if (item=="usr")
            	preparedStatement = conn.prepareStatement("select * from �û��� where �û���='" + n + "'");  
            else if(item=="ty")
            	preparedStatement = conn.prepareStatement("select * from �û��� where �û�����='" + n + "'"); 
            ResultSet result1 = preparedStatement.executeQuery();  
                            
            rows = new Vector<Vector<String>>();  
              
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
                
            }  
            //System.out.println("�ɹ�while");    
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return rows;  
    }
    
    

    
    /**
	 *  ɾ������
	 */  
    public static int del(String id){   
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
        	conn=DBUtil.getConnection();   //�������ݿ�  
            sql = conn.prepareStatement("delete from �û��� where �û���='"+id+"'"); 
            sql.executeUpdate();
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return 0;  
    }
    
    /**
	 *  �޸�����
	 */
    public static int cdpwd(String id,String pwd){  
        Connection conn;  
        PreparedStatement sql = null;      
        try {  
        	conn=DBUtil.getConnection();   
            sql = conn.prepareStatement("update �û��� set ����='"+pwd+"' where �û���='"+id+"'");
            sql.executeUpdate();
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return 0;  
    }
}
