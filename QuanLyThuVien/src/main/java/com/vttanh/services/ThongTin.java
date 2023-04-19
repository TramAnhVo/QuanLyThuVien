
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.DocGia;
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
public class ThongTin {
    
    public boolean ThemThongTin( DocGia k) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO docgia(id, HoTen, GioiTinh, NgaySinh, Email, SoDienThoai, DiaChi, NgayDangKi, HanThe, DoiTuong, BoPhan) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 

            PreparedStatement stm = conn.prepareCall(sql);
            stm.setInt(1, k.getId());
            stm.setString(2, k.getTen());
            stm.setInt(3, k.getGT());
            stm.setDate(4, (Date.valueOf(k.getNgaySinh())) );
            stm.setString(5, k.getEmail());
            stm.setString(6, k.getSDT());
            stm.setString(7, k.getDiaChi());
            stm.setDate(8, (Date.valueOf(k.getNgayDangKi())));
            stm.setDate(9, (Date.valueOf(k.getHanThe())));
            stm.setInt(10, k.getDoiTuong());
            stm.setInt(11, k.getBoPhan());
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
    
    public List<DocGia> xemThongTinDocGia() throws SQLException {
        List<DocGia> d = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM docgia";          
            PreparedStatement stm = conn.prepareCall(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                DocGia q;
                q = new DocGia(
                        rs.getInt("id"),
                        rs.getString("HoTen"),
                        rs.getDate("NgaySinh"),
                        rs.getInt("GioiTinh"),
                        rs.getString("SoDienThoai"),
                        rs.getDate("NgayDangKi"),
                        rs.getDate("HanThe"));
                d.add(q);
            }
        }        
        return d;
    }
    
    public List<DocGia> TimkiemThongTinDocGia(int kw) throws SQLException {
        List<DocGia> d = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM docgia";
             sql += " WHERE id = ?";
            
            PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, kw);
            
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("HoTen");
                Date ns = rs.getDate("NgaySinh");
                String email = rs.getString("Email");
                String sdt = rs.getString("SoDienThoai");
                String dc = rs.getString("DiaChi");
                Date ndk = rs.getDate("NgayDangKi");
                Date ht = rs.getDate("HanThe");
                d.add(new DocGia(id, ten, ns, email, sdt, dc, ndk, ht));
            }
           
        } 
        return d;
    }
}
