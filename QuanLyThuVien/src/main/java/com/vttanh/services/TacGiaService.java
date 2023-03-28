/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.TacGia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TacGiaService {
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
