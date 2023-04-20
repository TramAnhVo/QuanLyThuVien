/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.PhieuMuonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Trâm Anh
 */
public class PhieuMuonChiTietService {
     public boolean themPhieuMCT(ObservableList<PhieuMuonChiTiet> dspmct) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO phieumuonchitiet(id, TenSach, SoLuongMuon, SoLuongChuaTra, idPhieuMuon, TrangThai, id_sach) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareCall(sql);
            for (PhieuMuonChiTiet p : dspmct) {
                stm.setString(1, p.getId());
                stm.setString(2, p.getTen());
                stm.setString(3, p.getSL());
                stm.setString(4, p.getSLCT());
                stm.setString(5, p.getId_PhieuMuon());
                stm.setInt(6, p.getTrangThai());
                stm.setInt(7, p.getId_Sach());
                stm.executeUpdate();
            }
            try {
                conn.commit();
                return true;
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    public boolean SuaPMCT(PhieuMuonChiTiet p) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);

            String sql = "UPDATE phieumuonchitiet SET SoLuongChuaTra = ? , TrangThai = ? WHERE id = ?";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, p.getSLCT());
            stm.setInt(2, p.getTrangThai());
            stm.setString(3, p.getId());
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

    public List<PhieuMuonChiTiet> ThongTinPMCT(String kw) throws SQLException {
        List<PhieuMuonChiTiet> d = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM phieumuonchitiet";
            if (kw != null && !kw.isEmpty()) {
                sql += " WHERE Ten like concat('%', ?)";
            }

            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty()) {
                stm.setString(1, kw);
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhieuMuonChiTiet p;
                p = new PhieuMuonChiTiet(
                        rs.getString("TenSach"),
                        rs.getString("SoLuongMuon"),
                        rs.getString("idPhieuMuon"),
                        rs.getInt("TrangThai"));
                d.add(p);
            }
        }
        return d;
    }

    public List<PhieuMuonChiTiet> getPhieuMuonCTByIDPM(String idPM) throws SQLException {
        List<PhieuMuonChiTiet> pmCT = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM phieumuonchitiet";
            sql += " WHERE idPhieuMuon = ? ";
            sql += "and TrangThai like concat('0')";
            
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, idPM);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhieuMuonChiTiet q;
                q = new PhieuMuonChiTiet(
                        rs.getString("id"),
                        rs.getString("TenSach"),
                        rs.getString("SoLuongMuon"),
                        rs.getString("SoLuongChuaTra"),
                        rs.getString("idPhieuMuon"),
                        rs.getInt("TrangThai"),
                        rs.getInt("id_sach"));
                pmCT.add(q);
            }
        }
        return pmCT;
    }
    
    public List<PhieuMuonChiTiet> getSLPhieuMuonCT(String idphieumuon) throws SQLException {

        List<PhieuMuonChiTiet> pMCT = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT SoLuongMuon FROM phieumuonchitiet";
            
             if (idphieumuon != null && !idphieumuon.isEmpty()) {
                sql += " WHERE idPhieuMuon = ? ";
            }
             
            PreparedStatement stm = conn.prepareCall(sql);
            if (idphieumuon != null && !idphieumuon.isEmpty()) {
                stm.setString(1, idphieumuon);
            }
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhieuMuonChiTiet q;
                q = new PhieuMuonChiTiet(
                        rs.getString("SoLuongMuon"));
                pMCT.add(q);
            }
        }
        return pMCT;
    }
}
