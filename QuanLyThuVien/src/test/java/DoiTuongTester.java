
import com.vttanh.pojo.DoiTuong;
import com.vttanh.services.DoiTuongServices;
import com.vttanh.services.JdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
public class DoiTuongTester {
    private static Connection conn;
    private static DoiTuongServices dt;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(DoiTuongTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        dt = new DoiTuongServices();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null)
            try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DoiTuongTester.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Test
    public void testTenKhongNull() {
        try {
            List<DoiTuong> d = dt.getDoiTuongs();
            long k = d.stream().filter(c -> c.getTen()== null).count();
            Assertions.assertFalse(k > 0);
        } catch (SQLException ex) {
            Logger.getLogger(DoiTuongTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testTenKhongTrung() {
        try {
            List<DoiTuong> d = dt.getDoiTuongs();
            
            List<String> ten = d.stream().flatMap(c -> Stream.of(c.getTen())).collect(Collectors.toList());
            Set<String> testTen = new HashSet<>(ten);
            Assertions.assertEquals(ten.size(), testTen.size());
        } catch (SQLException ex) {
            Logger.getLogger(DoiTuongTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
