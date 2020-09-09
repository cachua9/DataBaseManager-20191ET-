/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myCommand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import myObj.MonHoc;

/**
 *
 * @author meolam39
 */
public class commandMonHoc {
    
    public static boolean insertMH(MonHoc mh)
    {
        Connection conn = JDBCConnection.getJDBCConnection();
        try {            
            Statement statement = conn.createStatement();
            String sql = "Insert into MonHoc(MaMH,TenMH,SoTC) values('"+mh.getMaMH()+"','"+mh.getTenMH()+"',"+mh.getSoTC()+")";      
            int rs =  statement.executeUpdate(sql);
            return rs>0;            
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return  false;
    }
    public static boolean updateMH(MonHoc mh)
    {
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Update MonHoc set TenMH = '"+mh.getTenMH()+"',SoTC = "+mh.getSoTC() +" where MaMH = '"+mh.getMaMH()+"'";      
            int rs =  statement.executeUpdate(sql);
            return rs>0;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    public static boolean deleteMH(MonHoc mh)
    {
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Delete from MonHoc where MaMH = '"+mh.getMaMH()+"'";
            int rs =  statement.executeUpdate(sql);
            return rs>0;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    
    public static ArrayList<MonHoc> getListMH()
    {
        ArrayList<MonHoc> list =new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Select * from MonHoc"; 
            ResultSet rs =  statement.executeQuery(sql);
            MonHoc mh;
            while(rs.next())
            {
                mh=new MonHoc(rs.getString(1),rs.getString(2),rs.getDouble(3));
                list.add(mh);
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }        
        return list;
        
    }  
  
}
