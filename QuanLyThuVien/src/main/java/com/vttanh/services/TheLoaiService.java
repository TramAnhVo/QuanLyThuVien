/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

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
public class TheLoaiService {
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
    
}
