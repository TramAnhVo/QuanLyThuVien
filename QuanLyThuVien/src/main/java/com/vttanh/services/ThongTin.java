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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 *
 * @author Trâm Anh
 */
public class ThongTin {
    protected static final SimpleDateFormat f = new  SimpleDateFormat("yyyy-MM-dd");
    protected static final SimpleDateFormat e = new SimpleDateFormat("dd-mm-yyyy");
    
    public boolean ThemThongTin( DocGia k) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            conn.setAutoCommit(false);
            String sql = "INSERT INTO docgia(id, HoTen, GioiTinh, NgaySinh, Email, SoDienThoai, DiaChi, NgayDangKi, DoiTuong, BoPhan) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
            // SQL injection
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setInt(1, k.getId());
            stm.setString(2, k.getTen());
            stm.setString(3, k.getGT());
            stm.setDate(4, (Date.valueOf(k.getNgaySinh1())) );
            stm.setString(5, k.getEmail());
            stm.setString(6, k.getSDT());
            stm.setString(7, k.getDiaChi());
            stm.setDate(8, (Date.valueOf(k.getNgayDangKi1())));
            stm.setInt(9, k.getDoiTuong());
            stm.setInt(10, k.getBoPhan());
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
    
    public List<DocGia> xemThongTinDocGia(String kw) throws SQLException {
        List<DocGia> d = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM docgia";
            if (kw != null && !kw.isEmpty())
                sql += " WHERE HoTen like concat('%', ?)";
            
            PreparedStatement stm = conn.prepareCall(sql);
            if (kw != null && !kw.isEmpty())
                stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                DocGia q;
                q = new DocGia(
                        rs.getInt("id"),
                        rs.getString("HoTen"),
                        rs.getDate("NgaySinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("SoDienThoai"),
                        rs.getDate("NgayDangKi"));
                d.add(q);
            }
        }        
        return d;
    }
    
}
