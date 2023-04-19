/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.DatSach;
import java.sql.Connection;
import java.sql.Date;
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
public class DatSachServices {
     public boolean themDatSach(DatSach s) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);
            
           String sql = "INSERT INTO datsach(Ten, GT, SDT, Email, NgayDat, SL) VALUES(?, ?, ?, ?, ?, ?)";
           PreparedStatement stm = conn.prepareCall(sql);
           stm.setString(1, s.getTen());
           stm.setInt(2, s.getGT());
           stm.setString(3, s.getSDT());
           stm.setString(4, s.getEmail());
           stm.setDate(5, (Date.valueOf(s.getNgayDat1())));
           stm.setString(6, s.getSL());
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
    
    public List<DatSach> xemThongTinDatSach() throws SQLException {
        List<DatSach> d = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM datsach";          
            Statement stm = conn.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
               DatSach q;
                q = new DatSach(
                        rs.getInt("id"),
                        rs.getString("Ten"),
                        rs.getInt("GT"),
                        rs.getString("SDT"),
                        rs.getString("Email"),
                        rs.getDate("NgayDat"),
                        rs.getString("SL"));
                d.add(q);
            }
        }        
        return d;
    }
    
}
