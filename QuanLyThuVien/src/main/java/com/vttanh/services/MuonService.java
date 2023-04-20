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
    public boolean themPhieuMuonSach(PhieuMuon p) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO phieumuon(id, Ten, NgayMuon, TrangThai, id_docgia) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, p.getId());
            stm.setString(2, p.getTen());
            stm.setDate(3, (Date.valueOf(p.getNgayMuon())));
            stm.setInt(4, p.getTrangThai());
            stm.setInt(5, p.getId_DocGia());
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

    public boolean SuaTrangThaiPM(PhieuMuon p) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);

            String sql = "UPDATE phieumuon SET TrangThai = '1' WHERE id = ?";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, p.getId());
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
            if (kw != null && !kw.isEmpty()) {
                sql += " WHERE Ten like concat('%', ?)";
            }

            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty()) {
                stm.setString(1, kw);
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhieuMuon q;
                q = new PhieuMuon(
                        rs.getString("Ten"),
                        rs.getDate("NgayMuon"),
                        rs.getInt("TrangThai"));
                d.add(q);
            }
        }
        return d;
    }

    public List<PhieuMuon> getPhieuMuonByid_DocGia(int idDocGia) throws SQLException {
        List<PhieuMuon> pm = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM phieumuon";
            sql += " WHERE id_docgia = ? ";
            sql += "and TrangThai like concat('0')";

            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, idDocGia);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                PhieuMuon q;
                q = new PhieuMuon(
                        rs.getString("id"),
                        rs.getString("Ten"),
                        rs.getDate("NgayMuon"),
                        rs.getInt("TrangThai"),
                        rs.getInt("id_docgia"));
                pm.add(q);
            }
        }
        return pm;
    }

    public List<PhieuMuon> getNgayMuon() throws SQLException {
        List<PhieuMuon> pm = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT id, NgayMuon FROM phieumuon";

            PreparedStatement stm = conn.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                PhieuMuon q;
                q = new PhieuMuon(
                        rs.getString("id"),
                        rs.getDate("NgayMuon"));
                pm.add(q);
            }
        }
        return pm;
    }

}
