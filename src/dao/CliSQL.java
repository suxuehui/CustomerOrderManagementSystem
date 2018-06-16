package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.Vector;

import dao.DBUtil;  
  
public class CliSQL {  
    // 得到数据库表数据  
    public static Vector<Vector<String>> getRows(){
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();
           // if(!conn.isClosed())  
           //   System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 客户信息表");  
            ResultSet result1 = preparedStatement.executeQuery();  
                            
            rows = new Vector<Vector<String>>();  
              
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
                
            }  
            //System.out.println("成功while");    
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return rows;  
    }  
      
    // 得到数据库表头  
    public static Vector<String> getHead(){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<String> columnHeads = null;  
          
        try {  
        	conn=DBUtil.getConnection();
//          if(!conn.isClosed())  
//              System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 客户信息表");  
            ResultSet result1 = preparedStatement.executeQuery();  
              
            columnHeads = new Vector<String>();  
            
            ResultSetMetaData rsmd = result1.getMetaData();  
            
            for(int i = 1; i <= rsmd.getColumnCount(); i++)  
                columnHeads.addElement(rsmd.getColumnName(i));  
              
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return columnHeads;  
    }  
      
    // 得到数据库中下一行数据  
    private static Vector<String> getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{  
        Vector<String> currentRow = new Vector<String>();  
        for(int i = 1; i <= rsmd.getColumnCount(); i++){  
            currentRow.addElement(rs.getString(i));  
        }  
        return currentRow;  
    }
   
    //查找区域功能的实现
    public static Vector<Vector<String>> search(String op,String seh){  
        Connection conn;  
        PreparedStatement preparedStatement = null;    
        Vector<Vector<String>> rows = null;  
        String opt = null;
        System.out.println(opt);   
        switch(op){
        case "客户编号":
        	opt = "Cid";
        	break;
        case "客户名称":
        	opt = "Cnam";
        	break;
        case "联系人":
        	opt = "Cpeo";
        	break;
        }
        System.out.println(opt);   
        try {  
        	conn=DBUtil.getConnection();
           	preparedStatement = conn.prepareStatement("select * from 客户信息表 where " + opt + " like '%" + seh + "%'");  
            ResultSet result1 = preparedStatement.executeQuery();  
                            
            rows = new Vector<Vector<String>>();  
              
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
                
            }  
            //System.out.println("成功while");    
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return rows;  
    }
    
    //编辑区域功能的实现
    public static int edit(String item,String id,String nam,String add,String peo,String tel,String mai,String not){ 
        Connection conn;  
        PreparedStatement sql = null;  
        
  
        try {  
        	conn=DBUtil.getConnection();
              
            if (item=="add") {
            	System.out.println("insert into 客户信息表(Cid,Cnam,Cadd,Cpeo,Ctel,Cmai,Cnot) values('"+id+"','"+nam+"','"+add+"','"+peo+"','"+tel+"','"+mai+"','"+not+"')");
            	sql = conn.prepareStatement("insert into 客户信息表(Cid,Cnam,Cadd,Cpeo,Ctel,Cmai,Cnot) values('"+id+"','"+nam+"','"+add+"','"+peo+"','"+tel+"','"+mai+"','"+not+"')");  
            } 
            else if(item=="edi") {
            	System.out.println("update 客户信息表 set Cnam='"+nam+"',Cadd='"+add+"',Cpeo='"+peo+"',Ctel='"+tel+"',Cmai='"+mai+"',Cnot='"+not+"' where Cid='"+id+"'");    
            	sql = conn.prepareStatement("update 客户信息表 set Cnam='"+nam+"',Cadd='"+add+"',Cpeo='"+peo+"',Ctel='"+tel+"',Cmai='"+mai+"',Cnot='"+not+"' where Cid='"+id+"'"); 
            }
            sql.executeUpdate();
            System.out.println("成功");
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return 0;  
    }
   
    //删除函数
    public static int del(String id){  
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
        	conn=DBUtil.getConnection();//连接数据库  
            sql = conn.prepareStatement("delete from 客户信息表 where Cid='"+id+"'"); 
            sql.executeUpdate();
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return 0;  
    }

    //返回列值
	public static Vector<?> getRow(Object row) {
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();   //连接数据库  
           // if(!conn.isClosed())  
           //   System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 客户信息表 where Cid='"+row+"'");  
            ResultSet result1 = preparedStatement.executeQuery();  
                            
            rows = new Vector<Vector<String>>();  
              
            ResultSetMetaData rsmd = result1.getMetaData();  
                      
            while(result1.next()){  
                rows.addElement(getNextRow(result1,rsmd));
                
            }  
            //System.out.println("成功while");    
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return rows;  
    }  
} 