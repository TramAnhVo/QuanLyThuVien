/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.BoPhan;
import com.vttanh.pojo.DoiTuong;
import com.vttanh.pojo.GioiTinh;
import com.vttanh.pojo.TacGia;
import com.vttanh.pojo.TheLoai;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trâm Anh
 */
public class ThongTinChungService {
    public List<BoPhan> getBoPhan() throws SQLException {
        List<BoPhan> bp = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM bophan");
            while (rs.next()) {
                int id = rs.getInt("id");
                String Ten = rs.getString("TenBoPhan");
                bp.add(new BoPhan(id, Ten));
            }
        }
        
        return bp;
    }
    
    public List<GioiTinh> getGioiTinh() throws SQLException {
        List<GioiTinh> gt = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM gioitinh");
            while (rs.next()) {
                int id = rs.getInt("id");
                String Ten = rs.getString("Ten");
                gt.add(new GioiTinh(id, Ten));
            }
        }
        
        return gt;
    }
    
     public List<DoiTuong> getDoiTuongs() throws SQLException {
        List<DoiTuong> dt = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM doituong");
            while (rs.next()) {
                int id = rs.getInt("id");
                String Ten = rs.getString("Ten");
                dt.add(new DoiTuong(id, Ten));
            }
        }
        
        return dt;
    }  
     
    public List<TheLoai> getTheLoai() throws SQLException {
        List<TheLoai> tl = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM theloai");
            while (rs.next()) {
                int id = rs.getInt("id");
                String Ten = rs.getString("Ten");
                tl.add(new TheLoai(id, Ten));
            }
        }
        
        return tl;
    }
    
    public List<TacGia> getTacGia() throws SQLException {
        List<TacGia> tg = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("SELECT * FROM tacgia");
            while (rs.next()) {
                int id = rs.getInt("id");
                String Ten = rs.getString("Ten");
                tg.add(new TacGia(id, Ten));
            }
        }
        
        return tg;
    }
}
