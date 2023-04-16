/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trâm Anh
 */
public class SachService {
    public boolean themSach(Sach s) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);
            
           String sql = "INSERT INTO sach(id, Ten, MoTa, NXB, SoLuong, id_theloai) VALUES(?, ?, ?, ?, ?, ?)";
           PreparedStatement stm = conn.prepareCall(sql);
           stm.setInt(1, s.getId());
           stm.setString(2, s.getTen());
           stm.setString(3, s.getMoTa());
           stm.setString(4, s.getNXB());
           stm.setString(5, s.getSoLuong());
           stm.setInt(6,s.getTheLoai());
           stm.executeUpdate();
           
          try {
                conn.commit();
                return true;
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                return false;
            }          
        }
    }
    
    public List<Sach> xemThongTinSach(String kw) throws SQLException {
        List<Sach> d = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM sach";
            if (kw != null && !kw.isEmpty())
                sql += " WHERE Ten like concat('%', ?)";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty())
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Sach q;
                q = new Sach(
                        rs.getInt("id"),
                        rs.getString("Ten"),
                        rs.getString("MoTa"),
                        rs.getString("NXB"),
                        rs.getString("SoLuong"));
                d.add(q);
            }
        }        
        return d;
    }
}
