package dao;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;  
import java.sql.SQLException;  
import java.util.Vector;  
  
public class PrdSQL {  
    // 得到数据库表数据  
    public static Vector<Vector<String>> getRows(){  
        Connection conn;  
        PreparedStatement preparedStatement = null;  
  
        Vector<Vector<String>> rows = null;  
        try {  
        	conn=DBUtil.getConnection();    //连接数据库  
           // if(!conn.isClosed())  
           //   System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 商品信息表");  
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
        	conn=DBUtil.getConnection();    //连接数据库  
//          if(!conn.isClosed())  
//              System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 商品信息表");  
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
        switch(op){
        case "商品编号":
        	opt = "Pid";
        	break;
        case "名称":
        	opt = "Pnam";
        	break;
        case "类别":
        	opt = "Ptyp";
        	break;
        case "产地":
        	opt = "Pbir";
        	break;
        case "制造商":
        	opt = "Ppro";
        	break;
        }
        try {  
        	conn=DBUtil.getConnection();   //连接数据库   
           	preparedStatement = conn.prepareStatement("select * from 商品信息表 where " + opt + " like '%" + seh + "%'");  
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
    public static int edit(String item,String id,String nam,String uni,String pri,String num,String typ, String bir, String pro, String not){  
        Connection conn;  
        PreparedStatement sql = null;  
        
  
        try {  
        	conn=DBUtil.getConnection();    //连接数据库  
              
            if (item=="add") {
            	//System.out.println("insert into 学生信息表(学号,姓名,性别,班级,系别,出生年月,籍贯) values('"+id+"','"+na+"','"+se+"','"+cl+"','"+ma+"','"+bi+"','"+ad+"')");
            	sql = conn.prepareStatement("insert into 商品信息表(Pid,Pnam,Puni,Ppri,Pnum,Ptyp,Pbir,Ppro,Pnot) values('"+id+"','"+nam+"','"+uni+"','"+pri+"','"+num+"','"+typ+"','"+bir+"','"+pro+"','"+not+"')");  
            } 
            else if(item=="edi")
            	//System.out.println("update 商品信息表 set Cnam='"+nam+"',Cadd='"+add+"',Cpeo='"+peo+"',Ctel='"+tel+"',Cmai='"+mai+"',Cnot='"+not+"' where Cid='"+id+"'");    
            	sql = conn.prepareStatement("update 商品信息表 set Pnam='"+nam+"',Puni='"+uni+"',Ppri='"+pri+"',Pnum='"+num+"',Ptyp='"+typ+"',Pbir='"+bir+"',Ppro='"+pro+"',Pnot='"+not+"' where Pid='"+id+"'"); 
            sql.executeUpdate();
            System.out.println("成功");
            
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            System.out.println("未成功打开数据库在。");  
            e.printStackTrace(); 
		}  
        return 0;  
    }
   
    //删除函数
    public static int del(String id){  
        Connection conn;  
        PreparedStatement sql = null;  
        try {  
        	conn=DBUtil.getConnection();   //连接数据库  
            sql = conn.prepareStatement("delete from 商品信息表 where Pid='"+id+"'"); 
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
        	conn=DBUtil.getConnection();    //连接数据库  
           // if(!conn.isClosed())  
           //   System.out.println("成功连接数据库");  
            preparedStatement = conn.prepareStatement("select * from 商品信息表 where Pid='"+row+"'");  
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