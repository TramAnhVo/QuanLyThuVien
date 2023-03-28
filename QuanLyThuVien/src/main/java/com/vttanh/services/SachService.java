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
import java.sql.Statement;
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
    public List<Sach> getSach() throws SQLException {
        List<Sach> s = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM sach");
            while (rs.next()) {
                int idTL = rs.getInt("id_theloai");
                String Ten = rs.getString("Ten");
                String moTa = rs.getString("MoTa");
                String nXB = rs.getString("NXB");
                String sL = rs.getString("SoLuong");
                
                s.add(new Sach (Ten, moTa, nXB, sL, idTL));
            }
        }
        
        return s;
    } 
}
