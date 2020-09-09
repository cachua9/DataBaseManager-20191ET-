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
import myObj.SinhVienLop;

/**
 *
 * @author meolam39
 */
public class commandSinhVienLop {
    
    public static boolean insertSVL(SinhVienLop svl)
    {
        Connection conn = JDBCConnection.getJDBCConnection();
        try {            
            Statement statement = conn.createStatement();
            String sql= new String();
            if(svl.getDiem()!=-1) sql = "Insert into SinhVienLop(MaSV,MaLop,Diem) values('"+svl.getMaSV()+"','"+svl.getMaLop()+"',"+svl.getDiem()+")";   
            else sql = "Insert into SinhVienLop(MaSV,MaLop) values('"+svl.getMaSV()+"','"+svl.getMaLop()+"')"; 
            int rs =  statement.executeUpdate(sql);
            return rs>0;            
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return  false;
    }
    public static boolean updateSVL(SinhVienLop svl)
    {
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Update SinhVienLop set Diem = "+svl.getDiem() +" where MaSV = '"+svl.getMaSV()+"' and MaLop = '"+svl.getMaLop()+"'";   
            int rs =  statement.executeUpdate(sql);
            return rs>0;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    public static boolean deleteSVL(SinhVienLop svl)
    {
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Delete from SinhVienLop where MaSV = '"+svl.getMaSV()+"' and MaLop = '"+svl.getMaLop()+"'";
            int rs =  statement.executeUpdate(sql);
            return rs>0;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    
    public static ArrayList<SinhVienLop> getListSVL()
    {
        ArrayList<SinhVienLop> list =new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Select * from SinhVienLop"; 
            ResultSet rs =  statement.executeQuery(sql);
            SinhVienLop svl;
            while(rs.next())
            {
                svl=new SinhVienLop(rs.getString(1),rs.getString(2),rs.getDouble(3));
                list.add(svl);
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }        
        return list;
        
    } 
    
}
