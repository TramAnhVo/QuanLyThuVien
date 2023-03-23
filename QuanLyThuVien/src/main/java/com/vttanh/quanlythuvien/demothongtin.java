/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.quanlythuvien;

import com.vttanh.pojo.NguoiDoc;
import com.vttanh.services.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Trâm Anh
 */
public class demothongtin {
    public List<NguoiDoc> DemoDocDL(String kw) throws SQLException {
        List<NguoiDoc> d = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM nguoidoc";
            if (kw != null && !kw.isEmpty())
                sql += " WHERE Ten like concat('%', ?)";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty())
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                NguoiDoc q = new NguoiDoc(
                    rs.getInt("id"),
                    rs.getString("Ten"));
                d.add(q);
            }
        }
        
        return d;
    }
    
     public List<NguoiDoc> getDL() throws SQLException {
        List<NguoiDoc> bp = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM nguoidoc");
            while (rs.next()) {
                int id = rs.getInt("id");
                String Ten = rs.getString("Ten");
                bp.add(new NguoiDoc(id, Ten));
            }
        }        
        return bp;
    }
    
    
}
