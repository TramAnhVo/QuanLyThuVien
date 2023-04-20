/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.PhieuTra;
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
public class PhieuTraService {
    public boolean themPhieuTra(PhieuTra p) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);

            String sql = "INSERT INTO phieutra(id, TenSach, SoLuong, NgayTra, idPhieuMuonCT, TienPhat) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setInt(1, p.getId());
            stm.setString(2, p.getTen());
            stm.setString(3, p.getSL());
            stm.setDate(4, (Date.valueOf(p.getNgayTra())));
            stm.setString(5, p.getId_PhieuMuonct());
            stm.setFloat(6, p.getTienPhat());
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

    public List<PhieuTra> getSLPhieuTra() throws SQLException {

        List<PhieuTra> pT = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT SoLuong FROM phieutra";

            PreparedStatement stm = conn.prepareCall(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhieuTra q;
                q = new PhieuTra(
                        rs.getString("SoLuong"),
                        rs.getDate("NgayTra"));
                pT.add(q);
            }
        }
        return pT;
    }
}
