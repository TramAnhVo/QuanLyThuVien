
import com.vttanh.pojo.TacGia;
import com.vttanh.services.JdbcUtils;
//import com.vttanh.services.
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
public class TacGiaTester {
    private static Connection conn;
//    private static TacGiaService tg;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiTester.class.getName()).log(Level.SEVERE, null, ex);
        }
//        TacGiaService tg = new TacGiaService();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null)
            try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(TheLoaiTester.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
//    @Test
//    public void testTenTGKhongNull() {
//        try {
//            List<TacGia> t = tg.getTacGia();
//            long k = t.stream().filter(c -> c.getTentg()== null).count();
//            Assertions.assertFalse(k > 0);
//        } catch (SQLException ex) {
//            Logger.getLogger(TacGiaTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @Test
//    public void testTenTGKhongTrung() {
//        try {
//            List<TacGia> t = tg.getTacGia();
//            
//            List<String> ten = t.stream().flatMap(c -> Stream.of(c. getTentg())).collect(Collectors.toList());
//            Set<String> testNames = new HashSet<>(ten);
//            Assertions.assertEquals(ten.size(), testNames.size());
//        } catch (SQLException ex) {
//            Logger.getLogger(TacGiaTester.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
