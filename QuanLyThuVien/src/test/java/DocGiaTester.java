
import com.vttanh.pojo.DocGia;
import com.vttanh.services.JdbcUtils;
import com.vttanh.services.ThongTin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
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
public class DocGiaTester {
    
    private static Connection conn ;
    private static ThongTin s;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JdbcUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        s = new ThongTin();
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DocGiaTester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Test
    public void ThemThongTinThanhCong(){
           DocGia n = new DocGia("Bích Huyền", LocalDate.of(2002, 9, 21), "Nữ", "2051050172huyen@ou.edu.vn", "0386858149", "Nguyễn văn công, p3, quận Gò Vấp", 0, 0);
          try {
            boolean actual = s.ThemThongTin(n);
            Assertions.assertTrue(actual);
            
            PreparedStatement stm = conn.prepareCall("SELECT * FROM docgia WHERE id=?");
            stm.setInt(1, n.getId());
            
            ResultSet rs = stm.executeQuery();
            Assertions.assertNotNull(rs.next());
            Assertions.assertEquals("Bích Huyền", rs.getString("HoTen"));
            Assertions.assertEquals(LocalDate.of(2002, 9, 21), rs.getDate("NgaySinh"));
            Assertions.assertEquals("2051050172huyen@ou.edu.vn", rs.getString("Email"));
            Assertions.assertEquals("0386858149", rs.getString("SoDienThoai"));
            Assertions.assertEquals("Nguyễn văn công, p3, quận Gò Vấp", rs.getString("DiaChi"));
            Assertions.assertEquals(0, rs.getInt("DoiTuong"));
            Assertions.assertEquals(0, rs.getInt("BoPhan"));
        } catch (SQLException ex) {
            Logger.getLogger(DocGiaTester.class.getName()).log(Level.SEVERE, null, ex);
        }
     }          
            
}
