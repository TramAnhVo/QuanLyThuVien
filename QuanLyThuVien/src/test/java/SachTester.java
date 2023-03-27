
import com.vttanh.pojo.Sach;
import com.vttanh.services.JdbcUtils;
import com.vttanh.services.SachService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class SachTester {
    private static Connection conn ;
    private static SachService s;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        s = new SachService();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Test
    public void ThemSachThanhCong(){
        Sach t = new Sach("Doremon", "hoạt hình", "1987", "90", 0);
        
        try {
            boolean actual = s.themSach(t);
            Assertions.assertTrue(actual);
            
             PreparedStatement stm = conn.prepareCall("SELECT * FROM sach WHERE id=?");
            stm.setInt(1, t.getId());
            
            ResultSet rs = stm.executeQuery();
            Assertions.assertNotNull(rs.next());
            Assertions.assertEquals("Doremon", rs.getString("Ten"));
            Assertions.assertEquals("hoạt hình", rs.getString("MoTa"));
            Assertions.assertEquals("1987", rs.getString("NXB"));
            Assertions.assertEquals("90", rs.getString("SoLuon"));
            Assertions.assertEquals(1, rs.getInt("id_theloai"));
    }catch (SQLException ex) {
            Logger.getLogger(SachTester.class.getName()).log(Level.SEVERE, null, ex);
        }
}
//          
//        @Test
//        public void testTenSKhongNull () {
//            try {
//                List<Sach> sach = s.getSach(null);
//                long k = sach.stream().filter(c -> c.getTen() == null).count();
//                Assertions.assertFalse(k > 0);
//            } catch (SQLException ex) {
//                Logger.getLogger(TheLoaiTester.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }
        
}
