package dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.Vector;  
  
public class PrdSQL {  
    // �õ����ݿ������  
    public static Vector<Vector<String>> getRows(){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�  
           // if(!conn.isClosed())  
           //   System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from ��Ʒ��Ϣ��");  
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
        	conn=DBUtil.getConnection();    //�������ݿ�  
//          if(!conn.isClosed())  
//              System.out.println("�ɹ��������ݿ�");  
            preparedStatement = conn.prepareStatement("select * from ��Ʒ��Ϣ��");  
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
        switch(op){
        case "��Ʒ���":
        	opt = "Pid";
        	break;
        case "����":
        	opt = "Pnam";
        	break;
        case "���":
        	opt = "Ptyp";
        	break;
        case "����":
        	opt = "Pbir";
        	break;
        case "������":
        	opt = "Ppro";
        	break;
        }
        try {  
        	conn=DBUtil.getConnection();   //�������ݿ�   
           	preparedStatement = conn.prepareStatement("select * from ��Ʒ��Ϣ�� where " + opt + " like '%" + seh + "%'");  
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
    public static int edit(String item,String id,String nam,String uni,String pri,String num,String typ, String bir, String pro, String not){  
        Connection conn;  
        PreparedStatement sql = null;  
        
  
        try {  
        	conn=DBUtil.getConnection();    //�������ݿ�  
              
            if (item=="add") {
            	//System.out.println("insert into ѧ����Ϣ��(ѧ��,����,�Ա�,�༶,ϵ��,��������,����) values('"+id+"','"+na+"','"+se+"','"+cl+"','"+ma+"','"+bi+"','"+ad+"')");
            	sql = conn.prepareStatement("insert into ��Ʒ��Ϣ��(Pid,Pnam,Puni,Ppri,Pnum,Ptyp,Pbir,Ppro,Pnot) values('"+id+"','"+nam+"','"+uni+"','"+pri+"','"+num+"','"+typ+"','"+bir+"','"+pro+"','"+not+"')");  
            } 
            else if(item=="edi")
            	//System.out.println("update ��Ʒ��Ϣ�� set Cnam='"+nam+"',Cadd='"+add+"',Cpeo='"+peo+"',Ctel='"+tel+"',Cmai='"+mai+"',Cnot='"+not+"' where Cid='"+id+"'");    
            	sql = conn.prepareStatement("update ��Ʒ��Ϣ�� set Pnam='"+nam+"',Puni='"+uni+"',Ppri='"+pri+"',Pnum='"+num+"',Ptyp='"+typ+"',Pbir='"+bir+"',Ppro='"+pro+"',Pnot='"+not+"' where Pid='"+id+"'"); 
            sql.executeUpdate();
            System.out.println("�ɹ�");
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("δ�ɹ������ݿ��ڡ�");  
            e.printStackTrace(); 
		}  
        return 0;  
    }
   
    //ɾ������
    public static int del(String id){  
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
        	conn=DBUtil.getConnection();   //�������ݿ�  
            sql = conn.prepareStatement("delete from ��Ʒ��Ϣ�� where Pid='"+id+"'"); 
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
            preparedStatement = conn.prepareStatement("select * from ��Ʒ��Ϣ�� where Pid='"+row+"'");  
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