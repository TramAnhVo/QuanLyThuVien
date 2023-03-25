/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.DocGia;
import com.vttanh.pojo.PhieuMuon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trâm Anh
 */
public class MuonService {
    public boolean themPhieuMuon( PhieuMuon p) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO phieumuon(Ten, NgayMuon, SDT, SoLuong) VALUES(?, ?, ?, ?)";
            
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, p.getTen());
            stm.setDate(2, (Date.valueOf(p.getNgayMuon())));
            stm.setString(3, p.getSDT());
            stm.setString(4, p.getSL());
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
    
    public List<PhieuMuon> xemThongTinPhieuMuon(String kw) throws SQLException {
        List<PhieuMuon> d = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM phieumuon";
            if (kw != null && !kw.isEmpty())
                sql += " WHERE Ten like concat('%', ?, '%', '%')";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty())
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhieuMuon q;
                q = new PhieuMuon(
                        rs.getInt("id"),
                        rs.getString("Ten"),
//                        rs.getDate("NgayMuon"),
                        rs.getString("SDT"),
                        rs.getString("SoLuong"));
                d.add(q);
            }
        }        
        return d;
    }
}
