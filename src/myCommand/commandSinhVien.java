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
import myObj.SinhVien;

/**
 *
 * @author meolam39
 */
public class commandSinhVien {
    
    
    public static boolean insertSV(SinhVien sv)
    {
        Connection conn = JDBCConnection.getJDBCConnection();
        try {            
            Statement statement = conn.createStatement();
            String sql = "Insert into SinhVien(MaSV,HoSV,TenSV,NgaySinh,NoiSinh) values('"+sv.getMaSV()+"','"+sv.getHoSV()+"','"+sv.getTenSV()+"','"+sv.getNgaySinh()+"','"+sv.getNoiSinh()+"')";      
            int rs =  statement.executeUpdate(sql);
            return rs>0;            
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return  false;
    }
    public static boolean updateSV(SinhVien sv)
    {
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Update SinhVien set HoSV = '"+sv.getHoSV()+"',TenSV = '"+sv.getTenSV()+"',NgaySinh = '"+sv.getNgaySinh()+"',NoiSinh = '"+sv.getNoiSinh() +"' where MaSV = '"+sv.getMaSV()+"'";      
            int rs =  statement.executeUpdate(sql);
            return rs>0;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    public static boolean deleteSV(SinhVien sv)
    {
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Delete from SinhVien where MaSV = '"+sv.getMaSV()+"'";
            int rs =  statement.executeUpdate(sql);
            return rs>0;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }      
    
    public static ArrayList<SinhVien> getListSV()
    {
        ArrayList<SinhVien> list =new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Select * from SinhVien"; 
            ResultSet rs =  statement.executeQuery(sql);
            SinhVien sv;
            while(rs.next())    
            {
                sv = new SinhVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                list.add(sv);
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }        
        return list;
        
    }  
    
    public static ArrayList<SinhVien> getListSearchSV(SinhVien svs)
    {
        ArrayList<SinhVien> list =new ArrayList<>();
        try {
            Connection conn = JDBCConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "Select * from SinhVien where "; 
            boolean check=false;
            if(svs.getMaSV().equals("")==false)
            {
                if(!check) check=true;
                else sql=sql+" and ";
                sql=sql+"MaSV = '"+svs.getMaSV()+"'";
            }
            if(svs.getHoSV().equals("")==false)
            {
                if(!check) check=true;
                else sql=sql+" and ";
                sql=sql+"HoSV = '"+svs.getHoSV()+"'";
            }
            if(svs.getTenSV().equals("")==false)
            {
                if(!check) check=true;
                else sql=sql+" and ";
                sql=sql+"TenSV = '"+svs.getTenSV()+"'";
            }
            if(svs.getNgaySinh().equals("")==false)
            {
                if(!check) check=true;
                else sql=sql+" and ";
                sql=sql+"NgaySinh = '"+svs.getNgaySinh()+"'";
            }
            if(svs.getNoiSinh().equals("")==false)
            {
                if(!check) check=true;
                else sql=sql+" and ";
                sql=sql+"NoiSinh = '"+svs.getNoiSinh()+"'";
            }      
            ResultSet rs =  statement.executeQuery(sql);
            SinhVien sv;
            while(rs.next())    
            {
                sv = new SinhVien(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                list.add(sv);
            }
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }        
        return list;        
    }  

}
