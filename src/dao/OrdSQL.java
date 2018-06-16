package dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.Vector;  
  
public class OrdSQL {  
    // �õ����ݿ������  
    public static Vector<Vector<String>> getRows(){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�  
           // if(!conn.isClosed())  
           //   System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from ������Ϣ��");  
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
        	conn=DBUtil.getConnection();   //�������ݿ�  
//          if(!conn.isClosed())  
//              System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from ������Ϣ��");  
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
        String opt = null;
        switch(op){
        case "�������":
        	opt = "Oid";
        	break;
        case "��Ʒ���":
        	opt = "Pid";
        	break;
        case "�ͻ����":
        	opt = "Cid";
        	break;
        case "״̬":
        	opt = "Osta";
        	break;
        case "����ʱ��":
        	opt = "Otim";
        	break;
        }
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�   
           	preparedStatement = conn.prepareStatement("select * from ������Ϣ�� where " + opt + " like '%" + seh + "%'");  
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
    public static int edit(String item,String Oid,String Pid,String Cid,String num,String tot,String sta,String dat,String not){  
        Connection conn;  
        PreparedStatement sql = null;  
        
  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�  
              
            if (item=="add") {
            	System.out.println("insert into ������Ϣ��(Oid,Pid,Cid,Onum,Otot,Osta,Odat,Onot) values('"+Oid+"','"+Pid+"','"+Cid+"','"+num+"','"+tot+"','"+sta+"','"+dat+"','"+not+"')");
            	sql = conn.prepareStatement("insert into ������Ϣ��(Oid,Pid,Cid,Onum,Otot,Osta,Odat,Onot) values('"+Oid+"','"+Pid+"','"+Cid+"','"+num+"','"+tot+"','"+sta+"','"+dat+"','"+not+"')");  
            } 
            else if(item=="edi") {
            	//System.out.println("update ����Ϣ�� set Cnam='"+nam+"',Cadd='"+add+"',Cpeo='"+peo+"',Ctel='"+tel+"',Cmai='"+mai+"',Cnot='"+not+"' where Cid='"+id+"'");    
            	sql = conn.prepareStatement("update ������Ϣ�� set Pid='"+Pid+"',Cid='"+Cid+"',Onum='"+num+"',Otot='"+tot+"',Osta='"+sta+"',Odat='"+dat+"',Onot='"+not+"' where Oid='"+Oid+"'"); 
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
        	conn=DBUtil.getConnection();    //�������ݿ�  
            sql = conn.prepareStatement("delete from ������Ϣ�� where Oid='"+id+"'"); 
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
        	conn=DBUtil.getConnection();    //�������ݿ�  
           // if(!conn.isClosed())  
           //   System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from ������Ϣ�� where Cid='"+row+"'");  
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

	//���ҿͻ�������Ӧ����
	public static Vector<Vector<String>> search(String type,String opt,String seh){
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();   //�������ݿ�   
            if (type=="Cli")
            	preparedStatement = conn.prepareStatement("select * from ������Ϣ�� where " + opt + "='" + seh + "'");
            else if (type=="Prd")
            	preparedStatement = conn.prepareStatement("select * from ������Ϣ�� where " + opt + "='" + seh + "'");
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
	
	//���㶩����
    public static Vector<Vector<String>> count(String opt,String seh){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�   
           	preparedStatement = conn.prepareStatement("select count(Oid) from (select * from ������Ϣ�� where " + opt + "='" + seh + "') aa");  
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
  //�����ܼ�
    public static Vector<Vector<String>> total(String opt,String seh){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�   
           	preparedStatement = conn.prepareStatement("select sum(Otot) from (select * from ������Ϣ�� where " + opt + "='" + seh + "') aa");  
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