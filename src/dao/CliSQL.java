package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.Vector;

import dao.DBUtil;  
  
public class CliSQL {  
    // �õ����ݿ������  
    public static Vector<Vector<String>> getRows(){
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();
           // if(!conn.isClosed())  
           //   System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from �ͻ���Ϣ��");  
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
      
    // �õ����ݿ��ͷ  
    public static Vector<String> getHead(){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<String> columnHeads = null;  
          
        try {  
        	conn=DBUtil.getConnection();
//          if(!conn.isClosed())  
//              System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from �ͻ���Ϣ��");  
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
      
    // �õ����ݿ�����һ������  
    private static Vector<String> getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{  
        Vector<String> currentRow = new Vector<String>();  
        for(int i = 1; i <= rsmd.getColumnCount(); i++){  
            currentRow.addElement(rs.getString(i));  
        }  
        return currentRow;  
    }
   
    //���������ܵ�ʵ��
    public static Vector<Vector<String>> search(String op,String seh){  
        Connection conn;  
        PreparedStatement preparedStatement = null;    
        Vector<Vector<String>> rows = null;  
        String opt = null;
        System.out.println(opt);   
        switch(op){
        case "�ͻ����":
        	opt = "Cid";
        	break;
        case "�ͻ�����":
        	opt = "Cnam";
        	break;
        case "��ϵ��":
        	opt = "Cpeo";
        	break;
        }
        System.out.println(opt);   
        try {  
        	conn=DBUtil.getConnection();
           	preparedStatement = conn.prepareStatement("select * from �ͻ���Ϣ�� where " + opt + " like '%" + seh + "%'");  
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
    
    //�༭�����ܵ�ʵ��
    public static int edit(String item,String id,String nam,String add,String peo,String tel,String mai,String not){ 
        Connection conn;  
        PreparedStatement sql = null;  
        
  
        try {  
        	conn=DBUtil.getConnection();
              
            if (item=="add") {
            	System.out.println("insert into �ͻ���Ϣ��(Cid,Cnam,Cadd,Cpeo,Ctel,Cmai,Cnot) values('"+id+"','"+nam+"','"+add+"','"+peo+"','"+tel+"','"+mai+"','"+not+"')");
            	sql = conn.prepareStatement("insert into �ͻ���Ϣ��(Cid,Cnam,Cadd,Cpeo,Ctel,Cmai,Cnot) values('"+id+"','"+nam+"','"+add+"','"+peo+"','"+tel+"','"+mai+"','"+not+"')");  
            } 
            else if(item=="edi") {
            	System.out.println("update �ͻ���Ϣ�� set Cnam='"+nam+"',Cadd='"+add+"',Cpeo='"+peo+"',Ctel='"+tel+"',Cmai='"+mai+"',Cnot='"+not+"' where Cid='"+id+"'");    
            	sql = conn.prepareStatement("update �ͻ���Ϣ�� set Cnam='"+nam+"',Cadd='"+add+"',Cpeo='"+peo+"',Ctel='"+tel+"',Cmai='"+mai+"',Cnot='"+not+"' where Cid='"+id+"'"); 
            }
            sql.executeUpdate();
            System.out.println("�ɹ�");
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return 0;  
    }
   
    //ɾ������
    public static int del(String id){  
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
        	conn=DBUtil.getConnection();//�������ݿ�  
            sql = conn.prepareStatement("delete from �ͻ���Ϣ�� where Cid='"+id+"'"); 
            sql.executeUpdate();
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ⡣");  
            e.printStackTrace();  
        }  
        return 0;  
    }

    //������ֵ
	public static Vector<?> getRow(Object row) {
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();   //�������ݿ�  
           // if(!conn.isClosed())  
           //   System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from �ͻ���Ϣ�� where Cid='"+row+"'");  
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
} 