/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vttanh.services;

import com.vttanh.pojo.BoPhan;
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
public class BoPhanService {
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
}
