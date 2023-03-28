
import com.vttanh.pojo.BoPhan;
import com.vttanh.services.BoPhanService;
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
public class BoPhanTester {
    
    private static Connection conn;
    private static BoPhanService bp;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(BoPhanTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp = new BoPhanService();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null)
            try {
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BoPhanTester.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @Test
    public void testTenTLKhongNull() {
        try {
            List<BoPhan> b= bp.getBoPhan();
            long k = b.stream().filter(c -> c.getTen()== null).count();
            Assertions.assertFalse(k > 0);
        } catch (SQLException ex) {
            Logger.getLogger(BoPhanTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testTenDTKhongTrung() {
        try {
            List<BoPhan> b = bp.getBoPhan();
            
            List<String> ten = b.stream().flatMap(c -> Stream.of(c.getTen())).collect(Collectors.toList());
            Set<String> testNames = new HashSet<>(ten);
            Assertions.assertEquals(ten.size(), testNames.size());
        } catch (SQLException ex) {
            Logger.getLogger(BoPhanTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
