/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.PhieuMuon;
import com.vttanh.pojo.PhieuMuonChiTiet;
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
public class MuonService {
    public boolean themPhieuMuonSach( PhieuMuon p) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);
            
            String sql = "INSERT INTO phieumuon VALUES(?, ?, ?, ?)";            
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setInt(1,p.getId());
            stm.setString(2, p.getTen());
            stm.setDate(3, (Date.valueOf(p.getNgayMuon())));
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
    
     public boolean themPhieuMCT( PhieuMuonChiTiet p) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);
            
            String sql = "INSERT INTO phieumuonchitiet(id, TenSach, SL, id_phieumuon) VALUES(?, ?, ?, ?)";            
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setInt(1,p.getId());
            stm.setString(2, p.getTen());
            stm.setString(3, p.getSL());
            stm.setInt(4, p.getId_PhieuMuon());
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
                sql += " WHERE TenDG like concat('%', ?)";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty())
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhieuMuon q;
                q = new PhieuMuon(
                        rs.getInt("id"),
                        rs.getString("TenDG"),
                        rs.getString("SDT"),
                        rs.getDate("NgayMuon"),
                        rs.getString("SLTong"));
                d.add(q);
            }
        }        
        return d;
    }
    
    public List<PhieuMuonChiTiet> ThongTinPMCT(String kw) throws SQLException {
        List<PhieuMuonChiTiet> d = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM phieumuonchitiet";
            if (kw != null && !kw.isEmpty())
                sql += " WHERE Ten like concat('%', ?)";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty())
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhieuMuonChiTiet p;
                p = new PhieuMuonChiTiet(
                        rs.getInt("id"),
                        rs.getString("TenSach"),
                        rs.getString("SL"),
                        rs.getInt("id_phieumuon"));
                d.add(p);
            }
        }        
        return d;
    }

}
