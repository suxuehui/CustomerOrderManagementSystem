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
        	conn=DBUtil.getConnection();    //连接数据库  
           // if(!conn.isClosed())  
           //   System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 用户表");  
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
      
	/**
	 *  得到用户数据库表头
	 */
    public static Vector<String> getHead(){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<String> columnHeads = null;  
          
        try {  
        	conn=DBUtil.getConnection();    //连接数据库  
//          if(!conn.isClosed())  
//              System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 用户表");  
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
    
    /**
	 *  得到数据库中下一行数据 
	 */  
    private static Vector<String> getNextRow(ResultSet rs,ResultSetMetaData rsmd) throws SQLException{  
        Vector<String> currentRow = new Vector<String>();  
        for(int i = 1; i <= rsmd.getColumnCount(); i++){  
            currentRow.addElement(rs.getString(i));  
        }  
        return currentRow;  
    }
    
    /**
	 *  编辑用户数据
	 */    
    public static int edit(String item,String id,String ty,String pwd){  
        Connection conn;  
        PreparedStatement sql = null;      
        try {  
        	conn=DBUtil.getConnection();   //连接数据库  
              
            if (item=="add") {
            	//System.out.println("insert into 学生信息表(学号,姓名,性别,班级,系别,出生年月,籍贯) values('"+id+"','"+na+"','"+se+"','"+cl+"','"+ma+"','"+bi+"','"+ad+"')");
            	sql = conn.prepareStatement("insert into 用户表 values('"+id+"','"+ty+"','"+pwd+"')");  
            } 
            else if(item=="edi")
            	//System.out.println("update 学生信息表 set '姓名'='"+na+"','性别'='"+se+"','系别'='"+ma+"','班级'='"+cl+"','出生年月'='"+bi+"','籍贯'='"+ad+"' where '学号'='"+id+"'");    
            	sql = conn.prepareStatement("update 用户表 set 用户类型='"+ty+"' where 用户名='"+id+"'"); 
                sql.executeUpdate();
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return 0;  
    }
    
    /**
	 *    查找区域功能的实现
	 */
    public static Vector<Vector<String>> search(String item,String n){
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();    //连接数据库   
            if (item=="usr")
            	preparedStatement = conn.prepareStatement("select * from 用户表 where 用户名='" + n + "'");  
            else if(item=="ty")
            	preparedStatement = conn.prepareStatement("select * from 用户表 where 用户类型='" + n + "'"); 
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
    
    

    
    /**
	 *  删除函数
	 */  
    public static int del(String id){   
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
        	conn=DBUtil.getConnection();   //连接数据库  
            sql = conn.prepareStatement("delete from 用户表 where 用户名='"+id+"'"); 
            sql.executeUpdate();
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return 0;  
    }
    
    /**
	 *  修改密码
	 */
    public static int cdpwd(String id,String pwd){  
        Connection conn;  
        PreparedStatement sql = null;      
        try {  
        	conn=DBUtil.getConnection();   
            sql = conn.prepareStatement("update 用户表 set 密码='"+pwd+"' where 用户名='"+id+"'");
            sql.executeUpdate();
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库。");  
            e.printStackTrace();  
        }  
        return 0;  
    }
}
